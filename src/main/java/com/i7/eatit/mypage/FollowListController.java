package com.i7.eatit.mypage;

import com.i7.eatit.domain.picture.service.PhotoService;
import com.i7.eatit.domain.relationship.dto.FollowInfoDetailDTO;
import com.i7.eatit.domain.relationship.dto.FollowListPageDTO;
import com.i7.eatit.domain.relationship.service.UserFollowService;
import com.i7.eatit.domain.user.dto.UserInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/my-page/*")
@Controller
public class FollowListController {

    private final UserFollowService userFollowService;
    private final PhotoService photoService;
    private int pageRow=5;

    public FollowListController(UserFollowService userFollowService, PhotoService photoService) {
        this.userFollowService = userFollowService;
        this.photoService = photoService;
    }


    @GetMapping("follow-list")
    public String followList(@SessionAttribute(name = "loginUser") UserInfoDTO loginUser, Model model, @RequestParam(required = false) Integer page) {

        int followCnt = userFollowService.countFollowMember(loginUser.getMember_id());
        int totalPage = (int) Math.ceil((double) followCnt / pageRow); // 총 페이지 수 계산
//        System.out.println("팔로우 숫자: " + followCnt);

        if (page == null) {
            return "redirect:/my-page/follow-list?page=1"; // 페이지가 없으면 첫 페이지로 리다이렉트
        }

        if (page > totalPage) {
            return "redirect:/my-page/follow-list?page=" + totalPage; // 페이지가 총 페이지 수를 넘으면 마지막 페이지로 리다이렉트
        }

        int pageStartIndex = (page - 1) * pageRow; // 페이지의 시작 인덱스 계산
        List<FollowInfoDetailDTO> followDetailList = userFollowService.findFollowMemberPage(loginUser.getMember_id(), pageStartIndex, pageRow);


        List<FollowListPageDTO> followList= new ArrayList<>();
        for (FollowInfoDetailDTO detailFollow:followDetailList){
            followList.add(new FollowListPageDTO(
                    detailFollow.getFolloweeId(),
                    detailFollow.getDetailProfile().getNickname(),
                    detailFollow.getDetailProfile().getMemberPhoto().getPhotoPath()));
        }


        System.out.println("페이지: " + page);
        System.out.println("일부 팔로우 리스트");
        System.out.println(followList);

        List<Integer> paginationList = createPaginationList(model, page, totalPage); // 페이지네이션 리스트 생성
        model.addAttribute("currentPage", page);
        model.addAttribute("paginationList", paginationList);
        model.addAttribute("followList", followList);

        return "my-page/follow-list"; // 뷰 이름 반환
    }

    private List<Integer> createPaginationList(Model model, int currentPage, int totalPage) {
        int pageStart, pageEnd;
        boolean showPrev = false, showNext = false;

        if (totalPage <= 5) {
            pageStart = 1;
            pageEnd = totalPage;
        } else {
            int currentPageGroup = (currentPage - 1) / 5;
            pageStart = currentPageGroup * 5 + 1;
            pageEnd = Math.min(pageStart + 4, totalPage);

            showPrev = currentPageGroup > 0;
            showNext = pageEnd < totalPage;
        }

        List<Integer> paginationList = new ArrayList<>();
        for (int i = pageStart; i <= pageEnd; i++) {
            paginationList.add(i);
        }

        model.addAttribute("prevPage", showPrev);
        model.addAttribute("nextPage", showNext);

        return paginationList;
    }

    @PostMapping("follow-user-delete")
    public String followUserDelete(@RequestParam("memberId") int followeeId, @SessionAttribute("loginUser") UserInfoDTO loginUser){

        int followCnt = userFollowService.countFollowMember(loginUser.getMember_id());
        int totalPage = followCnt / pageRow + (followCnt % pageRow > 0 ? 1 : 0);

        userFollowService.deleteFollowMember(loginUser.getMember_id(),followeeId);

        return "redirect:/my-page/follow-list?page="+totalPage;
    }

    @GetMapping("follow-list-test")
    public String followListTest(Model model){

        List<FollowInfoDetailDTO> followList= userFollowService.findFollowMember(1);

        model.addAttribute("followList", followList);

        System.out.println(followList);

        return "my-page/follow-list";
    }

}

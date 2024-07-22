package com.i7.eatit.domain.picture.service;

import com.i7.eatit.domain.picture.dao.PhotoMapper;
import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PhotoService {

    private PhotoMapper photoMapper;

    public PhotoService(PhotoMapper photoMapper) {
        this.photoMapper = photoMapper;
    }

    public MemberPhotoDTO findPhotoByMemberId(int userId){

        return photoMapper.findPhotoByMemberId(userId);

    }

    public List<MeetingPhotoDTO> findPhotoByMeetingId(int meetingId){

        return photoMapper.findPhotoByMeetingId(meetingId);
    }

    @Transactional
    public String uploadMemberPhoto(MultipartFile singleImageFile, MemberPhotoDTO memberPhoto){

        System.out.println("singleImageFile = " + singleImageFile);

        String root="src/main/resources/static";
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);
        System.out.println(dir.getAbsolutePath());

        if(!dir.exists()) {
            dir.mkdirs();
        }

        String resultMessage="실패";

        /* 파일명 변경 처리 */
        String originFileName = singleImageFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-","") + ext;

        try {
            singleImageFile.transferTo(new File(filePath + "/" + savedName));
            photoMapper.uploadMemberPhoto(memberPhoto);
            resultMessage="성공";
//            model.addAttribute("message", "파일 업로드 성공!");
        } catch (Exception e) {
            e.printStackTrace();
            //model.addAttribute("message", "파일 업로드 실패!!");
        }
        System.out.println(resultMessage);


        return resultMessage;
    }

}

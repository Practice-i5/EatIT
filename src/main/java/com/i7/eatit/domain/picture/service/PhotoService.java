package com.i7.eatit.domain.picture.service;

import com.i7.eatit.domain.picture.dao.PhotoMapper;
import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
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
    private ResourceLoader resourceLoader;

    public PhotoService(PhotoMapper photoMapper, ResourceLoader resourceLoader) {
        this.photoMapper = photoMapper;
        this.resourceLoader = resourceLoader;
    }

    public MemberPhotoDTO findPhotoByMemberId(int userId){

        return photoMapper.findPhotoByMemberId(userId);

    }

    public List<MeetingPhotoDTO> findPhotoByMeetingId(int meetingId){

        return photoMapper.findPhotoByMeetingId(meetingId);
    }

    @Transactional
    public String uploadMemberPhoto(MultipartFile singleImageFile, int memberId) throws IOException {

        System.out.println("singleImageFile = " + singleImageFile);

        Resource resource = resourceLoader.getResource("classpath:static/img/single");
        String filePath = null;

        if(!resource.exists()){
            // 만약 static 폴더에 파일이 없는 경우 만들어 준다.
            // 초기 해당 디렉토리가 없는 경우 서버 리로드해야 한다.
            // spring에서 resources를 읽어와야 하는데 해당 경로가 없어 이미지를 초기에 보여줄 수 없는 상황이다.
            String root = "src/main/resources/static/img/single";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();
        }else{
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();
        }


        System.out.println("multi : "+ filePath);
        String resultMessage=null;

        /* 파일명 변경 처리 */
        String originFileName = singleImageFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

        try {
            singleImageFile.transferTo(new File(filePath + "/" + savedName));
            //photoMapper.uploadMemberPhoto(memberPhoto);
            resultMessage="/static/img/single/"+savedName;
            System.out.println("파일 업로드 성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일 업로드 실패");
        }

        return resultMessage;
    }

}

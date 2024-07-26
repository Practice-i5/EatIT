package com.i7.eatit.domain.picture.service;

import com.i7.eatit.domain.picture.dao.PhotoMapper;
//import com.i7.eatit.domain.picture.drive.DriveExample;
import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class PhotoService {

    private PhotoMapper photoMapper;
    private FireBaseService fireBaseService;

    public PhotoService(PhotoMapper photoMapper, FireBaseService fireBaseService) {
        this.photoMapper = photoMapper;
        this.fireBaseService = fireBaseService;
    }

    public MemberPhotoDTO findPhotoByMemberId(int userId){

        return photoMapper.findPhotoByMemberId(userId);

    }

    public String getPhotoUrlByPath(String path){
        return fireBaseService.getFileUrl(fireBaseService.getFileUrl(path));
    }

    public List<MeetingPhotoDTO> findPhotoByMeetingId(int meetingId){

        return photoMapper.findPhotoByMeetingId(meetingId);
    }

    @Transactional
    public String uploadMemberPhoto(MultipartFile singleImageFile, int memberId) throws IOException {

        System.out.println("singleImageFile = " + singleImageFile);

        /* 파일명 변경 처리 */
        String originFileName = singleImageFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

        try {
            //singleImageFile.transferTo(new File(filePath + "/" + savedName));
            //String uploadFileId = DriveExample.uploadFile(singleImageFile);
            fireBaseService.uploadFiles(singleImageFile, "memberImage/"+savedName);

            MemberPhotoDTO memberPhoto = new MemberPhotoDTO();
            memberPhoto.setMemberId(memberId);
            memberPhoto.setPhotoPath("memberImage/"+savedName);
            //memberPhoto.setPhotoPath("https://drive.google.com/thumbnail?id="+uploadFileId+"&sz=w300");
            memberPhoto.setPhotoName(originFileName);

            photoMapper.uploadMemberPhoto(memberPhoto);

            System.out.println("업로드 성공");
            return fireBaseService.getFileUrl("memberImage/"+savedName);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일 업로드 실패");
        }

        return "";
    }

    @Transactional
    public void uploadMeetingPhoto(List<MultipartFile> meetingPhotoFileList, int meetingId){

        List<String> uploadedFilePathList=new ArrayList<>();
        
        try{
            for (MultipartFile meetingPhotoFile:meetingPhotoFileList){
                String originFileName = meetingPhotoFile.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                fireBaseService.uploadFiles(meetingPhotoFile, "meetingImage/"+savedName);
                
                MeetingPhotoDTO meetingPhoto = new MeetingPhotoDTO();
                meetingPhoto.setMeetingId(meetingId);
                meetingPhoto.setPhotoPath("meetingImage/"+savedName);
                meetingPhoto.setPhotoName(originFileName);

                uploadedFilePathList.add(meetingPhoto.getPhotoPath());
                photoMapper.uploadMeetingPhoto(meetingPhoto);
            }
            System.out.println("업로드 완료");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("업로드 실패");
            for (String uploadedFilePath:uploadedFilePathList){
                fireBaseService.deleteFirebaseBucket(uploadedFilePath);
            }
        }
    }

    @Transactional
    public void deleteMeetingPhoto(int meetingId){
        photoMapper.deleteMeetingPhoto(meetingId);
    }

    @Transactional
    public void deleteOneMeetingPhoto(int meetingId, int photoId){
        Map<String, Integer> photoMap = new HashMap<>();
        photoMap.put("meetingId", meetingId);
        photoMap.put("photoId", photoId);

        photoMapper.deleteOneMeetingPhoto(photoMap);
    }

}

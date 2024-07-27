package com.i7.eatit.domain.picture.service;

import com.i7.eatit.domain.picture.dao.PhotoMapper;
//import com.i7.eatit.domain.picture.drive.DriveExample;
import com.i7.eatit.domain.picture.dto.MeetingPhotoDTO;
import com.i7.eatit.domain.picture.dto.MemberPhotoDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class PhotoService {

    private PhotoMapper photoMapper;
    private FileUploadService fileUploadService;

    public PhotoService(PhotoMapper photoMapper, FileUploadService fileUploadService) {
        this.photoMapper = photoMapper;
        this.fileUploadService = fileUploadService;
    }

    public MemberPhotoDTO findPhotoByMemberId(int userId){

        return photoMapper.findPhotoByMemberId(userId);

    }

    public String getPhotoUrlByPath(String path){
        return fileUploadService.getSourceFromPath(path);
    }

    public MeetingPhotoDTO findPhotoByMeetingId(int meetingId){

        return photoMapper.findPhotoByMeetingId(meetingId);
    }

    @Transactional
    public String uploadMemberPhoto(MultipartFile singleImageFile, int memberId) {

        System.out.println("singleImageFile = " + singleImageFile);

        /* 파일명 변경 처리 */
        String originFileName = singleImageFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

        try {
            //singleImageFile.transferTo(new File(filePath + "/" + savedName));
            //String uploadFileId = DriveExample.uploadFile(singleImageFile);
            fileUploadService.uploadFile(singleImageFile, "memberImage/"+savedName);

            MemberPhotoDTO memberPhoto = new MemberPhotoDTO();
            memberPhoto.setMemberId(memberId);
            memberPhoto.setPhotoPath("memberImage/"+savedName);
            memberPhoto.setPhotoName(originFileName);

            photoMapper.uploadMemberPhoto(memberPhoto);

            System.out.println("업로드 성공");

            String Url = fileUploadService.getSourceFromPath("memberImage/"+savedName);
            System.out.println("반환 url : "+ Url);
            return Url;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("파일 업로드 실패");
        }

        return "";
    }

    @Transactional
    public String uploadMeetingPhoto(MultipartFile meetingPhotoFile, int meetingId){

        String originFileName = meetingPhotoFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-", "") + ext;
        
        try{
            fileUploadService.uploadFile(meetingPhotoFile, "meetingImage/"+savedName);

            MeetingPhotoDTO meetingPhoto = new MeetingPhotoDTO();
            meetingPhoto.setMeetingId(meetingId);
            meetingPhoto.setPhotoPath("meetingImage/"+savedName);
            meetingPhoto.setPhotoName(originFileName);

            photoMapper.uploadMeetingPhoto(meetingPhoto);
            System.out.println("업로드 완료");

            String Url = fileUploadService.getSourceFromPath("meetingImage/"+savedName);
            System.out.println("반환 url : "+ Url);
            return Url;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("업로드 실패");
        }

        return "";
    }

    @Transactional
    public void deleteMemberPhoto(int memberId){
        photoMapper.deleteMemberPhoto(memberId);
    }

    @Transactional
    public void deleteMeetingPhoto(int meetingId){
        photoMapper.deleteMeetingPhoto(meetingId);
    }

}

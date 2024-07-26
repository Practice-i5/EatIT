package com.i7.eatit.domain.picture.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    String getSourceFromPath(String filePath);
    String uploadFile(MultipartFile file, String filePath) throws IOException;
    void deleteFile(String filePath);
}

package com.i7.eatit.domain.picture.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;

@Service
public class FireBaseService implements FileUploadService {

    @Value("${app.firebase-bucket}")
    private String firebaseBucket;

    public String uploadFile(MultipartFile file, String filePath) throws IOException {
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());
        Blob blob = bucket.create(filePath, content, file.getContentType());
        return blob.getMediaLink();
    }

    @Override
    public String getPathFromUrl(String url) {
        try {
            // URL에서 파일 경로 부분 추출
            String encodedPath = url.split("o/")[1].split("\\?")[0];
            // URL 디코딩
            String decodedPath = URLDecoder.decode(encodedPath, StandardCharsets.UTF_8.toString());

            System.out.println("얻어진 파이어베이스 경로 : "+ decodedPath);

            return decodedPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing URL";
        }

    }

    public String getSourceFromPath(String filePath) {
        try {
            Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
            Blob blob = bucket.get(filePath);
            if (blob != null) {
                String FileUrl = String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media",
                        firebaseBucket, URLEncoder.encode(filePath, StandardCharsets.UTF_8.toString()));
               //return blob.signUrl(1, TimeUnit.HOURS).toString();
                return FileUrl;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteFile(String filePath) {
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        bucket.get(filePath).delete();
    }
}
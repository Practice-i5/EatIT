package com.i7.eatit.domain.picture.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;

@Service
public class FireBaseService implements FileUploadInterface{

    @Value("${app.firebase-bucket}")
    private String firebaseBucket;

    public String uploadFile(MultipartFile file, String filePath) throws IOException {
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(file.getBytes());
        Blob blob = bucket.create(filePath, content, file.getContentType());
        return blob.getMediaLink();
    }

    public String getSourceFromPath(String filePath) {
        try {
            Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
            Blob blob = bucket.get(filePath);
            if (blob != null) {
                // Generate a signed URL that's valid for 1 hour
                return blob.signUrl(1, TimeUnit.HOURS).toString();
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
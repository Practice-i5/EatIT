package com.i7.eatit.domain.picture.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FireBaseInitializer {
    //https://popawaw.tistory.com/264
   // https://h1z1.tistory.com/m/entry/Spring-Firebase-Storage-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C-%EC%82%AD%EC%A0%9C-%ED%95%98%EA%B8%B0
    @Value("${app.firebase-configuration-file}")
    private String firebaseConfigPath;

    @PostConstruct
    public void initialize() {
        try{
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(
                    GoogleCredentials.fromStream(
                            new ClassPathResource(firebaseConfigPath).getInputStream())).build();

            if(FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package com.i7.eatit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/chatGroup/chatrooms/**")
                .excludePathPatterns("/login/**", "/resources/**");

        //마이페이지도 로그인 안한 상태면 리다이렉트 시키도록 추가
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/my-page/**")
                .excludePathPatterns("/login/**", "/resources/**");

    }
}

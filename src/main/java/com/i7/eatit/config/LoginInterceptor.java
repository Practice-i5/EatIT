package com.i7.eatit.config;

import com.i7.eatit.domain.user.dto.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserInfoDTO loginUser = (UserInfoDTO) session.getAttribute("loginUser");
        System.out.println("LoginInterceptor: loginUser=" + loginUser); // 디버깅을 위한 로그

        if (loginUser == null) {
            response.sendRedirect("/login/loginMain");
            return false;
        }
        return true;
    }
}
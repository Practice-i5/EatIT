package com.i7.eatit.domain.user.dao;

import java.util.Map;

public interface FindMapper {

    void selectUserInfo(Map<String, String> userEmail);
}
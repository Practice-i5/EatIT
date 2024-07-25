package com.i7.eatit.admin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Util {

    private SHA256Util() {
    }

    public static String encryptSHA256(String str) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(str.getBytes());
        byte[] digest = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            String hex = Integer.toHexString(0xff & b); // 255와 Byte b 를 bit 단위의 and 연산 -> 이진
            if (hex.length() == 1) {
                hexString.append('0'); // 16 미만의 수는 한 자릿 수 -> 두 자리로 억지로 늘려주자
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
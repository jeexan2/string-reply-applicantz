package com.beta.replyservice.service;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CommandServiceImpl implements CommandService{
    @Override
    public String reverseString(String string) {
        StringBuilder processedMessage = new StringBuilder(string);
        processedMessage.reverse();
        return processedMessage.toString();
    }

    @Override
    public String hashMd5String(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(string.getBytes());
        byte[] messageBytes = messageDigest.digest();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < messageBytes.length;i++){
            sb.append(Integer.toString((messageBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}

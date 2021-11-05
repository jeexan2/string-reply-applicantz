package com.beta.replyservice.service;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public interface CommandService {
    String reverseString(String string);
    String hashMd5String(String string) throws NoSuchAlgorithmException;
}

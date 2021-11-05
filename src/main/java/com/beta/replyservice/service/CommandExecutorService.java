package com.beta.replyservice.service;

import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public interface CommandExecutorService {
    String applyListOfCommand(List<String> commands,String message) throws NoSuchAlgorithmException;
}

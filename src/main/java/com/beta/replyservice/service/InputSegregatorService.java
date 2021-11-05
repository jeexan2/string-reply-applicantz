package com.beta.replyservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InputSegregatorService {
    String getProcessingStringFromInput(String string);
    String getCommandStringFromInput(String string);
    List<String> segregateCommandFromCommandString(String string);
}

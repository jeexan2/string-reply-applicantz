package com.beta.replyservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class InputSegregatorServiceImpl implements InputSegregatorService {
    @Value("${input-segregator-regex}")
    private String input_segregator;
    @Value("${command-segregator-regex}")
    private String command_segregator;

    @Override
    public String getProcessingStringFromInput(String string) {
        return string.split(input_segregator)[1];
    }

    @Override
    public String getCommandStringFromInput(String string) {
        return string.split(input_segregator)[0];
    }

    @Override
    public List<String> segregateCommandFromCommandString(String string) {
        return Arrays.asList(string.split(command_segregator));
    }
}

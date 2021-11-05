package com.beta.replyservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Value("${text-validator-regex}")
    private String text_validator;

    @Value("${command-list}")
    private String command_list;

    @Override
    public Boolean textValidated(String string) {
        return Pattern.matches(text_validator,string);
    }

    @Override
    public Boolean commandValidated(Character command) {
        List<String> commandList = Arrays.asList(command_list.split(","));
        Boolean found = false;
        for(String command_: commandList){
            if(command.toString().equals(command_.toString()))
                found = true;
        }
        return found;
    }

    @Override
    public Boolean commandValidated(String command) {
        List<String> commandList = Arrays.asList(command_list.split(","));
        for(String command_: commandList)
            if(command.equalsIgnoreCase(command_))
                return true;

        return false;
    }

    @Override
    public Boolean commandValidated(List<String> commands) {
        for(String command: commands){
            if(!commandValidated(command)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean inputStringValidation(String string) {
        return string.contains("-");
    }
}

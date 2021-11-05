package com.beta.replyservice.controller;

import com.beta.replyservice.pojo.ReplyMessage;
import com.beta.replyservice.pojo.ReplyMessageWithCode;
import com.beta.replyservice.pojo.ResponseMessage;
import com.beta.replyservice.service.CommandExecutorService;
import com.beta.replyservice.service.InputSegregatorService;
import com.beta.replyservice.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class ReplyV2Controller {
    @Autowired
    InputSegregatorService inputSegregatorService;

    @Autowired
    ValidationService validationService;

    @Autowired
    CommandExecutorService commandExecutorService;

    @GetMapping("/reply/v2/{message}")
    public ResponseMessage replying(@PathVariable String message) throws NoSuchAlgorithmException {
        ResponseMessage responseMessage =  new ResponseMessage();
        if(!validationService.inputStringValidation(message)){
            responseMessage.setData("Invalid input");
            responseMessage.setCode("400");
            return responseMessage;
        }
        String command = inputSegregatorService.getCommandStringFromInput(message);
        String input_message = inputSegregatorService.getProcessingStringFromInput(message);
        List<String> commandList = inputSegregatorService.segregateCommandFromCommandString(command);

        if(validationService.commandValidated(commandList) &&
                validationService.textValidated(input_message)
         ) {
            message = commandExecutorService.applyListOfCommand(commandList,input_message);
            responseMessage.setCode("200");
            responseMessage.setData(message);

        }
        else {
            responseMessage.setData("Invalid input");
            responseMessage.setCode("400");
        }
        return responseMessage;
    }
}

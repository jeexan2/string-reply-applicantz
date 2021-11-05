package com.beta.replyservice.service;

import com.beta.replyservice.commandfactory.ParamOneCommand;
import com.beta.replyservice.commandfactory.ParamTwoCommand;
import com.beta.replyservice.pojo.CommandRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CommandExecutorServiceImpl implements CommandExecutorService {
    @Autowired
    ParamOneCommand paramOneCommand;

    @Autowired
    ParamTwoCommand paramTwoCommand;

    @Override
    public String applyListOfCommand(List<String> commands, String message) throws NoSuchAlgorithmException {
        for(String command: commands){
            CommandRequest commandRequest = new CommandRequest();
            commandRequest.setInput_message(message);
             message = command.equals("1")  ?
                     paramOneCommand.processMessageAccordingToCommand(commandRequest)
                        : paramTwoCommand.processMessageAccordingToCommand(commandRequest);
        }
        return message;
    }
}

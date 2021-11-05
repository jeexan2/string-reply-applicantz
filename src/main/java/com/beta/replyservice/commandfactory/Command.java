package com.beta.replyservice.commandfactory;

import com.beta.replyservice.pojo.ReplyMessage;
import com.beta.replyservice.pojo.CommandRequest;

import java.security.NoSuchAlgorithmException;

public interface Command {
    void setParamValue();
    String processMessageAccordingToCommand(CommandRequest commandRequest) throws NoSuchAlgorithmException;
}

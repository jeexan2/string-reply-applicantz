package com.beta.replyservice.commandfactory;

import com.beta.replyservice.pojo.ReplyMessage;
import com.beta.replyservice.pojo.CommandRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

//@AllArgsConstructor
//@NoArgsConstructor
@Service
public class ParamTwoCommand extends ParamCommand implements Command {
    @Override
    public void setParamValue() {
        this.setParam_value('2');
    }

    @Override
    public String processMessageAccordingToCommand(CommandRequest commandRequest) throws NoSuchAlgorithmException {
        return commandService.hashMd5String(commandRequest.getInput_message());
    }
}

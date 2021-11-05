package com.beta.replyservice.commandfactory;

import com.beta.replyservice.pojo.ReplyMessage;
import com.beta.replyservice.pojo.CommandRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

//@AllArgsConstructor
//@NoArgsConstructor
@Service
public class ParamOneCommand extends ParamCommand implements Command{
    @Override
    public void setParamValue() {
        this.setParam_value('1');
    }

    @Override
    public String  processMessageAccordingToCommand(CommandRequest commandRequest) {
        return commandService.reverseString(commandRequest.getInput_message());
    }
}

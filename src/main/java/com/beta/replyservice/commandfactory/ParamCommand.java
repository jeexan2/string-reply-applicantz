package com.beta.replyservice.commandfactory;

import com.beta.replyservice.service.CommandService;
import com.beta.replyservice.service.InputSegregatorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Data
public class ParamCommand {
    private Character param_value;

    @Value("${command-list}")
    private String command_list;

    @Autowired
    CommandService commandService;

    @Autowired
    InputSegregatorService inputSegregatorService;

}

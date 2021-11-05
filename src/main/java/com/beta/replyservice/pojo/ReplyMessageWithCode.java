package com.beta.replyservice.pojo;

import com.beta.replyservice.pojo.ReplyMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyMessageWithCode extends ReplyMessage {
    private String code;
    public ReplyMessageWithCode(String message) {
        super(message);
    }
}

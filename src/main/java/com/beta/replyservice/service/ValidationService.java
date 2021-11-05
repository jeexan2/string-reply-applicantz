package com.beta.replyservice.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ValidationService {
    Boolean textValidated(String string);
    Boolean commandValidated(Character command);
    Boolean commandValidated(String command);
    Boolean commandValidated(List<String> commands);
    Boolean inputStringValidation(String string);
}

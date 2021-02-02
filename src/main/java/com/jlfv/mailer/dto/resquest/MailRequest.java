package com.jlfv.mailer.dto.resquest;

import lombok.Data;

@Data
public class MailRequest {
    private String subject;
    private String message;
    private String to;
}

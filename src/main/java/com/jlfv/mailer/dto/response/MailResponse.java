package com.jlfv.mailer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {
    private String code;
    private String message;
    private String response;
    private String error;
}
package com.jlfv.mailer.controller;

import com.jlfv.mailer.dto.response.MailResponse;
import com.jlfv.mailer.dto.resquest.MailRequest;
import com.jlfv.mailer.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mail")
public class MailerController {

    @Autowired
    private SenderService senderService;

    @PostMapping("/send")
    public ResponseEntity send(@RequestBody MailRequest mailRequest) {

        return new ResponseEntity<MailResponse>(senderService.send(mailRequest), HttpStatus.OK);
    }

}

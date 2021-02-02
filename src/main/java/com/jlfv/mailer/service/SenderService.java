package com.jlfv.mailer.service;

import com.jlfv.mailer.dto.response.MailResponse;
import com.jlfv.mailer.dto.resquest.MailRequest;
import com.jlfv.mailer.util.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public MailResponse send(MailRequest mailRequest) {

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;

        try {

            helper = new MimeMessageHelper(msg, true);
            helper.setTo(mailRequest.getTo().split(","));
            helper.setSubject(mailRequest.getSubject());
            helper.setText(mailRequest.getMessage(), true);

            javaMailSender.send(msg);
            return new MailResponse(ResponseConstants.send_ok, "email sent successfully", "", "");

        } catch (MessagingException e) {

            e.printStackTrace();
            return new MailResponse(ResponseConstants.send_failed, "mail not sent", "", e.getMessage());

        }

    }
}

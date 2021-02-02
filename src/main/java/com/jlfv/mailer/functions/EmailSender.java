package com.jlfv.mailer.functions;

import com.jlfv.mailer.dto.resquest.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean send(MailRequest mailRequest) {

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;

        try {

            helper = new MimeMessageHelper(msg, true);
            helper.setTo(mailRequest.getTo().split(","));
            helper.setSubject(mailRequest.getSubject());
            helper.setText(mailRequest.getMessage(), true);

            javaMailSender.send(msg);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return false;
    }
}

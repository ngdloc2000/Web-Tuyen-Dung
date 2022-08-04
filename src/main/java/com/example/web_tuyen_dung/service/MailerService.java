package com.example.web_tuyen_dung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailerService {

    @Autowired
    JavaMailSender emailSender;

    private void sendMail(final String to, final String subject, final String body) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom("locnd@hblab.vn");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(body);

            emailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MessagingException {
        new MailerService().sendMail("ngdinhloc2000@gmail.com", "test mail", "test");
    }
}

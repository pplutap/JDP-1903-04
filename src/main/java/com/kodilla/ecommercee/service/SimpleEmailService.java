package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.mail.Mail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public SimpleEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void send(final Mail mail){

        try{
            SimpleMailMessage mailMassage = createMailMassage(mail);
            javaMailSender.send(mailMassage);

        }catch(MailException e){

        }
    }

    private SimpleMailMessage createMailMassage(final Mail mail){
        SimpleMailMessage mailMassage = new SimpleMailMessage();
        if(StringUtils.isNotEmpty(mail.getMailTo())){
            mailMassage.setCc(mail.getMailTo());
        }
        mailMassage.setSubject(mail.getSubject());
        mailMassage.setText(mail.getMessage());
        return mailMassage;
    }
}
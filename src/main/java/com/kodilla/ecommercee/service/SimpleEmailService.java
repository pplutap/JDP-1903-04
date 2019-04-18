package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.mail.Mail;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {
    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleEmailService.class);

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
            LOGGER.error("Failed to process email sending: ",e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMassage(final Mail mail){
        SimpleMailMessage mailMassage = new SimpleMailMessage();
        if(StringUtils.isNotEmpty(mail.getMailTo())){
            mailMassage.setTo(mail.getMailTo());
        }
        mailMassage.setSubject(mail.getSubject());
        mailMassage.setText(mail.getMessage());
        return mailMassage;
    }
}

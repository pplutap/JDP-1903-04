package com.kodilla.ecommercee.mail;

import lombok.Getter;

@Getter
public class Mail {

    public static final String SUBJECT = "New order created in Ecommercee shop";
    public static final String TEXT = "Dear %s,"+"\n"
            +"Ecommercee shop kindly confirm that Your order %s has been received successfully";

    private String mailTo;
    private String subject;
    private String message;

    public Mail(String mailTo, String subject, String message) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }
}
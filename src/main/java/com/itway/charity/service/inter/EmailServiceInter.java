package com.itway.charity.service.inter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailServiceInter {
    void sendEmail(String to,String subject,String body) throws AddressException, MessagingException;
}

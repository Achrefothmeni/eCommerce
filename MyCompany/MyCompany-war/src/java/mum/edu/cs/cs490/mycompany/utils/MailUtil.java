/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Bilguun
 */
public class MailUtil {

    static final String username = "mycompany1310@gmail.com";
    static final String password = "ebazaar201411";

    /**
     * 
     * @param body
     * @param fromAddress Send from default address if this parameter is null
     * @param toAddress Send to default address if this parameter is null
     * @param subject
     * @return 
     */
    public static boolean send(String body, String fromAddress, String toAddress, String subject) {
        
        if(fromAddress == null)
            fromAddress = username;
        if(toAddress == null)
            toAddress = username;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toAddress));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            return true;

        } catch (MessagingException e) {
            return false;
        }
    }
}

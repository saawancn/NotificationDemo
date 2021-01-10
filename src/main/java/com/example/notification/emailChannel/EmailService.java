package com.example.notification.emailChannel;

import com.example.notification.dto.Message;
import com.example.notification.exception.InvalidFormatException;
import com.example.notification.util.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class EmailService implements EmailChannel {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    EmailValidator emailValidator;


    @Override
    public String sendNotification(Message message)  {
        if(!emailValidator.isValid(message.getFrom())) {
            throw new InvalidFormatException();
        }
        if(!emailValidator.isValid(message.getTo())) {
            throw new InvalidFormatException();
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(message.getSubject());
            mimeMessageHelper.setFrom(new InternetAddress(message.getFrom(), "Test Notifcation Mail"));
            mimeMessageHelper.setTo(message.getTo());
            mimeMessageHelper.setText(message.getText());

            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "Email sent successfully";
    }


}

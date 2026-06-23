package com.example.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendFeedbackNotification(
            String name,
            String email,
            String role,
            String company,
            Integer rating,
            String message
    ) {

        SimpleMailMessage mail =
                new SimpleMailMessage();

        mail.setTo("farhaan.attar313@gmail.com");

        mail.setSubject(
                "New Portfolio Feedback Received"
        );

        mail.setText(
                "Name: " + name + "\n" +
                        "Email: " + email + "\n" +
                        "Role: " + role + "\n" +
                        "Company: " + company + "\n" +
                        "Rating: " + rating + "\n\n" +
                        "Message:\n" + message
        );

        mailSender.send(mail);
    }
}
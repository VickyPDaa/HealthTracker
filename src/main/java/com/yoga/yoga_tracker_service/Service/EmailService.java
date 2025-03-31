package com.yoga.yoga_tracker_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendWelcomeEmail(String email, String username) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Welcome to Yoga Tracker!");
            message.setText("""
        Dear %s,

        Welcome to the Yoga Tracker App! We are excited to have you onboard.

        Stay healthy and happy!

        Best Regards,
        Yoga Tracker Team
        """.formatted(username));


            mailSender.send(message);
            System.out.println("Mail Sent");
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }

    }
}

package com.chronica.user.logic;

import com.chronica.user.logic.security.RequestAuthenticator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final static Logger LOGGER = LoggerFactory.getLogger(RequestAuthenticator.class);

    @Value("${spring.mail.username}")
    private String mail;
    @Value("${app.account.confirmation.api}")
    private String confirmationAddress;

    @Async
    public void sendConfirmationEmail(String to, String topic, String generatedCode) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            buildAndSendMail(message, to, topic, generatedCode);
        } catch (MessagingException ignored) {
            LOGGER.error("Could not send confirmation email with generated code: {} to {}", generatedCode, to);
        }
    }

    private void buildAndSendMail(MimeMessage message, String to, String topic, String generatedCode) throws MessagingException {
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(mail);
        helper.setTo(to);
        helper.setSubject(topic);
        helper.setText(buildBody(generatedCode), true);
        javaMailSender.send(message);
    }

    private String buildBody(String generatedCode) {
        return "<h1>Witaj!</h1><p>Kliknij <a href='" + confirmationAddress + generatedCode + "'>tutaj</a> aby aktywować swoje konto.</p>";
    }
}


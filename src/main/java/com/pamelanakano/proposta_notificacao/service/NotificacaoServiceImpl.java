package com.pamelanakano.proposta_notificacao.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    public NotificacaoServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmail(String assuntoEmail, String corpoEmail, String emailUsuario) {

        var message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(emailUsuario);
        message.setSubject(assuntoEmail);
        message.setText(corpoEmail);
        mailSender.send(message);

    }

}

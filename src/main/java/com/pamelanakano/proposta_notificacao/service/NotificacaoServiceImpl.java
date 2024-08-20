package com.pamelanakano.proposta_notificacao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {

    private final JavaMailSender mailSender;

    private final String username;

    private final Logger logger = LoggerFactory.getLogger(NotificacaoServiceImpl.class);

    public NotificacaoServiceImpl(JavaMailSender mailSender,
                                  @Value("${spring.mail.username}") String username) {
        this.mailSender = mailSender;
        this.username = username;
    }

    public void enviarEmail(String assuntoEmail, String corpoEmail, String emailUsuario) {
        if (emailUsuario != null && !emailUsuario.trim().isEmpty()) {
            try {
                var message = new SimpleMailMessage();
                message.setFrom(username);
                message.setTo(emailUsuario);
                message.setSubject(assuntoEmail);
                message.setText(corpoEmail);
                mailSender.send(message);
            } catch (Exception e) {
                logger.error("Erro ao enviar e-mail: " + e.getMessage());
            }
        }
    }

}

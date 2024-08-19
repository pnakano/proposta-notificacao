package com.pamelanakano.proposta_notificacao.service;

public interface NotificacaoService {

    void enviarEmail(String assuntoEmail, String corpoEmail, String emailUsuario);

}

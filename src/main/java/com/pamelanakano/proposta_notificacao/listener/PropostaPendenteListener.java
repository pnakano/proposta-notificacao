package com.pamelanakano.proposta_notificacao.listener;

import com.pamelanakano.proposta_notificacao.contants.MensagemConstants;
import com.pamelanakano.proposta_notificacao.domain.Proposta;
import com.pamelanakano.proposta_notificacao.service.NotificacaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

    private final NotificacaoService notificacaoService;

    public PropostaPendenteListener(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @RabbitListener(queues = "${rabbitmq.propostapendente.notificacao}")
    public void propostaPendente(Proposta proposta) {
        String corpoEmail = String.format(MensagemConstants.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoService.enviarEmail(MensagemConstants.ASSUNTO_PROPOSTA_EM_ANALISE, corpoEmail, proposta.getUsuario().getEmail());
    }

}

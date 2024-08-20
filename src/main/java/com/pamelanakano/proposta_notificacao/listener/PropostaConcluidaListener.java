package com.pamelanakano.proposta_notificacao.listener;

import com.pamelanakano.proposta_notificacao.contants.MensagemConstants;
import com.pamelanakano.proposta_notificacao.domain.Proposta;
import com.pamelanakano.proposta_notificacao.service.NotificacaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaConcluidaListener {

    private final NotificacaoService notificacaoService;

    public PropostaConcluidaListener(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @RabbitListener(queues = "${rabbitmq.propostaconcluida.notificacao}")
    public void propostaConcluida(Proposta proposta) {
        var assuntoEmail = String.format(MensagemConstants.ASSUNTO_PROPOSTA_CONCLUIDA, proposta.getAprovada() ? "aprovada" : "reprovada");
        var corpoEmail = String.format(proposta.getAprovada() ? MensagemConstants.PROPOSTA_APROVADA : MensagemConstants.PROPOSTA_REPROVADA, proposta.getUsuario().getNome());
        notificacaoService.enviarEmail(assuntoEmail, corpoEmail, proposta.getUsuario().getEmail());
    }

}

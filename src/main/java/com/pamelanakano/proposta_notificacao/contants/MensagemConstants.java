package com.pamelanakano.proposta_notificacao.contants;

public class MensagemConstants {

    public static final String ASSUNTO_PROPOSTA_EM_ANALISE = "Recebemos sua proposta!";

    public static final String PROPOSTA_EM_ANALISE = """
            Prezado(a) %s,
            
            Sua proposta foi recebida por nossa equipe e será analisada.
            Em breve retornaremos com o contato.
            
            Atenciosamente,
            Equipe Financeira
            """;

    public static final String ASSUNTO_PROPOSTA_CONCLUIDA = "Sua proposta foi %s!";

    public static final String PROPOSTA_APROVADA = """
            Prezado(a) %s,
            
            Sua proposta foi APROVADA.
            O valor solicitado ficará disponível na conta corrente cadastrada em até 48h.
            
            Atenciosamente,
            Equipe Financeira
            """;

        public static final String PROPOSTA_REPROVADA = """
            Prezado(a) %s,
            
            Infelizmente, sua proposta foi REPROVADA.
            Motivo: %s
            
            Mas não desista ainda!
            
            Você pode tentar uma nova simulação com valores ou prazos diferentes.
            
            Atenciosamente,
            Equipe Financeira
            """;


}

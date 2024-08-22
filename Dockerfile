FROM openjdk:17

COPY target/proposta-notificacao-1.0.0-SNAPSHOT.jar proposta-notificacao.jar

ENTRYPOINT ["java", "-jar", "proposta-notificacao.jar"]
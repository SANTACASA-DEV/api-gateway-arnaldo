package br.com.santacasa.api_gateway.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue minhaFila(){
        return new Queue("fila", true);
    }
}
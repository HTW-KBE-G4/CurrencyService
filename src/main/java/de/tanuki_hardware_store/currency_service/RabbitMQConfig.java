package de.tanuki_hardware_store.currency_service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"currency-service"})
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue queue() {
        return new Queue("tanuki.currency.requests");
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("tanuki.currency");
    }

    @Bean
    public Binding binding(DirectExchange exchange,
                           Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with("currency");
    }

    @Bean
    public CurrencyServer server() {
        return new CurrencyServer();
    }

}

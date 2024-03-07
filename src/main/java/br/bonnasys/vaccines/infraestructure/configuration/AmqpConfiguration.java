package br.bonnasys.vaccines.infraestructure.configuration;

import br.bonnasys.vaccines.infraestructure.annotation.CreateVaccineQueue;
import br.bonnasys.vaccines.infraestructure.annotation.VaccineEvents;
import br.bonnasys.vaccines.infraestructure.properties.QueueProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfiguration {

    @Bean
    @CreateVaccineQueue
    @ConfigurationProperties("amqp.queues.create-vaccines")
    public QueueProperties createVaccinesQueue() {
        return new QueueProperties();
    }
    @Configuration
    static class Admin {

        @Bean
        @VaccineEvents
        DirectExchange createVaccineEventExchange(@CreateVaccineQueue QueueProperties properties) {
            return new DirectExchange(properties.getExchange());
        }

        @Bean
        @CreateVaccineQueue
        Queue createVaccineQueue(@CreateVaccineQueue QueueProperties properties) {
            return new Queue(properties.getQueue());
        }

        @Bean
        @CreateVaccineQueue
        Binding createVaccineBidding(
                @VaccineEvents DirectExchange exchange,
                @CreateVaccineQueue Queue queue,
                @CreateVaccineQueue QueueProperties queueProperties
        ) {
            return BindingBuilder.bind(queue).to(exchange).with(queueProperties.getRoutingKey());
        }
    }

}

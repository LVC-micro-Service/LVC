package com.crudlvh.crudlvch.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.crudlvh.crudlvch.dto.ProducerDTO;

@Component
public class CasoProducer {

    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("routingKeyCaso")
    String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void casoProducerMensagem(ProducerDTO caso){
        rabbitTemplate.convertAndSend(exchange, routingKey, caso);
    }
}
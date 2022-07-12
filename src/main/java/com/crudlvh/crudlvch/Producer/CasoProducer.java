package com.crudlvh.crudlvch.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;

@Component
public class CasoProducer {

    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("routingKeyCaso")
    String routingKey;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public CasoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void casoProducerMensagem(CasoLVCDTO caso){
        rabbitTemplate.convertAndSend(exchange, routingKey, caso);
    }
}
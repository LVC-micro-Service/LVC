package com.crudlvh.crudlvch.Producer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.repositories.CasoLVCRepository;

@Component
class CasoProducer {

    @Value("${crud.rabbitmq.exchange}")
    String exchange;

    @Value("crud.rabbitmq.routingKeyCaso")
    String routingKey;

    private RabbitTemplate RabbitTemplate;


    private CasoLVCRepository repository;

    @Autowired
    public CasoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void casoProducerMensagem(CasoLVC caso){
        rabbitTemplate.convertAndSend(exchange, routingKey, caso);
    }
}
package com.tosh.RabbitMq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class PracticalTipSender {

    private static final Logger log = LoggerFactory.getLogger(PracticalTipSender.class);

    private final RabbitTemplate rabbitTemplate;

    public PracticalTipSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendPracticalTip(){
        PracticalTipMessage tip = new PracticalTipMessage("Haiya inafanya", 1, false);
        rabbitTemplate.convertAndSend(RabbitMqApplication.EXCHANGE_NAME, RabbitMqApplication.ROUTING_KEY, tip);
    }
}

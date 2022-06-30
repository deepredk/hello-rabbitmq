package com.example.rabbitmq.hello.messaging;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "hello")
    public void consume(Message message) {
        log.info("consumer consumes messages: {}", new String(message.getBody(), StandardCharsets.UTF_8));
    }

}

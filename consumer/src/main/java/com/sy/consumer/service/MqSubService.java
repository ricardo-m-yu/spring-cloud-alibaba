package com.sy.consumer.service;

import com.alibaba.fastjson.JSON;
import com.sy.consumer.domain.Person;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Slf4j
@Service
public class MqSubService {

    @Bean
    public Consumer<Message<Person>> test() {
        return message -> {
            MessageHeaders headers = message.getHeaders();
            Person payload = message.getPayload();
            log.info("消息 test：" + payload + "__" + headers);
        };
    }

    @Bean
    public Consumer<Message<Person>> dev() {
        return message -> {
            MessageHeaders headers = message.getHeaders();
            Person payload = message.getPayload();
            log.info("消息 dev：" + payload + "__" + headers);
        };
    }
}

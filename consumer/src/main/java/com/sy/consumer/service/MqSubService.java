package com.sy.consumer.service;

import com.alibaba.fastjson.JSON;
import com.sy.consumer.domain.Person;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;


@Slf4j
@Service
public class MqSubService {

    @Bean
    public Consumer<Object> test() {
        return message -> {
            log.info("消息 test：" + message.toString() + "__"  );
        };
    }

    @Bean
    public Consumer<Object> dev() {
        return message -> {
            log.info("消息 dev：" + message.toString() + "__"  );
        };
    }
}

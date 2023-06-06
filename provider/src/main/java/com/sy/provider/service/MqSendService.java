package com.sy.provider.service;

import com.sy.provider.domain.Person;
import jakarta.annotation.Resource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class MqSendService {

    @Resource
    private StreamBridge streamBridge;

    public void send(String channel, String message, String tag, String keys) {
        Person person = new Person();
        person.setName(message);
        Message<Person> build = MessageBuilder.withPayload(person).build();
        streamBridge.send(channel, build);
    }
}

package com.sy.provider.service;

import com.sy.provider.domain.Person;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;


@Service
public class MqSendService {


    @Resource
    private StreamBridge streamBridge;

    public void send(String channel, String message) {
        Person person = new Person();
        person.setName(message);
        Message<Person> build = MessageBuilder.withPayload(person).build();
        streamBridge.send(channel, build);
    }
}

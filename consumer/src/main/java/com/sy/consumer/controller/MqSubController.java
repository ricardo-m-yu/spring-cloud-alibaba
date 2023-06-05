package com.sy.consumer.controller;

import com.sy.consumer.service.MqSubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "消息-消息队列接收")
@RequestMapping("/message/send")
public class MqSubController {

    @Resource
    private MqSubService mqSubService;

    @Operation(summary = "查看收到的消息")
    @PostMapping
    public void catInfo(@RequestParam String channel) {

        //mqSubService.catInfo(channel);
    }
}

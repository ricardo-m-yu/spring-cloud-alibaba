package com.sy.provider.controller;

import com.sy.provider.service.BizService;
import com.sy.provider.service.MqSendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "消息-消息队列发送")
@RequestMapping("/message/send")
public class MqSendController {

    @Resource
    private MqSendService mqSendService;

    @Operation(summary = "发送")
    @PostMapping
    public void send(@RequestParam String channel, @RequestParam String message, @RequestParam String tag, @RequestParam String keys) {
        mqSendService.send(channel, message, tag, keys);
    }
}

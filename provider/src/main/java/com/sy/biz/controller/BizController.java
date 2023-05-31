package com.sy.biz.controller;

import com.sy.biz.service.BizService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/biz")
public class BizController {

    @Value("${username}")
    private String username;

    @Resource
    private BizService bizService;

    @GetMapping("/get")
    public String get() {
        return username;
    }

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping(value = "/info")
    public Map<String, Object> getInfo(@RequestParam String username) {
        return bizService.getInfo(username);
    }

}

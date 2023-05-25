package com.sy.biz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/")
public class Controller {

    @Value("${username}")
    private String username;

    @RequestMapping("/get")
    public String get() {
        return username;
    }
}

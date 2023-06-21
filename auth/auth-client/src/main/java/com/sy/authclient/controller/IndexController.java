package com.sy.authclient.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping
@Controller
public class IndexController {

    @GetMapping("/")
    public String welcome() {
        return "<h1>index!</h1>";
    }

    @GetMapping("/login/oauth2/code/{clientId}")
    public String welcome(@PathVariable String clientId, @RequestParam String code, @RequestParam String state) {
        return "<h1>index!</h1>" + clientId + code + state;
    }
}

package com.sy.authclient.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/login")
@Controller
public class LoginController {

    @GetMapping("/welcome")
    public String welcome() {
        return "<h1>Welcome!</h1>";
    }
}

package com.sy.authserver.controller;

import com.sy.authserver.service.ServiceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/client")
@RestController
public class ServerController {

    @Resource
    private ServiceService serviceService;

    @PostMapping("/init/client")
    public void initClient(){
        serviceService.initClient();
    }

}

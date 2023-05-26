package com.sy.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appName;

    @SentinelResource(value="hi")
    @GetMapping("/echo/app-name")
    public String echoAppName() {
        //使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("biz");
        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        System.out.println("request url:" + url);
        String result = restTemplate.getForObject(url, String.class);
        log.info("result -> {}", result);
        return result;
    }


}

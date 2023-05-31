package com.sy.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sy.consumer.client.BizClient;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${spring.application.name}")
    private String appName;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private BizClient bizClient;
    @Resource
    private LoadBalancerClient loadBalancerClient;

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


    @GetMapping("/username")
    public Object getUserInfo(@RequestParam String username) {
        return bizClient.getInfo(username);
    }
}

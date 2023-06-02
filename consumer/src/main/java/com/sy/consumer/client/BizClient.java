package com.sy.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "provider")
public interface BizClient {

    @GetMapping("/biz/info")
    Object getInfo(@RequestParam String username);
}

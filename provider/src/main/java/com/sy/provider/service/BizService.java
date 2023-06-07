package com.sy.provider.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class BizService {

    public Map<String, Object> getInfo(String username) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", "123456");
        log.info("map -> {}", map);
        return map;
    }
}

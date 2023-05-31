package com.sy.biz.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BizService {

    public Map<String, Object> getInfo(String username) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", "123456");
        return map;
    }
}

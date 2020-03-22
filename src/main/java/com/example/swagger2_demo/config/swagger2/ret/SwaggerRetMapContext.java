package com.example.swagger2_demo.config.swagger2.ret;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SwaggerRetMapContext {

    private static Map<String, Object> map = new ConcurrentHashMap<>();

    public static Map<String, Object> getMap(){
        return map;
    }
}

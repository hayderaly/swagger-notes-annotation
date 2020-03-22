package com.example.swagger2_demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zx
 *
 */
@RestController
public abstract class BaseController {

    /**
     * 自定义 swagger2 map参数和返回值注解 需要有这个方法保证其他接口map注解正常
     */
    @PostMapping("/zzzzzzzzzzz")
    public void zzzzzzzzzzz() { }
}

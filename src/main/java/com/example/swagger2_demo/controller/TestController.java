package com.example.swagger2_demo.controller;

import com.example.swagger2_demo.bean.User;
import com.example.swagger2_demo.config.swagger2.params.ApiJsonObject;
import com.example.swagger2_demo.config.swagger2.params.ApiJsonProperty;
import com.example.swagger2_demo.config.swagger2.ret.ApiReturnJson;
import com.example.swagger2_demo.config.swagger2.ret.ApiReturnJsonPro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author
 * controller 类要有注解 @RequestMapping 和 @RestController ，原因在MyBeanPostProcessor类中有用到，看代码就知道了
 */
@RequestMapping(value = "/control")
@Api(value = "测试")
@RestController
public class TestController extends BaseController{

    @ApiOperation(value = "测试1", notes = "这是一个测试接口1")
    @PostMapping("/test")
    @ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(type = String.class,key = "phone", example = "188xxxxxxx", description = "user phone"),
            @ApiJsonProperty(type = String.class,key = "password", example = "123456", description = "user password"),
            @ApiJsonProperty(type = String.class,key = "name", example = "", description = "user name"),
            @ApiJsonProperty(type = String.class,key = "sex", example = "", description = "user sex"),
            @ApiJsonProperty(type = Integer.class,key = "age", example = "22", description = "user age")
    })
    @ApiReturnJson(name = "ret", value = {
            @ApiReturnJsonPro(key = "re1", description = "re111",dataType = User.class),
            @ApiReturnJsonPro(key = "re2", description = "re222")
    })
    public void test1(@RequestBody Map<String,Object> params){
        return ;
    }

    @ApiOperation(value = "测试2", notes = "这是一个测试接口2")
    @PostMapping("/test2")
    @ApiJsonObject(name = "params", value = {
            @ApiJsonProperty(type = String.class,key = "phone", example = "188xxxxxxx", description = "user phone"),
            @ApiJsonProperty(type = String.class,key = "password", example = "123456", description = "user password"),
            @ApiJsonProperty(type = String.class,key = "name", example = "", description = "user name"),
            @ApiJsonProperty(type = String.class,key = "sex", example = "", description = "user sex"),
            @ApiJsonProperty(type = Integer.class,key = "age", example = "15", description = "user age")
    })
    @ApiReturnJson(name = "ret", value = {
            @ApiReturnJsonPro(key = "re1", description = "re111",dataType = User.class),
            @ApiReturnJsonPro(key = "re2", description = "re222")
    })
    public void test2(@RequestBody Map<String,Object> params){
        return ;
    }

    @PostMapping("/test3")
    public void test3(@RequestBody Map<String,Object> params){
        return ;
    }
//    /**
//     * 作用:保证swagger2 自定义map注解参数的接口都正常
//     * 不能 @ApiIgnore
//     */
//    @GetMapping("/zzzzzzzzzzz")
//    public void zzzzzzzzzzz(){
//
//    }

}

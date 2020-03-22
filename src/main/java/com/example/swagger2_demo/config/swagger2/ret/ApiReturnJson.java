package com.example.swagger2_demo.config.swagger2.ret;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ApiReturnJson
 * @Description: 返回对象的定义 (描述这个类的作用)
 * @author
 */

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiReturnJson {
    String name();  //对象名称
    ApiReturnJsonPro[] value(); //对象属性值
}
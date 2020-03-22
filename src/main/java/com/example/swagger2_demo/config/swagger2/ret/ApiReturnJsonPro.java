package com.example.swagger2_demo.config.swagger2.ret;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ApiReturnJsonPro
 * @Description: 每一个字段的定义备注说明 (描述这个类的作用)
 * @author
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiReturnJsonPro {

    String key();  //key

    String example() default "";

    Class<?> dataType() default String.class;

    String description() default "";
}

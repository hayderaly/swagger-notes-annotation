package com.example.swagger2_demo.config.swagger2.params;

import com.alibaba.fastjson.JSONObject;
import com.example.swagger2_demo.config.swagger2.ret.ApiReturnJson;
import com.example.swagger2_demo.config.swagger2.ret.ApiReturnJsonPro;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Configuration
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        try {
            Class clazz =  bean.getClass();
            Package packageStr = clazz.getPackage();
            String packAgeName = packageStr.getName();
            if(!packAgeName.contains(SwaggerMapContext.filterPackage)){
                return bean;
            }
            if(clazz.getAnnotation(RestController.class) == null && clazz.getAnnotation(Controller.class) == null){
                return bean;
            }
            RequestMapping controllerRequestMapping = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            String classRequestUrl =  Arrays.toString(controllerRequestMapping.value());

            List methods = Arrays.asList(clazz.getDeclaredMethods());
            Iterator<Method> iterator = methods.iterator();
            while(iterator.hasNext()){
                Method method = iterator.next();
                String methodRequest = getRequestUrl(method);
                String key = classRequestUrl + methodRequest ;
                key = key.replaceAll("\\[","").replaceAll("\\]","");
                //param map
                ApiJsonObject annotation = method.getAnnotation(ApiJsonObject.class);
                if(annotation != null){
                    ApiJsonProperty[] values = annotation.value();
                    SwaggerMapContext.getMap().put(key,values);
                }
                //return map
                ApiReturnJson annotation2 = method.getAnnotation(ApiReturnJson.class);
                if(annotation2 != null){
                    ApiReturnJsonPro[] values = annotation2.value();
                    SwaggerRetMapContext.getMap().put(key,values);
                }
            }
        }catch (Exception e){
            System.out.println("info:"+e.getMessage());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 这边只做简单打印   原样返回bean
//        if(AutoConfigurationPackages.class.getName().equals(beanName)){
//            System.out.println("postProcessBeforeInitialization===="+beanName);
//        }
        return bean;
    }

    private String getRequestUrl(Method method){
        String methodRequest = "";
        if(method.getAnnotation(RequestMapping.class) != null) {
            methodRequest = Arrays.toString(method.getAnnotation(RequestMapping.class).value());
        }
        if(method.getAnnotation(PutMapping.class) != null) {
            methodRequest = Arrays.toString(method.getAnnotation(PutMapping.class).value());
        }
        if(method.getAnnotation(DeleteMapping.class) != null) {
            methodRequest = Arrays.toString(method.getAnnotation(DeleteMapping.class).value());
        }
        if(method.getAnnotation(GetMapping.class) != null) {
            methodRequest = Arrays.toString(method.getAnnotation(GetMapping.class).value());
        }
        if(method.getAnnotation(PatchMapping.class) != null) {
            methodRequest = Arrays.toString(method.getAnnotation(PatchMapping.class).value());
        }
        if(method.getAnnotation(PostMapping.class) != null) {
            methodRequest = Arrays.toString(method.getAnnotation(PostMapping.class).value());
        }
        return methodRequest;
    }
}

package com.example.swagger2_demo.utils;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * 请求的返回类
 *
 * @author zx
 */
public class Resp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String desc;

    private HashMap data;

    public Resp(){

    }

    public Resp(Builder builder){
        data = builder.data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HashMap getData() {
        return data;
    }

    public void setData(HashMap data) {
        this.data = data;
    }

    private Resp code(String code) {
        this.code = code;
        return this;
    }

    private Resp desc(String desc) {
        this.desc = desc;
        return this;
    }

    public Resp success() {
        return code(ErrorCodeEnum.SUCCESS.getCode()).desc(ErrorCodeEnum.SUCCESS.getDesc());
    }

    private Resp success(String desc) {
        return code(ErrorCodeEnum.SUCCESS.getCode()).desc(desc);
    }

    private Resp failed(ErrorCodeEnum errorCodeEnum) {
        return code(errorCodeEnum.getCode()).desc(errorCodeEnum.getDesc());
    }

    private Resp failed() {
        ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.FAILED;
        return code(errorCodeEnum.getCode()).desc(errorCodeEnum.getDesc());
    }

    public static String buildSuccess(){
        return resp2Str(new Resp().success());
    }

    public static String buildSuccess(String desc){
        return resp2Str(new Resp().success(desc));
    }

    public static String buildFailed(){
        return resp2Str(new Resp().failed());
    }

    public static String buildFailed(ErrorCodeEnum errorCodeEnum){
        return resp2Str(new Resp().failed(errorCodeEnum));
    }

    private static String resp2Str(Resp resp){
        return JSONObject.toJSONString(resp);
    }

    public static Builder Builder(){
        return new Builder();
    }

    public static class Builder{
        private HashMap data;

        public Builder data(String key,Object value){
            if(key == null || "".equals(key)){
                return this;
            }
            if(data == null){
                data = new HashMap(3);
            }
            data.put(key,value);
            return this;
        }

        public Builder data(HashMap dataMap){
            if(dataMap == null){
                return this;
            }
            if(data == null){
                data = new HashMap(3);
            }
            //copy
            Set set = dataMap.keySet();
            for(Object object : set){
                data.put(object,dataMap.get(object));
            }
            return this;
        }

        public String buildSuccess(){
            return resp2Str(new Resp(this).success());
        }

        public String buildSuccess(String desc){
            return resp2Str(new Resp(this).success(desc));
        }

        public String buildFailed(){
            return resp2Str(new Resp(this).failed());
        }

        public String buildFailed(ErrorCodeEnum errorCodeEnum){
            return resp2Str(new Resp(this).failed(errorCodeEnum));
        }
    }
}

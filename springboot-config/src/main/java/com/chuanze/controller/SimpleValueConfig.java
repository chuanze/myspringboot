package com.chuanze.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleValueConfig {

    //如果配置文件里面没有对应的值会报错
    @Value("${chuanze.name}")
    private String name;
    //如果配置文件里面没有对应的值会报错
    @Value("${chuanze.age}")
    private Integer age;

    @RequestMapping("/name")
    public String showSimpleName(){
        String str= StringUtils.isBlank(name)?"名字没有设置":name;
        return str;
    }

    @RequestMapping("/age")
    public String showSimpleAge(){
        String str=StringUtils.isBlank(age.toString())?"年龄没有设置":age.toString();
        return str;
    }
}

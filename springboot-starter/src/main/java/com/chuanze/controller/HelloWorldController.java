package com.chuanze.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping("/starter")
    public String helloSpring(){
        String str="Hello SpringBoot changeer jrebel";
        log.info(str);
        return str;
    }

    @RequestMapping("/jrenew")
    public String jrenew(){
        String str="this is jrebel";
        log.info(str);
        return str;
    }

    @RequestMapping("/another")
    public String another(){
        String str="this is another Mapping";
        log.info(str);
        return str;
    }

    @RequestMapping("/other")
    public String other(){
        String str="other mapping ssss2ss3";
        log.info(str);
        return str;
    }
}

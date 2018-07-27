package com.chuanze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("exception")
public class ExceptionController {
    @RequestMapping("json")
    @ResponseBody
    public String jsonException(){
        int i=1/0;
        return "Hello Exception";
    }
}

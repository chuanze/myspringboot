package com.chuanze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("hello")
    public String helloThymeleaf(Model model){
        model.addAttribute("message","thymeleaf");
        int i=1/0;
        return "/hello";
    }
}

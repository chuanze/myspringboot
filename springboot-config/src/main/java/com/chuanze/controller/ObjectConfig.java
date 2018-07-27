package com.chuanze.controller;

import com.chuanze.pojo.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ObjectConfig {
    public Admin getAdmin(){
        return new Admin();
    }
}

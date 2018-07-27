package com.chuanze.controller;

import com.chuanze.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserArgumentController {
    @RequestMapping("ag")
    public User getUserArgument(User user){
        if(user!=null){
            return user;
        }
        return null;
    }
}

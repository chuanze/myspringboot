package com.chuanze.controller;

import com.chuanze.pojo.MiaoshaUser;
import com.chuanze.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("miaoshauser")
public class MiaoshaUserController {
    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @RequestMapping("getbyxml/{id}")
    public MiaoshaUser getByxml(@PathVariable("id") long id){
        return miaoshaUserService.getByXML(id);
    }


    @RequestMapping("get/{id}")
    public MiaoshaUser getByNotxml(@PathVariable("id") long id){
        return miaoshaUserService.getByNotXML(id);
    }
}

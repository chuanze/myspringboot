package com.chuanze.controller;

import com.chuanze.pojo.EnvModel;
import com.chuanze.service.EnvironmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("env")
public class EnvironmentController {
    @Autowired
    private EnvironmentService environmentService;
    @RequestMapping("model")
    public EnvModel getEnvModel(){
        return environmentService.getAnyEnv();
    }
}

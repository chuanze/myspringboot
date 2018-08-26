package com.chuanze.service;

import com.chuanze.pojo.EnvModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class EnvironmentService {
    @Autowired
    private Environment evn;

    /**
     * 获取对应的配置信息
     * @return
     */
    public EnvModel getAnyEnv(){
        EnvModel envModel=new EnvModel();
        //程序运行的目录 ，如果在IDE中运行，就是工程目录，user.dir是系统属性
        envModel.setDir(evn.getProperty("user.dir"));
        //执行程序的用户的home目录，user.home是系统属性
        envModel.setHome(evn.getProperty("user.home"));
        //读取设置的环境变量（不区分大小写）
        envModel.setJavaHome(evn.getProperty("JAVA_HOME"));
        //读取server.port，来自 application.properties,如果没有设置，无法获取到
        envModel.setServerPort(evn.getProperty("server.port"));
        return envModel;
    }

}

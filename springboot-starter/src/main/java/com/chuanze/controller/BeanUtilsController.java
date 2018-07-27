package com.chuanze.controller;

import com.chuanze.pojo.User;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/beanutils")
public class BeanUtilsController {
    @RequestMapping("/getUser")
    public User filedHold(){
        //BeanUtilsBean2继承了BeanUtilsBean并进行了升级，所以直接使用BeanUtilsBean2
        BeanUtilsBean beanUtilsBean=new BeanUtilsBean2();
        //错误不抛出异常、不使用NULL做默认值，数组的默认大小为0
        beanUtilsBean.getConvertUtils().register(false,false,0);
        User user=new User();
        try {
            beanUtilsBean.setProperty(user,"name","mick");
            String name=beanUtilsBean.getProperty(user,"name");
            log.info("名字为：{}",name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    @RequestMapping("/copyUsers")
    public List<User> copyUser(){
        List<User> userList=new ArrayList<>();
        User mick=new User();
        mick.setName("mick");
        mick.setAge(16);
        //BeanUtilsBean2继承了BeanUtilsBean并进行了升级，所以直接使用BeanUtilsBean2
        BeanUtilsBean beanUtilsBean=new BeanUtilsBean2();
        //错误不抛出异常、不使用NULL做默认值，数组的默认大小为0
        beanUtilsBean.getConvertUtils().register(false,false,0);

        User compy=new User();
        User user2=new User();
        try {
            //方法一
            beanUtilsBean.copyProperties(compy, mick);
            //方法二
            user2=(User) beanUtilsBean.cloneBean(compy);
            //user2
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        userList.add(mick);
        userList.add(compy);
        userList.add(user2);
        return userList;

    }
}

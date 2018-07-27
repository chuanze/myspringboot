package com.chuanze.service;

import com.chuanze.dao.MiaoshaUserMapper;
import com.chuanze.pojo.MiaoshaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiaoshaUserService {
    @Autowired
    private MiaoshaUserMapper miaoshaUserMapper;

    public MiaoshaUser getByXML(long id){
        return miaoshaUserMapper.selectByPrimaryKey(id);
    }

    public MiaoshaUser getByNotXML(long id){
        return miaoshaUserMapper.selectByPrimarKeyNotXML(id);
    }
}

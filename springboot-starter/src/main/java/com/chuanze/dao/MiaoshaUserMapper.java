package com.chuanze.dao;

import com.chuanze.pojo.MiaoshaUser;
import org.apache.ibatis.annotations.Select;

public interface MiaoshaUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MiaoshaUser record);

    int insertSelective(MiaoshaUser record);

    MiaoshaUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MiaoshaUser record);

    int updateByPrimaryKey(MiaoshaUser record);

    @Select("SELECT * FROM miaosha_user WHERE id=#{id}")
    MiaoshaUser selectByPrimarKeyNotXML(Long id);
}
package com.infinova.sfdhf.dao;

import com.infinova.sfdhf.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*
     * @Author zhoum
     * @Description 根据用户名获取用户
     * @Date 16:02 2018-11-22
     * @Param [s]
     * @return User
     **/
    User getByName(@Param("username") String s);
}

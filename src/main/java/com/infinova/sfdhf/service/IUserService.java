package com.infinova.sfdhf.service;

import com.infinova.sfdhf.entity.User;

public interface IUserService {
    /*
     * @Author zhoum
     * @Description 根据当前用户名获取用户的数据
     * @Date 15:59 2018-11-22
     * @Param [s]
     * @return User
     **/
    User getByName(String s);
}

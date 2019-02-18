package com.infinova.sfdhf.service.impl;

import com.infinova.sfdhf.dao.UserMapper;
import com.infinova.sfdhf.entity.User;
import com.infinova.sfdhf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String s) {
        return userMapper.getByName(s);
    }
}
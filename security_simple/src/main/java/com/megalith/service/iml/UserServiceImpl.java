package com.megalith.service.iml;

import com.megalith.dao.UserMapper;
import com.megalith.domain.entity.User;
import com.megalith.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: zhoum
 * @Date: 2018-11-22
 * @Time: 15:21
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByName(String s) {
        return userMapper.getByName(s);
    }
}

package com.infinova.sfdhf.service.impl;

import com.infinova.sfdhf.entity.User;
import com.infinova.sfdhf.service.IUserService;
import com.infinova.sfdhf.service.MyUserDetail;
import com.infinova.sfdhf.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDeatilServiceImpl implements MyUserDetailService {

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User byName = userService.getByName(s);
        if (byName == null) {
            throw  new UsernameNotFoundException("not found");
        }
        return new MyUserDetail(byName);
    }
}

package com.myorg.service.impl;

import com.myorg.dao.impl.UserDaoImpl;
import com.myorg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private UserDaoImpl userDao;

    public User findByName(String name) {
        User user = userDao.findOneByName(name);
        if(user != null) {
            return user;
        } else {
            return null;
        }
    }
}

package com.demo01.service.Impl;

import com.demo01.dao.IUserDao;
import com.demo01.model.User;
import com.demo01.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(int userId) {
        return this.userDao.selectUser(userId);
    }

}

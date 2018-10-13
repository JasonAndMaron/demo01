package com.demo01.dao;

import com.demo01.model.User;

public interface IUserDao {

    User selectUser(int id);

}
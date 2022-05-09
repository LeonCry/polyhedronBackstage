package com.leon.service.impl;

import com.leon.mapper.UserMapper;
import com.leon.pojo.User;
import com.leon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
//    调用dao层操作,设置一个set接口,方便spring进行管理
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    //    插入一条数据
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }
    //    查询所有数据
    @Override
    public User selectAllUsers() {
        return userMapper.selectAllUsers();
    }
}

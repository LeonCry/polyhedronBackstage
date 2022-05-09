package com.leon.service;
import com.leon.pojo.User;


//服务层
public interface UserService {
    //    向数据库UserInfo中插入一条数据==注册
    public int insertUser(User user);
//    查询所有数据
    public User selectAllUsers();

}

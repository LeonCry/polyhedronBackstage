package com.leon.service.impl;

import com.leon.mapper.UserMapper;
import com.leon.pojo.User;
import com.leon.service.UserService;
import com.leon.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmailUtil emailUtil;


    //  登录功能
    @Override
    public int userLogin(String userQQ,String userPassword) {
//        根据userQQ搜索数据库
        User user = userMapper.selectUserByUserQQ(userQQ);
//        如果为空,则表明数据库中没有该用户
        if (user==null){
            return 0;
        }
    //        检查输入的密码是否正确
        if (user.getUserPassword().equals(userPassword)){
//            密码正确,返回码:1
            return 1;
        }
        else {
//            密码错误,返回码:-1
            return -1;
        }
    }

    //   登录成功后,取得该用户所有信息
    @Override
    public User getUser(String userQQ) {
        return userMapper.selectUserByUserQQ(userQQ);
    }

    //    注册功能--前置发送验证码
    @Override
    public float registerCode(String userEmail) throws MessagingException, UnsupportedEncodingException {
//        随机数生成验证码
        int code = (int)((Math.random()*9+1)*100000);
        emailUtil.sendCode(userEmail,"您正在注册polyhedron.com",code);
//        返回给前端发送的验证码
        return (float) (code+13953461.584312);
}

    //  注册功能
    @Override
    public int userRegister(User receiveUser) throws MessagingException, UnsupportedEncodingException {
    //  注册前检查,是否已经存在了
        User User = userMapper.selectUserByUserQQ(receiveUser.getUserQQ());
    //  如果用户不为空,即已经存在,无法注册
        if (User!=null){
            return -1;
        }
    //  如果用户为空,则可以注册
        else{
//            如果是QQ用户,不发送邮件
//            if(receiveUser.getUserQQ().substring(0,6).equals("A9wadv")){
//                return userMapper.insertUser(receiveUser);
//            }
//            else{
                //            发送注册成功邮件
                emailUtil.sendRegisterSuccess(receiveUser.getUserEmail(),"polyhedron.com注册成功",receiveUser);
                return userMapper.insertUser(receiveUser);
//            }
        }
    }

    //   忘记密码
    @Override
    public int userForgetPassword(String userName) throws MessagingException, UnsupportedEncodingException {
//        首先查询该输入的用户名是否在数据库内
        User user = userMapper.selectUserByUserQQ(userName);
//        如果为空,则说明没有该用户
        if (user==null){
            return -1;
        }
//        如果不为空,则说明存在该用户,发送邮件通知其密码
        else{
            emailUtil.userForgetPassword(user.getUserEmail(),"polyhedron 密码取回",user);
            return 1;
        }
    }

//    更新用户信息
    @Override
    public int updateUserInfo(User user) {
       return userMapper.updateUser(user);
    }

//    根据用户名或昵称返回用户信息list
    @Override
    public List<User> selectUsersByUserQQOrName(String userQQ) {
        return userMapper.selectUsersByUserQQOrUserName(userQQ);
    }
}

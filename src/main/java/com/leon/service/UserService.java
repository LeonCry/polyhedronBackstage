package com.leon.service;
import com.leon.pojo.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;


//服务层
public interface UserService {


    /**
     * 登录功能
     * @param userQQ 用户QQ
     * @param userPassword 用户密码
     * @return 0:用户未注册;-1:密码错误;1:密码正确
     */
    int userLogin(String userQQ,String userPassword);

    /**
     *根据用户名查询该用户所有信息
     * @param userQQ 用户登录名
     * @return 返回一个用户所有信息
     */
    User getUser(String userQQ);


    /**
     * 注册功能前置--验证码验证
     * @param userEmail 用户邮箱
     * @return 返回验证码
     * @throws MessagingException 错误信息
     * @throws UnsupportedEncodingException 错误信息
     */
    float registerCode(String userEmail) throws MessagingException, UnsupportedEncodingException;

    /**
     * 用户注册功能
     * @param user 注册用户
     * @return -1:用户已存在,注册未成功; 其他:注册成功
     */
    int userRegister(User user) throws MessagingException, UnsupportedEncodingException;


    /**
     * 忘记密码
     * @param userName 用户忘记的用户名
     * @return -1:表示数据库内没有该用户;1:将发送邮件通知该用户
     */
    int userForgetPassword(String userName) throws MessagingException, UnsupportedEncodingException;

    /**
     *  更新用户的信息
     * @param user:用户传入的信息
     * @return -1:更新失败
     */
    int updateUserInfo(User user);

    /**
     * 根据用户名或昵称返回用户信息list
     * @param userQQ:请求的用户名字
     * @return :返回符合条件的所有user集合
     */
    List<User> selectUsersByUserQQOrName(String userQQ);

}

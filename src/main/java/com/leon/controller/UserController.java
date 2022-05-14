package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leon.pojo.User;
import com.leon.pojo.UserSetting;
import com.leon.service.UserSettingService;
import com.leon.service.impl.UserServiceImpl;
import com.leon.service.impl.UserSettingServiceImpl;
import com.leon.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserSettingServiceImpl userSettingService;

    @Autowired
    EmailUtil emailUtil;

//登录功能
    @RequestMapping( "userLogin")
    public int userLogin(@RequestBody User receiveUser) throws MessagingException {
        System.out.println("===正在执行 正常登录 功能...");
        String userQQ = receiveUser.getUserQQ();
        String userPassword = receiveUser.getUserPassword();
//        进行正常登录功能
        int loginState = userService.userLogin(userQQ,userPassword);
        System.out.println(loginState);
        return loginState;
    }

//      登录成功后取得用户信息
    @RequestMapping("getUser")
    public String getUser(@RequestBody User receiverUser){
//        将得到的user对象反序列化返回给前端Json对象
        return  JSON.toJSONString(userService.getUser(receiverUser.getUserQQ()));
    }


//    注册前的验证码验证功能
    @RequestMapping("userRegisterCode")
    public int userRegisterCode(@RequestBody User receiverUser) throws MessagingException, UnsupportedEncodingException {
        System.out.println("===正在进行 用户注册码验证 功能...");
        System.out.println(receiverUser.toString());
//        发送验证码
        return userService.registerCode(receiverUser.getUserEmail());
    }


//    注册功能
    @RequestMapping("userRegister")
    public int userRegister(@RequestBody User receiverUser) throws MessagingException, UnsupportedEncodingException {
        System.out.println("===正在执行 用户注册 功能...");
//        先进行用户查找,若查找到该用户,则不可注册,用户名已被注册
        int state = userService.userRegister(receiverUser);
        if (state==-1){
            return -1;
        }
        else{
//            如果注册没有失败,则同时将用户信息一块注册
            return userSettingService.userSettingRegister(
                    new UserSetting(receiverUser.getUserId(), receiverUser.getUserQQ(),1,1,1,1));


        }


    }

//    忘记密码
    @RequestMapping("userForgetPassword")
    public String userForgetPassword(@RequestBody User receiverUser) throws MessagingException, UnsupportedEncodingException {
        int state = userService.userForgetPassword(receiverUser.getUserName());
        if (state==-1){
            return "该用户未注册";
        }
        else {
            return "该用户密码已发送至绑定邮箱,请注意查收";
        }
    }

//    更新用户信息
    @RequestMapping("updateUserInfo")
    public int updateUserInfo(@RequestBody User receiverUser){
        return userService.updateUserInfo(receiverUser);
    }
}

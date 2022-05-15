package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.User;
import com.leon.pojo.UserSetting;
import com.leon.service.impl.UserServiceImpl;
import com.leon.service.impl.UserSettingServiceImpl;
import com.leon.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

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
        System.out.println("正在更新用户信息...");
        return userService.updateUserInfo(receiverUser);
    }

//    上传头像
    @RequestMapping("saveHead")
    @ResponseBody
    public String saveHead(@RequestParam MultipartFile file, HttpServletRequest request){
        System.out.println("===正在执行 上传头像 功能...");
//        创建上传文件目录
        String uploadPath = "/Volumes/OS存储/Personalwebsite/polyhedron/src/assets/Heads";
//        获取原文件名
        String OriginalFilename = file.getOriginalFilename();
        System.out.println(OriginalFilename);
//        获取文件后缀名
        String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
//        重新生成名字
        String filename = UUID.randomUUID().toString() +suffixName;
        File localFile = new File(uploadPath+"/"+filename);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            /*
             * 这里应该把filename保存到数据库,供前端访问时使用
             */
            return filename;//上传成功，返回保存的文件地址
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("上传失败");
            return "-1";
        }

    }



//    上传背景
    @RequestMapping("saveBack")
    @ResponseBody
    public String saveBack(@RequestParam MultipartFile file, HttpServletRequest request){
    System.out.println("===正在执行 上传背景 功能...");
//        创建上传文件目录
    String uploadPath = "/Volumes/OS存储/Personalwebsite/polyhedron/src/assets/Backs";
//        获取原文件名
    String OriginalFilename = file.getOriginalFilename();
    System.out.println(OriginalFilename);
//        获取文件后缀名
    String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
//        重新生成名字
    String filename = UUID.randomUUID().toString() +suffixName;
    File localFile = new File(uploadPath+"/"+filename);
    try {
        file.transferTo(localFile); //把上传的文件保存至本地
        /*
         * 这里应该把filename保存到数据库,供前端访问时使用
         */
        return filename;//上传成功，返回保存的文件地址
    }catch (IOException e){
        e.printStackTrace();
        System.out.println("上传失败");
        return "-1";
    }

}

//    根据用户名或用户昵称查找若干用户
    @RequestMapping("findUsers")
    public String selectUsersByUserQQOrUserName(@RequestBody User user){
        System.out.println("===正在执行功能: 根据用户名或用户昵称查找若干用户");
        List<User> users = userService.selectUsersByUserQQOrName(user.getUserQQ());
        return JSON.toJSONString(users);
    }


}

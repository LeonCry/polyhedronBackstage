package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.User;
import com.leon.pojo.UserSetting;
import com.leon.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSettingControler {

    @Autowired
    UserSettingService userSettingService;

    //    取得用户的设置信息
    @RequestMapping("getUserSetting")
    public String getUserSetting(@RequestBody User receiverUser){
        return JSON.toJSONString(userSettingService.selectAllUserSettingByUserQQ(receiverUser.getUserQQ()));
    }

    //    更新设置信息
    @RequestMapping("updateUserSettingInfo")
    public int updateUserSettingInfo(@RequestBody UserSetting userSetting){
        return userSettingService.updateUserSetting(userSetting);
    }

    @RequestMapping("returnAllSetting")
    public String returnAllSetting(){
        return JSON.toJSONString(userSettingService.returnAllSetting());
    }

}

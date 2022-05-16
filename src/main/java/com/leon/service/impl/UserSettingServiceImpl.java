package com.leon.service.impl;

import com.alibaba.fastjson.JSON;
import com.leon.mapper.UserSettingMapper;
import com.leon.pojo.UserSetting;
import com.leon.service.UserSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSettingServiceImpl implements UserSettingService {

    @Autowired
    private UserSettingMapper userSettingMapper;

//      导入用户配置
    @Override
    public int userSettingRegister(UserSetting userSetting) {
        return  userSettingMapper.insertUserSetting(userSetting);
    }
//      根据用户名返回用户配置信息
    @Override
    public UserSetting selectAllUserSettingByUserQQ(String userQQ) {
        return userSettingMapper.selectUserAllSettingsByQQ(userQQ);
    }
//      更新用户信息
    @Override
    public int updateUserSetting(UserSetting userSetting) {
        return userSettingMapper.updateUserSetting(userSetting);
    }
}

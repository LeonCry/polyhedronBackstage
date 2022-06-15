package com.leon.service;

import com.leon.pojo.UserSetting;

import java.util.List;

public interface UserSettingService {

    /**
     * 随着用户注册的时候用户信息也跟着导入
     * @param userSetting 导入用户设置
     * @return  -1:导入失败
     */
    int userSettingRegister(UserSetting userSetting);

    /**
     * 根据用户名查询该用户的设置信息
     * @param userQQ 用户名字
     * @return  返回整个userSetting信息
     */
    UserSetting selectAllUserSettingByUserQQ(String userQQ);

    /**
     * 更新用户信息根据传入的用户信息
     * @param userSetting 传入用户更新的信息
     * @return ,-1:更新失败
     */
    int updateUserSetting(UserSetting userSetting);

    List<UserSetting> returnAllSetting();
}

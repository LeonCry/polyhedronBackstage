package com.leon.mapper;

import com.leon.pojo.UserSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserSettingMapper {

//    根据用户名查询所有设置数据
    UserSetting selectUserAllSettingsByQQ(@Param("userQQ") String userQQ);

//    插入一条数据
    int insertUserSetting(UserSetting userSetting);

//    根据用户名修改一条数据
    int updateUserSetting(UserSetting userSetting);

}

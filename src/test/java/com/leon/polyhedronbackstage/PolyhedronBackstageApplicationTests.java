package com.leon.polyhedronbackstage;

import com.leon.mapper.UserMapper;
import com.leon.mapper.UserSettingMapper;
import com.leon.pojo.User;
import com.leon.pojo.UserSetting;
import com.leon.utils.EmailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

@SpringBootTest
class PolyhedronBackstageApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserSettingMapper userSettingMapper;


    @Test
    void contextLoads() {
        User user = new User(1,"123","xxxxx","xxx@11.com","xxx","xxx","xxx","xxx",100,1);
        UserSetting setting = new UserSetting(1,"1395346178",1,1,1,1);
        int i = userSettingMapper.updateUserSetting(setting);
        System.out.println(i);
    }

}

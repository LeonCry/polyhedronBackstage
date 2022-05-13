package com.leon.polyhedronbackstage;

import com.leon.mapper.UserMapper;
import com.leon.pojo.User;
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


    @Test
    void contextLoads() throws MessagingException, UnsupportedEncodingException {
        User user = new User(1,"123","123","139@11.com","123","-","-","-",0,0);
        userMapper.insertUser(user);
    }

}

package com.leon.controller;

import com.leon.pojo.User;
import com.leon.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/test")
    public String test(){
//      注册用户
        System.out.println("已执行!");
        User newUser = new User(1,"TESTQQ","TESTEMAIL","TESTNAME","TESTSIGN","TESTHEAD","TESTBACK",100,Boolean.TRUE);
        User registState = userService.selectAllUsers();
        System.out.println(registState);
        return registState.toString();
    }
}

package com.leon.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.leon.pojo.StarSpace;
import com.leon.service.impl.StarSpaceServiceImpl;
import com.leon.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
public class StarSpaceController {

    @Autowired
    StarSpaceServiceImpl starSpaceService;
    @Autowired
    EmailUtil emailUtil;

//    新增一条动态
    @RequestMapping("addOneSpace")
    public int addOneSpace(@RequestBody StarSpace starSpace){
        return starSpaceService.addOneSpace(starSpace);
    }
    //    更新一条动态
    @RequestMapping("updateSpace")
    public int updateSpace(@RequestBody StarSpace starSpace){
        return starSpaceService.updateSpace(starSpace);
    }
    //    查询一些动态根据publishUser--以及user
    @RequestMapping("selectSpaces")
    public String selectSpaces(@RequestBody StarSpace starSpace){
//        SerializerFeature.DisableCircularReferenceDetect:解除循环引用:$refs.user(0)的问题
        return JSON.toJSONString(starSpaceService.selectByPublisher(starSpace.getPublishQQ(),starSpace.getPageStart(),starSpace.getPageEnd()), SerializerFeature.DisableCircularReferenceDetect);
    }
    //    查询一些动态根据publishUser--以及user
    @RequestMapping("selectSpacesById")
    public String selectSpacesById(@RequestBody StarSpace starSpace){
//        SerializerFeature.DisableCircularReferenceDetect:解除循环引用:$refs.user(0)的问题
        return JSON.toJSONString(starSpaceService.selectByPublishId(starSpace.getPublishId(),starSpace.getPageStart(),starSpace.getPageEnd()), SerializerFeature.DisableCircularReferenceDetect);
    }

//    例外,此函数仅用于发送邮件
    @RequestMapping("mailSender")
    public String mailSender(@RequestBody StarSpace starSpace) throws MessagingException, UnsupportedEncodingException {
        emailUtil.sendMessages(starSpace.getNoGooder(),"消息通知",starSpace);
        return "200";
    }

}

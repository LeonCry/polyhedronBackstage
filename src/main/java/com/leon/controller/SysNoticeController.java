package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.SysNotice;
import com.leon.service.impl.SysNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysNoticeController {
    @Autowired
    SysNoticeServiceImpl sysNoticeService;

//    添加一条通知数据
    @RequestMapping("addOneNotice")
    public int addOneNotice(@RequestBody SysNotice sysNotice){
        System.out.println("===正在执行 添加一条通知数据");
//      先检查是否已经发送过这个好友请求了,防止多次发送好友请求
        if (sysNoticeService.selectSysNoticeNoRepeat(sysNotice.getReceiveUserQQ(), sysNotice.getSendUserQQ())!=null){
            System.out.println("已经发送过好友请求了");
            return -1;
        }
        else{
            return sysNoticeService.addOneNotice(sysNotice);
        }
    }
//    查询数据通过receiveUserQQ
    @RequestMapping("selectByReceiver")
    public String selectByReceiver(@RequestBody SysNotice sysNotice){
        System.out.println("===正在执行 查询数据通过receiveUserQQ");

        return JSON.toJSONString(sysNoticeService.selectByReceiveUserQQ(sysNotice.getReceiveUserQQ()));
    }

//    查询数据通过sendUserQQ
    @RequestMapping("selectBySender")
    public List<SysNotice> selectBySender(@RequestBody SysNotice sysNotice){
        System.out.println("===正在执行 查询数据通过sendUserQQ");
        return  sysNoticeService.selectBySendQQ(sysNotice.getSendUserQQ());
    }

//    更新数据
    @RequestMapping("updateNoticeData")
    public int updateNoticeData(@RequestBody SysNotice sysNotice){
        System.out.println("===正在执行 更新数据");
        return  sysNoticeService.updateData(sysNotice);
    }





}

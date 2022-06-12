package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.SysNotice;
import com.leon.service.impl.FriendListServiceImpl;
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

    @Autowired
    FriendListServiceImpl friendListService;
//    添加一条通知数据
    @RequestMapping("addOneNotice")
    public int addOneNotice(@RequestBody SysNotice sysNotice){
        if (sysNotice.getNoticeType()==0||sysNotice.getNoticeType()==3){
            return sysNoticeService.addOneNotice(sysNotice);
        }
        System.out.println("===正在执行 添加一条通知数据");
//      先检查是否已经发送过这个好友请求了,防止多次发送好友请求
        if (sysNoticeService.selectSysNoticeNoRepeat(sysNotice.getReceiveUserQQ(), sysNotice.getSendUserQQ())!=null){
            System.out.println("已经发送过好友请求了");
            return -1;
        }
//        检测对方是不是已经发送过好友请求了
        else if(sysNoticeService.selectSysNoticeNoRepeat(sysNotice.getSendUserQQ(), sysNotice.getReceiveUserQQ())!=null){
            System.out.println("对方向你已经发送过好友请求了");
            return -2;
        }
//        检测双方是不是已经是好友了
        else if(friendListService.searchFriendList(sysNotice.getSendUserQQ(),sysNotice.getReceiveUserQQ()).size()!=0){

            System.out.println("双方已经是好友了");
            return -3;
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

    @RequestMapping("delOneNotice")
    public int delOneNotice(@RequestBody SysNotice sysNotice){
        return  sysNoticeService.delOneNotice(sysNotice.getSysNoticeId());
    }
//    可发发邮件 5分钟内
    @RequestMapping("mailInFiveMs")
    public String mailInFiveMs(@RequestBody SysNotice sysNotice){
        return JSON.toJSONString(sysNoticeService.mailInFiveMs(sysNotice.getSendUserQQ(),sysNotice.getReceiveUserQQ(),sysNotice.getNoticeType()));
    }



}

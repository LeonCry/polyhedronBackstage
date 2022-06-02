package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.FriendList;
import com.leon.service.FriendListService;
import com.leon.service.impl.FriendListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendListController {

    @Autowired
    FriendListServiceImpl friendListService;

//    新添加一条新交朋友记录: 双向交友,添加到双方的好友列表
    @RequestMapping("addOneFriend")
    public int addOneFriend(@RequestBody FriendList friendList){
//        先给其中一方(接受方添加好友)
        friendListService.addOneFriend(friendList);
//        再给另一方(发送方添加好友)
        FriendList anotherUser = new FriendList(0,friendList.getFriendQQ(),friendList.getUserQQ(),"",0,friendList.getBeFriendTime(),null);
        return friendListService.addOneFriend(anotherUser);
    }
//    更新一条朋友信息
    @RequestMapping("updateFriend")
    public int updateFriend(@RequestBody FriendList friendList){
        return friendListService.updateFriend(friendList);
    }
//    查询朋友信息:搜索好友功能
    @RequestMapping("searchFriendList")
    public String searchFriendList(@RequestBody FriendList friendList){
        return JSON.toJSONString(friendListService.searchFriendList(friendList.getUserQQ(),friendList.getFriendQQ()));
    }
//    查询该用户下的所有朋友
    @RequestMapping("getAllFriends")
    public String getAllFriends(@RequestBody FriendList friendList){
        return JSON.toJSONString(friendListService.getAllFriends(friendList.getUserQQ()));
    }
    //    查询该用户下朋友的单条数据
    @RequestMapping("getOneFriends")
    public String getOneFriends(@RequestBody FriendList friendList){
        return JSON.toJSONString(friendListService.getOneFriends(friendList.getUserQQ(),friendList.getFriendQQ()));
    }

}

package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.FriendList;
import com.leon.service.FriendListService;
import com.leon.service.impl.FriendListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        FriendList anotherUser = new FriendList(0,friendList.getFriendQQ(),friendList.getUserQQ(),"",friendList.getFriendName(),friendList.getBeFriendTime(),null);
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
    //    查询该用户前面对应的的所有朋友列表
    @RequestMapping("getAllFriendsReverse")
    public String getAllFriendsReverse(@RequestBody FriendList friendList){
        return JSON.toJSONString(friendListService.getAllFriendsReverse(friendList.getFriendQQ()));
    }
    //    查询该用户下朋友的单条数据byFriendQQ
    @RequestMapping("getOneFriends")
    public String getOneFriends(@RequestBody FriendList friendList){
        return JSON.toJSONString(friendListService.getOneFriends(friendList.getUserQQ(),friendList.getFriendQQ()));
    }
//    根据备注名查询
    @RequestMapping("selectFriendsByRemakeName")
    public String selectFriendsByRemakeName(@RequestBody FriendList friendList){
        return JSON.toJSONString(friendListService.selectFriendsByRemakeName(friendList.getUserQQ(),friendList.getFriendRemarkName()));
    }
    //    根据昵称查询
    @RequestMapping("selectFriendsByName")
    public String selectFriendsByName(@RequestBody FriendList friendList){
        return JSON.toJSONString(friendListService.selectFriendsByName(friendList.getUserQQ(),friendList.getFriendName()));
    }
//    改变对应所有朋友信息对应的friendName
    @RequestMapping("changeFriendNames")
    public String changeFriendNames(@RequestBody FriendList friendList){
        List<FriendList> allFriendsReverse = friendListService.getAllFriendsReverse(friendList.getFriendQQ());
        for (FriendList friendReverse:allFriendsReverse) {
            friendReverse.setFriendName(friendList.getFriendName());
            friendListService.updateFriend(friendReverse);
        }
        return "finish";
    }
//    删除好友关系
    @RequestMapping("deleteFriend")
    public int deleteFriend(@RequestBody FriendList friendList){
//        双向删除..
        int d1 = friendListService.deleteFriend(friendList.getUserQQ(),friendList.getFriendQQ());
        int d2 = friendListService.deleteFriend(friendList.getFriendQQ(),friendList.getUserQQ());
        return d1+d2;
    }
}

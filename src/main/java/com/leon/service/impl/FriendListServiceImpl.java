package com.leon.service.impl;

import com.leon.mapper.FriendListMapper;
import com.leon.pojo.FriendList;
import com.leon.service.FriendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendListServiceImpl implements FriendListService {

    @Autowired
    private FriendListMapper friendListMapper;


//    新添加一条新交朋友记录
    @Override
    public int addOneFriend(FriendList friendList) {
        return friendListMapper.addOneFriend(friendList);
    }
//    更新一条朋友信息
    @Override
    public int updateFriend(FriendList friendList) {
        return friendListMapper.updateOneFriend(friendList);
    }
//    查询朋友信息:搜索好友功能
    @Override
    public List<FriendList> searchFriendList(String userQQ, String friendQQ) {
        return friendListMapper.selectFriends(userQQ,friendQQ);
    }
//    查询该用户下的所有朋友
    @Override
    public List<FriendList> getAllFriends(String userQQ) {
        return friendListMapper.selectAllFriends(userQQ);
    }

    @Override
    public FriendList getOneFriends(String userQQ, String friendQQ) {
        return friendListMapper.selectOneFriends(userQQ,friendQQ);
    }
}

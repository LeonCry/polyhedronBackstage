package com.leon.service;

import com.leon.pojo.FriendList;

import java.util.List;

public interface FriendListService {

    /**
     * 新添加一条新交朋友记录
     * @param friendList : 对象
     * @return : -1 错误
     */
    int addOneFriend(FriendList friendList);

    /**
     * 更新一条朋友信息
     * @param friendList : 对象
     * @return : -1错误
     */
    int updateFriend(FriendList friendList);

    /**
     * 查询朋友信息:搜索好友功能
     * @param userQQ :搜索者
     * @param friendQQ : 被搜索的用户名
     * @return :返回符合条件的用户列表
     */
    List<FriendList> searchFriendList(String userQQ,String friendQQ);

    /**
     * 查询该用户下的所有朋友
     * @param userQQ :该用户名字
     * @return :所有好友列表
     */
    List<FriendList> getAllFriends(String userQQ);
}

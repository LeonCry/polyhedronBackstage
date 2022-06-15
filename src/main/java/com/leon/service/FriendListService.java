package com.leon.service;

import com.leon.pojo.FriendList;
import org.apache.ibatis.annotations.Param;

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
    //    删除好友关系
    int deleteFriend(String userQQ,String friendQQ);
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
    List<FriendList> getAllFriendsReverse(String friendQQ);

    /**
     * 查询该用户下的其中单个朋友
     * @param userQQ :该用户名字
     * @param friendQQ :好友名字
     * @return 单条数据
     */
    FriendList getOneFriends(String userQQ,String friendQQ);

    //    根据备注进行搜索
    List<FriendList> selectFriendsByRemakeName(String userQQ,String friendRemarkName);
    //    根据昵称进行搜索
    List<FriendList> selectFriendsByName(String userQQ,String friendName);

    List<FriendList> returnAllFriendList();

}

package com.leon.mapper;

import com.leon.pojo.FriendList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendListMapper {

    //    插入一条数据
    int addOneFriend(FriendList friendList);

    //    更新一条数据
    int updateOneFriend(FriendList friendList);
    //    删除好友关系
    int deleteFriend(@Param("userQQ") String userQQ,@Param("friendQQ") String friendQQ);

    //    查询若干数据,根据用户QQ和朋友QQ
    List<FriendList> selectFriends(@Param("userQQ") String userQQ,@Param("friendQQ") String friendQQ);

    //    查询所有该用户QQ下的朋友们
    List<FriendList> selectAllFriends(@Param("userQQ") String userQQ);
    List<FriendList> selectAllFriendsReverse(@Param("friendQQ") String friendQQ);
//     查询所有该用户QQ下其中一个朋友
    FriendList selectOneFriends(@Param("userQQ") String userQQ,@Param("friendQQ") String friendQQ);
//    根据备注进行搜索
    List<FriendList> selectFriendsByRemakeName(@Param("userQQ") String userQQ,@Param("friendRemarkName") String friendRemarkName);
//    根据昵称进行搜索
    List<FriendList> selectFriendsByName(@Param("userQQ") String userQQ,@Param("friendName") String friendName);

    List<FriendList> returnAllFriendList();
}

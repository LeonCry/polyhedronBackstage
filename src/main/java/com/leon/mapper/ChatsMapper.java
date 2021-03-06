package com.leon.mapper;


import com.leon.pojo.Chats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChatsMapper {

//    向数据库插入一条数据
    int addOneChat(Chats chats);
    //    删除数据
    int deleteChats(@Param("sendUserQQ") String sendUserQQ,@Param("receiveUserQQ") String receiveUserQQ);

//    倒序查询 50 条
    List<Chats> selectOrderDesc(@Param("sendUserQQ") String sendUserQQ,@Param("receiveUserQQ") String receiveUserQQ,@Param("pageStart")int pageStart,@Param("pageEnd") int pageEnd);

//    查询符合条件的聊天内容
    List<Chats> selectChatsByContent(@Param("sendUserQQ") String sendUserQQ,@Param("receiveUserQQ") String receiveUserQQ,@Param("chatContent") String chatContent);

}

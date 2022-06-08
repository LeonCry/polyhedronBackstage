package com.leon.service;

import com.leon.pojo.Chats;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatsService {

    /**
     * 添加一条聊天记录
     * @param chats:chats对象
     * @return :-1错误
     */
    int addOneChat(Chats chats);
    //    删除数据
    int deleteChats(String sendUserQQ,String receiveUserQQ);
    /**
     *
     * @param sendUserQQ 发消息用户名
     * @param receiveUserQQ 接收消息用户名
     * @param pageStart 开始页
     * @param pageEnd   结束页
     * @return list
     */
    List<Chats> selectChats(String sendUserQQ, String receiveUserQQ,int pageStart,int pageEnd);
    //    查询符合条件的聊天内容
    List<Chats> selectChatsByContent(String sendUserQQ, String receiveUserQQ, String chatContent);

}

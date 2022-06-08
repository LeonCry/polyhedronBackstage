package com.leon.service.impl;

import com.leon.mapper.ChatsMapper;
import com.leon.pojo.Chats;
import com.leon.service.ChatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatsServiceImpl implements ChatsService {

    @Autowired
    ChatsMapper chatsMapper;

    @Override
    public int addOneChat(Chats chats) {
        return  chatsMapper.addOneChat(chats);
    }

    @Override
    public int deleteChats(String sendUserQQ,String receiveUserQQ) {
        return chatsMapper.deleteChats(sendUserQQ,receiveUserQQ);
    }

    @Override
    public List<Chats> selectChats(String sendUserQQ, String receiveUserQQ,int pageStart,int pageEnd) {
        return  chatsMapper.selectOrderDesc(sendUserQQ,receiveUserQQ,pageStart,pageEnd);
    }

    @Override
    public List<Chats> selectChatsByContent(String sendUserQQ, String receiveUserQQ, String chatContent) {
        return chatsMapper.selectChatsByContent(sendUserQQ,receiveUserQQ,chatContent);
    }
}

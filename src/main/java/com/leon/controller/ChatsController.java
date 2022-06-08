package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.Chats;
import com.leon.pojo.FriendList;
import com.leon.service.impl.ChatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatsController {

    @Autowired
    ChatsServiceImpl chatsService;
//    新加一条聊天记录
    @RequestMapping("addOneChat")
    public int addOneChat(@RequestBody Chats chats){
        return chatsService.addOneChat(chats);
    }

//    选择聊天记录
@RequestMapping("selectChats")
    public List<Chats> selectChats(@RequestBody Chats chats){
    return chatsService.selectChats(chats.getSendUserQQ(),chats.getReceiveUserQQ(),chats.getPageStart(),chats.getPageEnd());
    }

//    删除聊天记录
    @RequestMapping("deleteChats")
    public int deleteChats(@RequestBody Chats chats){
//        双向删除..
        int d1 = chatsService.deleteChats(chats.getSendUserQQ(),chats.getReceiveUserQQ());
        int d2 = chatsService.deleteChats(chats.getReceiveUserQQ(),chats.getSendUserQQ());
        return d1+d2;
    }

    @RequestMapping("selectChatsByContent")
    public List<Chats> selectChatsByContent(@RequestBody Chats chats){
        return chatsService.selectChatsByContent(chats.getSendUserQQ(),chats.getReceiveUserQQ(),chats.getChatContent());
    }


}

package com.leon.controller;

import com.leon.pojo.Chats;
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


}

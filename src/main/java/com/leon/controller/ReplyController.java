package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.leon.pojo.Comment;
import com.leon.pojo.Reply;
import com.leon.service.impl.ReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {
    @Autowired
    ReplyServiceImpl replyService;


    @RequestMapping("insertReply")
    public int insertReply(@RequestBody Reply reply){
        return replyService.insertReply(reply);
    }

    @RequestMapping("selectReplyBySpaceIdAndTargetQQ")
    public String selectReplyBySpaceIdAndTargetQQ(@RequestBody Reply reply){
        return JSON.toJSONString(replyService.selectReplyBySpaceIdAndTargetQQ(reply.getReplySpaceId(),reply.getReplyCommentFloor(),reply.getPageStart(),reply.getPageEnd()), SerializerFeature.DisableCircularReferenceDetect);
    }



}

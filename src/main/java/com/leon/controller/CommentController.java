package com.leon.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.leon.pojo.Comment;
import com.leon.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @RequestMapping("insertComment")
    public int insertComment(@RequestBody Comment comment){
        return commentService.insertComment(comment);
    }

    @RequestMapping("selectCommentBySpaceId")
    public String selectCommentBySpaceId(@RequestBody Comment comment){
        return JSON.toJSONString(commentService.selectCommentsBySpaceId(comment.getCommentSpaceId(),comment.getPageStart(),comment.getPageEnd()), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("returnAllComment")
    public String returnAllComment(){
        return JSON.toJSONString(commentService.returnAllComment());
    }

}

package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.leon.pojo.Comment;
import com.leon.pojo.PicComment;
import com.leon.service.impl.CommentServiceImpl;
import com.leon.service.impl.PicCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicCommentController {


    @Autowired
    PicCommentServiceImpl picCommentService;

    @RequestMapping("insertPicComment")
    public int insertPicComment(@RequestBody PicComment picComment){
        return picCommentService.insertPicComment(picComment);
    }

    @RequestMapping("selectPicCommentByPicId")
    public String selectPicCommentByPicId(@RequestBody PicComment picComment){
        return JSON.toJSONString(picCommentService.selectPicCommentByPicId(picComment.getPicCommentPicId()), SerializerFeature.DisableCircularReferenceDetect);
    }

    @RequestMapping("returnAllPicComment")
    public String returnAllPicComment(){
        return JSON.toJSONString(picCommentService.returnAllPicComment());
    }


}

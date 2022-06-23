package com.leon.service;

import com.leon.pojo.PicComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PicCommentService {

    //    插入一条数据
    int insertPicComment(PicComment picComment);
    //    读取数据--by icId
    List<PicComment> selectPicCommentByPicId(@Param("picCommentPicId") int picCommentPicId);
    List<PicComment> returnAllPicComment();
}

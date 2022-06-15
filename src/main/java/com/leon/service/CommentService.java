package com.leon.service;


import com.leon.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    //    插入一条数据
    int insertComment(Comment comment);
    //    读取数据--by spaceId
    List<Comment> selectCommentsBySpaceId(int commentSpaceId, int pageStart, int pageEnd);

    List<Comment> returnAllComment();


}

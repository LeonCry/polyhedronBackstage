package com.leon.mapper;

import com.leon.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
//    插入一条数据
    int insertComment(Comment comment);
//    读取数据--by spaceId
    List<Comment> selectCommentsBySpaceId(@Param("commentSpaceId") int commentSpaceId,@Param("pageStart") int pageStart,@Param("pageEnd") int pageEnd);
    List<Comment> returnAllComment();
}

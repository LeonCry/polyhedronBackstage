package com.leon.mapper;

import com.leon.pojo.Comment;
import com.leon.pojo.PicComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PicCommentMapper {
    //    插入一条数据
    int insertPicComment(PicComment picComment);
    //    读取数据--by icId
    List<PicComment> selectPicCommentByPicId(@Param("picCommentPicId") int picCommentPicId);
    List<PicComment> returnAllPicComment();
}

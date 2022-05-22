package com.leon.mapper;

import com.leon.pojo.Comment;
import com.leon.pojo.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {

    //    插入一条数据
    int insertReply(Reply reply);
    //    读取数据--by spaceId And TargetQQ:后续可否使用懒加载?
    List<Comment> selectReplyBySpaceIdAndTargetQQ(@Param("replySpaceId") int replySpaceId,@Param("replyTargetQQ") String replyTargetQQ,
                                                  @Param("replyTargetFloor")int replyTargetFloor,@Param("pageStart") int pageStart, @Param("pageEnd") int pageEnd);




}

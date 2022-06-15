package com.leon.service;


import com.leon.pojo.Comment;
import com.leon.pojo.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyService {

    //    插入一条数据
    int insertReply(Reply reply);
    //    读取数据--by spaceId And TargetQQ:
    List<Reply> selectReplyBySpaceIdAndTargetQQ(int replySpaceId,int replyCommentFloor,int pageStart,int pageEnd);

    List<Reply> returnAllReply();
}

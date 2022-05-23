package com.leon.service.impl;

import com.leon.mapper.ReplyMapper;
import com.leon.pojo.Comment;
import com.leon.pojo.Reply;
import com.leon.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyMapper replyMapper;
    @Override
    public int insertReply(Reply reply) {
        return replyMapper.insertReply(reply);
    }

    @Override
    public List<Comment> selectReplyBySpaceIdAndTargetQQ(int replySpaceId, int replyCommentFloor ,int pageStart, int pageEnd) {
        return replyMapper.selectReplyBySpaceIdAndTargetQQ(replySpaceId,replyCommentFloor,pageStart,pageEnd);
    }
}

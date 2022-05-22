package com.leon.service.impl;

import com.leon.mapper.CommentMapper;
import com.leon.pojo.Comment;
import com.leon.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;


    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }
    @Override
    public List<Comment> selectCommentsBySpaceId(int commentSpaceId, int pageStart, int pageEnd) {
        return commentMapper.selectCommentsBySpaceId(commentSpaceId,pageStart,pageEnd);
    }
}

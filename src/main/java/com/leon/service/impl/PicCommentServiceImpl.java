package com.leon.service.impl;

import com.leon.mapper.CommentMapper;
import com.leon.mapper.PicCommentMapper;
import com.leon.pojo.PicComment;
import com.leon.service.PicCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PicCommentServiceImpl implements PicCommentService {

    @Autowired
    PicCommentMapper picCommentMapper;

    @Override
    public int insertPicComment(PicComment picComment) {
        return picCommentMapper.insertPicComment(picComment);
    }

    @Override
    public List<PicComment> selectPicCommentByPicId(int picCommentPicId) {
        return picCommentMapper.selectPicCommentByPicId(picCommentPicId);
    }

    @Override
    public List<PicComment> returnAllPicComment() {
        return picCommentMapper.returnAllPicComment();
    }
}

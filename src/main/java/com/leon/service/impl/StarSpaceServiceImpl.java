package com.leon.service.impl;

import com.leon.mapper.StarSpaceMapper;
import com.leon.pojo.StarSpace;
import com.leon.service.StarSpaceService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarSpaceServiceImpl implements StarSpaceService {
    @Autowired
    StarSpaceMapper starSpaceMapper;

//    发表一条动态
    @Override
    public int addOneSpace(StarSpace starSpace) {
        return starSpaceMapper.addOneSpace(starSpace);
    }
//    更新一条动态
    @Override
    public int updateSpace(StarSpace starSpace) {
        return starSpaceMapper.updateSpace(starSpace);
    }
//    罗列一堆动态--根据发表者
    @Override
    public List<StarSpace> selectByPublisher(String publishQQ,int pageStart,int pageEnd) {
        return starSpaceMapper.selectByPublisher(publishQQ,pageStart,pageEnd);
    }

    @Override
    public List<StarSpace> selectByPublishId(int publishId, int pageStart, int pageEnd) {
        return starSpaceMapper.selectByPublishId(publishId,pageStart,pageEnd);
    }
}

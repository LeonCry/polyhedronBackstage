package com.leon.service.impl;

import com.leon.mapper.SpaceWithMapper;
import com.leon.pojo.SpaceWith;
import com.leon.pojo.StarSpace;
import com.leon.service.SpaceWithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceWithServiceImpl implements SpaceWithService {
    
    @Autowired
    SpaceWithMapper spaceWithMapper;
    @Override
    public int insertSpaceWith(SpaceWith spaceWith) {
        return spaceWithMapper.insertSpaceWith(spaceWith);
    }

    @Override
    public int updateSpaceWith(SpaceWith spaceWith) {
        return spaceWithMapper.updateSpaceWith(spaceWith);
    }

    @Override
    public List<StarSpace> selectSpaceWithByUserQQ(String userQQ) {
        return spaceWithMapper.selectSpaceWithByUserQQ(userQQ);
    }

    @Override
    public List<StarSpace> returnAllSpaceWith() {
        return spaceWithMapper.returnAllSpaceWith();
    }
}

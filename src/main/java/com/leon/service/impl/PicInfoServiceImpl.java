package com.leon.service.impl;

import com.leon.mapper.PicInfoMapper;
import com.leon.pojo.PicInfo;
import com.leon.service.PicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicInfoServiceImpl implements PicInfoService {

    @Autowired
    PicInfoMapper picInfoMapper;


    @Override
    public List<PicInfo> returnPics(int picId, int pageStart, int pageEnd) {
        return picInfoMapper.returnPics(picId,pageStart,pageEnd);
    }

    @Override
    public int InsertPic(PicInfo picInfo) {
        return picInfoMapper.InsertPic(picInfo);
    }

    @Override
    public int delPic(int picId) {
        return picInfoMapper.delPic(picId);
    }

    @Override
    public int updatePic(PicInfo picInfo) {
        return picInfoMapper.updatePic(picInfo);
    }
}

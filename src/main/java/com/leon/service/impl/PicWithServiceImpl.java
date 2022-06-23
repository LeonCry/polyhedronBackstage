package com.leon.service.impl;

import com.leon.mapper.PicWithMapper;
import com.leon.pojo.PicWith;
import com.leon.service.PicWithService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicWithServiceImpl implements PicWithService {

    @Autowired
    PicWithMapper picWithMapper;

    @Override
    public int insertPicWith(PicWith picWith) {
        return picWithMapper.insertPicWith(picWith);
    }

    @Override
    public int updatePicWith(PicWith picWith) {
        return picWithMapper.updatePicWith(picWith);
    }

    @Override
    public List<PicWith> selectPicWithByUserQQ(String picWithQQ) {
        return picWithMapper.selectPicWithByUserQQ(picWithQQ);
    }

    @Override
    public List<PicWith> returnAllPicWith() {
        return picWithMapper.returnAllPicWith();
    }
}

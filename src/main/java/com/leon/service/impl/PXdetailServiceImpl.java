package com.leon.service.impl;

import com.leon.mapper.PXdetailMapper;
import com.leon.pojo.PXdetails;
import com.leon.service.PXdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PXdetailServiceImpl implements PXdetailService {

    @Autowired
    PXdetailMapper pXdetailMapper;

    @Override
    public List<PXdetails> returnAllDetails() {
        return pXdetailMapper.returnAllDetails();
    }

    @Override
    public List<PXdetails> returnDetailsByNameAndType(String pxUser,String pxType) {
        return pXdetailMapper.returnDetailsByNameAndType(pxUser,pxType);
    }

    @Override
    public List<PXdetails> returnDetailsByName(String pxUser) {
        return pXdetailMapper.returnDetailsByName(pxUser);
    }

    @Override
    public int addADetails(PXdetails pXdetails) {
        return pXdetailMapper.addADetails(pXdetails);
    }

    @Override
    public int updateADetails(PXdetails pXdetails) {
        return pXdetailMapper.updateADetails(pXdetails);
    }

    @Override
    public int delADetails(int pxId) {
        return pXdetailMapper.delADetails(pxId);
    }
}

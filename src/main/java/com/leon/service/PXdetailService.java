package com.leon.service;

import com.leon.pojo.PXdetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PXdetailService {
    //    查询所有收支明细
    List<PXdetails> returnAllDetails();
    //    根据ID查收支明细
    List<PXdetails> returnDetailsByNameAndType(String pxUser,String pxType);
    //    根据名字查收支明细
    List<PXdetails> returnDetailsByName(String pxUser);
    //    插入一条商品收支明细
    int addADetails(PXdetails pXdetails);
    //    修改一条商品收支明细
    int updateADetails(PXdetails pXdetails);
    //    删除一条收支明细根据ID
    int delADetails(int pxId);
}

package com.leon.service;

import com.leon.pojo.PicInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PicInfoService {

    //    返回所有图片信息 但是有page限制
    List<PicInfo> returnPics(int picId, int pageStart,int pageEnd);
    //添加一个图片信息
    int InsertPic(PicInfo picInfo);
    //删除一个图片
    int delPic(int picId);
    //更新一个图片的信息
    int updatePic(PicInfo picInfo);


}

package com.leon.service;

import com.leon.pojo.StarSpace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StarSpaceService {

    //    发表一条动态--插入一条数据
    int addOneSpace(StarSpace starSpace);

    //    更新一条动态
    int updateSpace(StarSpace starSpace);

    //    罗列一堆动态--根据发表者
    List<StarSpace> selectByPublisher(String publishQQ,int pageStart,int pageEnd);

    //    罗列一堆动态--根据ID
    List<StarSpace> selectByPublishId(int publishId,int pageStart,int pageEnd);

    List<StarSpace> returnAllSpace();
}

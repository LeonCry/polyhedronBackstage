package com.leon.mapper;

import com.leon.pojo.StarSpace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StarSpaceMapper {

//    发表一条动态--插入一条数据
    int addOneSpace(StarSpace starSpace);

//    更新一条动态
    int updateSpace(StarSpace starSpace);

//    罗列一堆动态--根据发表者
    List<StarSpace> selectByPublisher(@Param("publishQQ") String publishQQ,@Param("pageStart")int pageStart,@Param("pageEnd")int pageEnd);

}

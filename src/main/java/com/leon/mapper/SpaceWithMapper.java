package com.leon.mapper;

import com.leon.pojo.SpaceWith;
import com.leon.pojo.StarSpace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SpaceWithMapper {

    //    插入一条数据--用户初次注册就应该存在了
    int insertSpaceWith(SpaceWith spaceWith);

    //    更新一条数据
    int updateSpaceWith(SpaceWith spaceWith);

    //    select一堆数据ByUserQQ
    List<StarSpace> selectSpaceWithByUserQQ(@Param("userQQ") String userQQ);
}

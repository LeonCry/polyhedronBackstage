package com.leon.mapper;


import com.leon.pojo.PicWith;
import com.leon.pojo.SpaceWith;
import com.leon.pojo.StarSpace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PicWithMapper {

    //    插入一条数据--用户初次注册就应该存在了
    int insertPicWith(PicWith picWith);

    //    更新一条数据
    int updatePicWith(PicWith picWith);

    //    select一堆数据ByUserQQ
    List<PicWith> selectPicWithByUserQQ(@Param("picWithQQ") String picWithQQ);


    List<PicWith> returnAllPicWith();

}

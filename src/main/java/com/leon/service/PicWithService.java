package com.leon.service;

import com.leon.pojo.PicWith;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PicWithService {


    //    插入一条数据--用户初次注册就应该存在了
    int insertPicWith(PicWith picWith);

    //    更新一条数据
    int updatePicWith(PicWith picWith);

    //    select一堆数据ByUserQQ
    List<PicWith> selectPicWithByUserQQ(String picWithQQ);


    List<PicWith> returnAllPicWith();


}

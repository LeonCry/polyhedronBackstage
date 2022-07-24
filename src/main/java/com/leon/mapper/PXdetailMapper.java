package com.leon.mapper;

import com.leon.pojo.PXdetails;
import com.leon.pojo.ShopOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PXdetailMapper {

    //    查询所有收支明细
    List<PXdetails> returnAllDetails();
    //    根据用户和类型
    List<PXdetails> returnDetailsByNameAndType(@Param("pxUser") String pxUser,@Param("pxType") String pxType);
    //    根据用户和类型和项目
    List<PXdetails> returnDetailsByNameAndTypeAndItem(@Param("pxUser") String pxUser,@Param("pxType") String pxType,@Param("pxItem") String pxItem);
    //    根据名字查收支明细
    List<PXdetails> returnDetailsByName( @Param("pxUser") String pxUser);
    //    插入一条商品收支明细
    int addADetails(PXdetails pXdetails);
    //    修改一条商品收支明细
    int updateADetails(PXdetails pXdetails);
    //    删除一条收支明细根据ID
    int delADetails(@Param("pxId") int pxId);
}

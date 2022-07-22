package com.leon.mapper;

import com.leon.pojo.Shopping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShoppingMapper {

//    查询所有商品
    List<Shopping> returnAllShopping();
//    根据ID查商品
    Shopping returnShoppingById( @Param("shopId") int shopId);
//    根据名字查商品
    List<Shopping> returnShoppingByName( @Param("shopName") String shopName);
//    插入一条商品信息
    int addAShopping(Shopping shopping);
//    修改一条商品信息
    int updateAShopping(Shopping shopping);
//    删除一条商品信息根据ID
    int delAShopping(@Param("shopId") int shopId);


}

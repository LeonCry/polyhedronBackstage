package com.leon.mapper;

import com.leon.pojo.ShopOrder;
import com.leon.pojo.Shopping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopOrderMapper {
    //    查询所有商品订单
    List<ShopOrder> returnAllShopOrder();
    //    根据ID查商品订单
    ShopOrder returnShopOrderById( @Param("orderId") int orderId);
    //    根据名字查商品订单
    List<ShopOrder> returnShopOrderByName(@Param("buyUser") String buyUser);
    //    插入一条商品信息订单
    int addAShopOrder(ShopOrder shopOrder);
    //    修改一条商品信息订单
    int updateAShopOrder(ShopOrder shopOrder);
    //    删除一条商品订单根据ID
    int delAShopOrder(@Param("orderId") int orderId);




}

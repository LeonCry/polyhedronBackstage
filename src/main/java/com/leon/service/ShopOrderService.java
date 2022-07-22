package com.leon.service;

import com.leon.pojo.ShopOrder;

import java.util.List;

public interface ShopOrderService {
    //    查询所有商品订单
    List<ShopOrder> returnAllShopOrder();
    //    根据ID查商品订单
    ShopOrder returnShopOrderById(int orderId);
    //    根据名字查商品订单
    List<ShopOrder> returnShopOrderByName(String buyShopName);
    //    插入一条商品信息订单
    int addAShopOrder(ShopOrder shopOrder);
    //    修改一条商品信息订单
    int updateAShopOrder(ShopOrder shopOrder);
    //    删除一条商品订单根据ID
    int delAShopOrder(int orderId);

}

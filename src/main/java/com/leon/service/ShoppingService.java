package com.leon.service;

import com.leon.pojo.Shopping;

import java.util.List;

public interface ShoppingService {
    //    查询所有商品
    List<Shopping> returnAllShopping();
    //    根据ID查商品
    Shopping returnShoppingById(int shopId);
    //    根据名字查商品
    List<Shopping> returnShoppingByName(String shopName);
    //    插入一条商品信息
    int addAShopping(Shopping shopping);
    //    修改一条商品信息
    int updateAShopping(Shopping shopping);
    //    删除一条商品信息根据ID
    int delAShopping(int shopId);
}

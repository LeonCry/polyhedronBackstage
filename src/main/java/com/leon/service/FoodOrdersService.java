package com.leon.service;

import com.leon.pojo.FoodOrders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodOrdersService {
    //    新增食物订单
    int insertFoodOrders(FoodOrders foodOrders);
    //    修改食物订单
    int updateFoodOrders(FoodOrders foodOrders);
    //    删除食物订单
    int deleteFoodOrders(int orderId);
    //    返回所有食物订单
    List<FoodOrders> selectAllFoodOrders();
    //    返回所有食物订单By name and status
    List<FoodOrders> selectFoodOrdersByNameAndStatus(String orderPerson,String orderStatus);
    //    返回所有食物订单By name
    List<FoodOrders> selectFoodOrdersByName(String orderPerson);
    //    返回所有食物订单By ID
    List<FoodOrders> selectFoodOrdersById(int orderId);
}

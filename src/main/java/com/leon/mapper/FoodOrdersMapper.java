package com.leon.mapper;

import com.leon.pojo.FoodOrders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FoodOrdersMapper {
    //    新增食物订单
    int insertFoodOrders(FoodOrders foodOrders);
    //    修改食物订单
    int updateFoodOrders(FoodOrders foodOrders);
    //    删除食物订单
    int deleteFoodOrders(@Param("orderId") int orderId);
    //    返回所有食物订单
    List<FoodOrders> selectAllFoodOrders();
    //    返回所有食物订单By name and status
    List<FoodOrders> selectFoodOrdersByNameAndStatus(@Param("orderPerson") String orderPerson,@Param("orderStatus") String orderStatus);
    //    返回所有食物订单By name
    List<FoodOrders> selectFoodOrdersByName(@Param("orderPerson") String orderPerson);
    //    返回所有食物订单By ID
    List<FoodOrders> selectFoodOrdersById(@Param("orderId") int orderId);
}

package com.leon.service.impl;

import com.leon.mapper.FoodOrdersMapper;
import com.leon.mapper.FoodsMapper;
import com.leon.pojo.FoodOrders;
import com.leon.service.FoodOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodOrdersServiceImpl implements FoodOrdersService {

    @Autowired
    FoodOrdersMapper foodOrdersMapper;

    @Override
    public int insertFoodOrders(FoodOrders foodOrders) {
        return foodOrdersMapper.insertFoodOrders(foodOrders);
    }

    @Override
    public int updateFoodOrders(FoodOrders foodOrders) {
        return foodOrdersMapper.updateFoodOrders(foodOrders);
    }

    @Override
    public int deleteFoodOrders(int orderId) {
        return foodOrdersMapper.deleteFoodOrders(orderId);
    }

    @Override
    public List<FoodOrders> selectAllFoodOrders() {
        return foodOrdersMapper.selectAllFoodOrders();
    }

    @Override
    public List<FoodOrders> selectFoodOrdersByNameAndStatus(String orderPerson, String orderStatus) {
        return foodOrdersMapper.selectFoodOrdersByNameAndStatus(orderPerson,orderStatus);
    }

    @Override
    public List<FoodOrders> selectFoodOrdersByName(String orderPerson) {
        return foodOrdersMapper.selectFoodOrdersByName(orderPerson);
    }

    @Override
    public List<FoodOrders> selectFoodOrdersById(int orderId) {
        return foodOrdersMapper.selectFoodOrdersById(orderId);
    }
}

package com.leon.controller;


import com.alibaba.fastjson.JSON;
import com.leon.pojo.FoodOrders;
import com.leon.service.impl.FoodOrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FoodOrdersController {
    @Autowired
    FoodOrdersServiceImpl foodOrdersService;

    @RequestMapping("insertFoodOrders")
    @ResponseBody
    public String insertFoodOrders(@RequestBody FoodOrders foodOrders){
        foodOrdersService.insertFoodOrders(foodOrders);
        return JSON.toJSONString(foodOrdersService.selectFoodOrdersByNameAndStatus(foodOrders.getOrderPerson(),foodOrders.getOrderStatus()));

    }
    @RequestMapping("updateFoodOrders")
    @ResponseBody
    public String updateFoodOrders(@RequestBody FoodOrders foodOrders){
        foodOrdersService.updateFoodOrders(foodOrders);
        return JSON.toJSONString(foodOrdersService.selectFoodOrdersById(foodOrders.getOrderId()));
    }
    @RequestMapping("deleteFoodOrders")
    @ResponseBody
    public int deleteFoodOrders(@RequestBody FoodOrders foodOrders){
        return foodOrdersService.deleteFoodOrders(foodOrders.getOrderId());
    }
    @RequestMapping("selectAllFoodOrders")
    @ResponseBody
    public String selectAllFoodOrders(){
        return JSON.toJSONString(foodOrdersService.selectAllFoodOrders());
    }
    @RequestMapping("selectFoodOrdersByNameAndStatus")
    @ResponseBody
    public String selectFoodOrdersByNameAndStatus(@RequestBody FoodOrders foodOrders){
        return JSON.toJSONString(foodOrdersService.selectFoodOrdersByNameAndStatus(foodOrders.getOrderPerson(),foodOrders.getOrderStatus()));
    }
    @RequestMapping("selectFoodOrdersByName")
    @ResponseBody
    public String selectFoodOrdersByName(@RequestBody FoodOrders foodOrders){
        return JSON.toJSONString(foodOrdersService.selectFoodOrdersByName(foodOrders.getOrderPerson()));
    }
    @RequestMapping("selectFoodOrdersById")
    @ResponseBody
    public String selectFoodOrdersById(@RequestBody FoodOrders foodOrders){
        return JSON.toJSONString(foodOrdersService.selectFoodOrdersById(foodOrders.getOrderId()));
    }
}

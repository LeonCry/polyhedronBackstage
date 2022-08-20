package com.leon.controller;


import com.alibaba.fastjson.JSON;
import com.leon.pojo.Foods;
import com.leon.service.impl.FoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodsController {
    @Autowired
    FoodsServiceImpl foodsService;

    @RequestMapping("insertFoods")
    public int insertFoods(@RequestBody Foods foods){
        return foodsService.insertFoods(foods);
    }
    @RequestMapping("updateFoods")
    public int updateFoods(@RequestBody Foods foods){
        return foodsService.updateFoods(foods);
    }
    @RequestMapping("deleteFoods")
    public int deleteFoods(@RequestBody Foods foods){
        return foodsService.deleteFoods(foods.getFoodId());
    }
    @RequestMapping("selectAllFoods")
    public String selectAllFoods(){
        return JSON.toJSONString(foodsService.selectAllFoods());
    }
    @RequestMapping("selectFoodsByName")
    public String selectFoodsByName(@RequestBody Foods foods){
        return JSON.toJSONString(foodsService.selectFoodsByName(foods.getFoodName()));
    }
}

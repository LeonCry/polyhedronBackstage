package com.leon.service;

import com.leon.pojo.Foods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodsService {
    //    新增食物
    int insertFoods(Foods foods);
    //    修改食物
    int updateFoods(Foods foods);
    //    删除食物
    int deleteFoods(int foodId);
    //    返回所有食物
    List<Foods> selectAllFoods();
    //    返回所有食物byName
    List<Foods> selectFoodsByName(String foodName);
}

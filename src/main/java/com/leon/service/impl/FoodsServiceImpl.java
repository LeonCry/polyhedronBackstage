package com.leon.service.impl;

import com.leon.mapper.CommentMapper;
import com.leon.mapper.FoodsMapper;
import com.leon.pojo.Foods;
import com.leon.service.FoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodsServiceImpl implements FoodsService {

    @Autowired
    FoodsMapper foodsMapper;

    @Override
    public int insertFoods(Foods foods) {
        return foodsMapper.insertFoods(foods);
    }

    @Override
    public int updateFoods(Foods foods) {
        return foodsMapper.updateFoods(foods);
    }

    @Override
    public int deleteFoods(int foodId) {
        return foodsMapper.deleteFoods(foodId);
    }

    @Override
    public List<Foods> selectAllFoods() {
        return foodsMapper.selectAllFoods();
    }

    @Override
    public List<Foods> selectFoodsByName(String foodName) {
        return foodsMapper.selectFoodsByName(foodName);
    }
}

package com.leon.mapper;

import com.leon.pojo.Foods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FoodsMapper {
    //    新增食物
    int insertFoods(Foods foods);
    //    修改食物
    int updateFoods(Foods foods);
    //    删除食物
    int deleteFoods(@Param("foodId") int foodId);
    //    返回所有食物
    List<Foods> selectAllFoods();
    //    返回所有食物byName
    List<Foods> selectFoodsByName(@Param("foodName") String foodName);

}

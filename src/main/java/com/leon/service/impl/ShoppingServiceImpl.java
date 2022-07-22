package com.leon.service.impl;

import com.leon.mapper.ShoppingMapper;
import com.leon.pojo.Shopping;
import com.leon.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    ShoppingMapper shoppingMapper;

    @Override
    public List<Shopping> returnAllShopping() {
        return shoppingMapper.returnAllShopping();
    }

    @Override
    public Shopping returnShoppingById(int shopId) {
        return shoppingMapper.returnShoppingById(shopId);
    }

    @Override
    public List<Shopping> returnShoppingByName(String shopName) {
        return shoppingMapper.returnShoppingByName(shopName);
    }

    @Override
    public int addAShopping(Shopping shopping) {
        return shoppingMapper.addAShopping(shopping);
    }

    @Override
    public int updateAShopping(Shopping shopping) {
        return shoppingMapper.updateAShopping(shopping);
    }

    @Override
    public int delAShopping(int shopId) {
        return shoppingMapper.delAShopping(shopId);
    }
}

package com.leon.service.impl;

import com.leon.mapper.ShopOrderMapper;
import com.leon.pojo.ShopOrder;
import com.leon.service.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    @Autowired
    ShopOrderMapper shopOrderMapper;

    @Override
    public List<ShopOrder> returnAllShopOrder() {
        return shopOrderMapper.returnAllShopOrder();
    }

    @Override
    public ShopOrder returnShopOrderById(int orderId) {
        return shopOrderMapper.returnShopOrderById(orderId);
    }

    @Override
    public List<ShopOrder> returnShopOrderByName(String buyUser) {
        return shopOrderMapper.returnShopOrderByName(buyUser);
    }

    @Override
    public int addAShopOrder(ShopOrder shopOrder) {
        return shopOrderMapper.addAShopOrder(shopOrder);
    }

    @Override
    public int updateAShopOrder(ShopOrder shopOrder) {
        return shopOrderMapper.updateAShopOrder(shopOrder);
    }

    @Override
    public int delAShopOrder(int orderId) {
        return shopOrderMapper.delAShopOrder(orderId);
    }
}

package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.ShopOrder;
import com.leon.pojo.Shopping;
import com.leon.service.impl.ShopOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopOrderController {

    @Autowired
    ShopOrderServiceImpl shopOrderService;

    @RequestMapping("returnAllShopOrder")
    public String returnAllShopOrder(){
        return JSON.toJSONString(shopOrderService.returnAllShopOrder());
    }
    @RequestMapping("returnShopOrderById")
    public String returnShopOrderById(@RequestBody ShopOrder shopOrder){
        return JSON.toJSONString(shopOrderService.returnShopOrderById(shopOrder.getOrderId()));
    }
    @RequestMapping("returnShopOrderByName")
    public String returnShopOrderByName(@RequestBody ShopOrder shopOrder){
        return JSON.toJSONString(shopOrderService.returnShopOrderByName(shopOrder.getBuyShopName()));
    }
    @RequestMapping("addAShopOrder")
    public int addAShopOrder(@RequestBody ShopOrder shopOrder){
        return shopOrderService.addAShopOrder(shopOrder);
    }
    @RequestMapping("updateAShopOrder")
    public int updateAShopOrder(@RequestBody ShopOrder shopOrder){
        return shopOrderService.updateAShopOrder(shopOrder);
    }
    @RequestMapping("delAShopOrder")
    public int delAShopOrder(@RequestBody ShopOrder shopOrder){
        return shopOrderService.delAShopOrder(shopOrder.getOrderId());
    }


}

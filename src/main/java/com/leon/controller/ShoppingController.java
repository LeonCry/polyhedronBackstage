package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.Shopping;
import com.leon.service.impl.ShoppingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

    @Autowired
    ShoppingServiceImpl shoppingService;

    @RequestMapping("returnAllShopping")
    public String returnAllShopping(){
        return JSON.toJSONString(shoppingService.returnAllShopping());
    }
    @RequestMapping("returnShoppingById")
    public String returnShoppingById(@RequestBody Shopping shopping){
        return JSON.toJSONString(shoppingService.returnShoppingById(shopping.getShopId()));
    }
    @RequestMapping("returnShoppingByName")
    public String returnShoppingByName(@RequestBody Shopping shopping){
        return JSON.toJSONString(shoppingService.returnShoppingByName(shopping.getShopName()));
    }
    @RequestMapping("addAShopping")
    public int addAShopping(@RequestBody Shopping shopping){
        return shoppingService.addAShopping(shopping);
    }
    @RequestMapping("updateAShopping")
    public int updateAShopping(@RequestBody Shopping shopping){
        return shoppingService.updateAShopping(shopping);
    }
    @RequestMapping("delAShopping")
    public int delAShopping(@RequestBody Shopping shopping){
        return shoppingService.delAShopping(shopping.getShopId());
    }

}

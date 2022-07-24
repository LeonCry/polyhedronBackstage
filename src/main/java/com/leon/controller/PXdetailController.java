package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.PXdetails;
import com.leon.pojo.ShopOrder;
import com.leon.service.impl.PXdetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PXdetailController {

    @Autowired
    PXdetailServiceImpl pXdetailService;

    @RequestMapping("returnAllDetails")
    public String returnAllDetails(){
        return JSON.toJSONString(pXdetailService.returnAllDetails());
    }
    @RequestMapping("returnDetailsByNameAndType")
    public String returnDetailsByNameAndType(@RequestBody PXdetails pXdetails){
        return JSON.toJSONString(pXdetailService.returnDetailsByNameAndType(pXdetails.getPxUser(),pXdetails.getPxType()));
    }
    @RequestMapping("returnDetailsByNameAndTypeAndItem")
    public String returnDetailsByNameAndTypeAndItem(@RequestBody PXdetails pXdetails){
        return JSON.toJSONString(pXdetailService.returnDetailsByNameAndTypeAndItem(pXdetails.getPxUser(),pXdetails.getPxType(),pXdetails.getPxItem()));
    }


    @RequestMapping("returnDetailsByName")
    public String returnDetailsByName(@RequestBody PXdetails pXdetails){
        return JSON.toJSONString(pXdetailService.returnDetailsByName(pXdetails.getPxUser()));
    }
    @RequestMapping("addADetails")
    public int addADetails(@RequestBody PXdetails pXdetails){
        return pXdetailService.addADetails(pXdetails);
    }
    @RequestMapping("updateADetails")
    public int updateADetails(@RequestBody PXdetails pXdetails){
        return pXdetailService.updateADetails(pXdetails);
    }
    @RequestMapping("delADetails")
    public int delADetails(@RequestBody PXdetails pXdetails){
        return pXdetailService.delADetails(pXdetails.getPxId());
    }



}

package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.PicInfo;
import com.leon.pojo.Reply;
import com.leon.service.impl.PicInfoServiceImpl;
import com.leon.service.impl.ReplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicInfoController {

    @Autowired
    PicInfoServiceImpl picInfoService;

    @RequestMapping("returnPics")
    public String returnPics(@RequestBody PicInfo picInfo){
        return JSON.toJSONString(picInfoService.returnPics(picInfo.getPicId(),picInfo.getPageStart(),picInfo.getPageEnd()));
    }

    @RequestMapping("InsertPic")
    public int InsertPic(@RequestBody PicInfo picInfo){
        return picInfoService.InsertPic(picInfo);
    }
    @RequestMapping("delPic")
    public int delPic(@RequestBody PicInfo picInfo){
        return picInfoService.delPic(picInfo.getPicId());
    }
    @RequestMapping("updatePic")
    public int updatePic(@RequestBody PicInfo picInfo){
        return picInfoService.updatePic(picInfo);
    }




}

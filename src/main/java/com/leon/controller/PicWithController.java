package com.leon.controller;


import com.alibaba.fastjson.JSON;
import com.leon.pojo.PicWith;
import com.leon.pojo.SpaceWith;
import com.leon.service.impl.PicInfoServiceImpl;
import com.leon.service.impl.PicWithServiceImpl;
import com.leon.service.impl.SpaceWithServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PicWithController {

    @Autowired
    PicWithServiceImpl picWithService;


    @RequestMapping("insertPicWith")
    public int insertPicWith(@RequestBody PicWith picWith){
        return picWithService.insertPicWith(picWith);
    }

    @RequestMapping("updatePicWith")
    public int updatePicWith(@RequestBody PicWith picWith){
        return picWithService.updatePicWith(picWith);
    }
    @RequestMapping("selectPicWithByUserQQ")
    public String selectPicWithByUserQQ(@RequestBody PicWith picWith){
        return JSON.toJSONString(picWithService.selectPicWithByUserQQ(picWith.getPicWithQQ()));
    }
    @RequestMapping("returnAllPicWith")
    public String returnAllPicWith(){
        return JSON.toJSONString(picWithService.returnAllPicWith());
    }


}

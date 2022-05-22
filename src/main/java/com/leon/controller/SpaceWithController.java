package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.SpaceWith;
import com.leon.service.SpaceWithService;
import com.leon.service.impl.SpaceWithServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpaceWithController {

    @Autowired
    SpaceWithServiceImpl spaceWithService;

    @RequestMapping("insertSpaceWith")
    public int insertSpaceWith(@RequestBody SpaceWith spaceWith){
        return spaceWithService.insertSpaceWith(spaceWith);
    }

    @RequestMapping("updateSpaceWith")
    public int updateSpaceWith(@RequestBody SpaceWith spaceWith){
        return spaceWithService.updateSpaceWith(spaceWith);
    }
    @RequestMapping("selectSpaceWithByUserQQ")
    public String selectSpaceWithByUserQQ(@RequestBody SpaceWith spaceWith){
        return JSON.toJSONString(spaceWithService.selectSpaceWithByUserQQ(spaceWith.getUserQQ()));
    }


}

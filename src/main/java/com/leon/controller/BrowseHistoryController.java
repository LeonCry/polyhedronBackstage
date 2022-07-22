package com.leon.controller;

import com.alibaba.fastjson.JSON;
import com.leon.pojo.BrowseHistory;
import com.leon.service.impl.BrowseHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseHistoryController {

    @Autowired
    BrowseHistoryServiceImpl browseHistoryService;

    @RequestMapping("returnAllBrowseHistory")
    public String returnAllBrowseHistory(){
        return JSON.toJSONString(browseHistoryService.returnAllBrowseHistory());
    }
    @RequestMapping("returnBrowseHistoryById")
    public String returnBrowseHistoryById(@RequestBody BrowseHistory browseHistory){
        return JSON.toJSONString(browseHistoryService.returnBrowseHistoryById(browseHistory.getBrowseId()));
    }
    @RequestMapping("returnBrowseHistoryByName")
    public String returnBrowseHistoryByName(@RequestBody BrowseHistory browseHistory){
        return JSON.toJSONString(browseHistoryService.returnBrowseHistoryByName(browseHistory.getBrowseUser()));
    }
    @RequestMapping("addABrowseHistory")
    public int addABrowseHistory(@RequestBody BrowseHistory browseHistory){
        return browseHistoryService.addABrowseHistory(browseHistory);
    }
    @RequestMapping("updateABrowseHistory")
    public int updateABrowseHistory(@RequestBody BrowseHistory browseHistory){
        return browseHistoryService.updateABrowseHistory(browseHistory);
    }
    @RequestMapping("delABrowseHistory")
    public int delABrowseHistory(@RequestBody BrowseHistory browseHistory){
        return browseHistoryService.delABrowseHistory(browseHistory.getBrowseUser());
    }


}

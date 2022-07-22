package com.leon.service;

import com.leon.pojo.BrowseHistory;

import java.util.List;

public interface BrowseHistoryService {

    //    查询所有浏览历史
    List<BrowseHistory> returnAllBrowseHistory();
    //    根据ID查浏览历史
    BrowseHistory returnBrowseHistoryById(int browseId);
    //    根据名字查浏览历史
    List<BrowseHistory> returnBrowseHistoryByName(String browseUser);
    //    插入一条商品浏览历史
    int addABrowseHistory(BrowseHistory browseHistory);
    //    修改一条商品浏览历史
    int updateABrowseHistory(BrowseHistory browseHistory);
    //    删除所有浏览历史根据用户名
    int delABrowseHistory(String browseUser);



}

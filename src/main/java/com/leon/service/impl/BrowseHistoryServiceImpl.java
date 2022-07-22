package com.leon.service.impl;

import com.leon.mapper.BrowseHistoryMapper;
import com.leon.pojo.BrowseHistory;
import com.leon.service.BrowseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrowseHistoryServiceImpl implements BrowseHistoryService {

    @Autowired
    BrowseHistoryMapper browseHistoryMapper;

    @Override
    public List<BrowseHistory> returnAllBrowseHistory() {
        return browseHistoryMapper.returnAllBrowseHistory();
    }

    @Override
    public BrowseHistory returnBrowseHistoryById(int browseId) {
        return browseHistoryMapper.returnBrowseHistoryById(browseId);
    }

    @Override
    public List<BrowseHistory> returnBrowseHistoryByName(String browseUser) {
        return browseHistoryMapper.returnBrowseHistoryByName(browseUser);
    }

    @Override
    public int addABrowseHistory(BrowseHistory browseHistory) {
        return browseHistoryMapper.addABrowseHistory(browseHistory);
    }

    @Override
    public int updateABrowseHistory(BrowseHistory browseHistory) {
        return browseHistoryMapper.updateABrowseHistory(browseHistory);
    }

    @Override
    public int delABrowseHistory(String browseUser) {
        return browseHistoryMapper.delABrowseHistory(browseUser);
    }
}

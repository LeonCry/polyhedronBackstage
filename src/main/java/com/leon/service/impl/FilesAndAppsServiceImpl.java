package com.leon.service.impl;

import com.leon.mapper.FilesAndAppsMapper;
import com.leon.pojo.FilesAndApps;
import com.leon.service.FilesAndAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilesAndAppsServiceImpl implements FilesAndAppsService {

    @Autowired
    FilesAndAppsMapper filesAndAppsMapper;

    @Override
    public int insertFile(FilesAndApps files) {
        return filesAndAppsMapper.insertFile(files);
    }

    @Override
    public int updateFile(FilesAndApps files) {
        return filesAndAppsMapper.updateFile(files);
    }

    @Override
    public int deleteFile(int fileId) {
        return filesAndAppsMapper.deleteFile(fileId);
    }

    @Override
    public List<FilesAndApps> selectAllFiles() {
        return filesAndAppsMapper.selectAllFiles();
    }
}

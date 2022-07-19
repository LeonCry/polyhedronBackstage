package com.leon.service;

import com.leon.pojo.FilesAndApps;

import java.util.List;

public interface FilesAndAppsService {

    //    新添加一份文件
    int insertFile(FilesAndApps files);
    //    修改一一份文件
    int updateFile(FilesAndApps files);
    //    删除一一份文件
    int deleteFile(int fileId);
    //返回所有文件信息
    List<FilesAndApps> selectAllFiles();

}

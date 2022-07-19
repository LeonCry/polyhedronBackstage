package com.leon.mapper;

import com.leon.pojo.FilesAndApps;
import com.leon.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FilesAndAppsMapper {

    //    新添加一份文件
    int insertFile(FilesAndApps files);
    //    修改一一份文件
    int updateFile(FilesAndApps files);
    //    删除一一份文件
    int deleteFile(@Param("fileId") int fileId);
    //返回所有文件信息
    List<FilesAndApps> selectAllFiles();
}

package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilesAndApps {

    private int fileId;
    private String fileName;
    private String fileType;
    private String fileIntro;
    private Long uploadTime;
    private int downloadNums;
    private String filePath;
    private String fileShow;
    private String downLoadP;


}

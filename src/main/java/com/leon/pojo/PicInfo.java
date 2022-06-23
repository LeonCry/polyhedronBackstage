package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PicInfo {
    private int picId;
    private String picScr;
    private String picName;
    private String cameraName;
    private String cameraInfo;
    private String location;
    private Long picTime;
    private String weather;
    private int goodNumbers;
    private int collectionNumbers;
    private int pageStart;
    private int pageEnd;

}

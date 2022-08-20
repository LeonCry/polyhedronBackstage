package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foods {
    private int foodId;
    private String foodName;
    private String foodPic;
    private String foodType;
    private int foodCopy;
    private String foodMaterial;
    private int foodMadeTimes;
    private int foodMadeNums;
    private int foodPrice;
    private String foodDetails;
    private String foodDoingWay;
}

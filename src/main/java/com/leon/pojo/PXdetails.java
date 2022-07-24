package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PXdetails {
    private int pxId;
    private String pxUser;
    private int pxOr;
    private String pxType;
    private double pxPrice;
    private String pxItem;
    private String pxInfo;
    private Long pxTime;

}

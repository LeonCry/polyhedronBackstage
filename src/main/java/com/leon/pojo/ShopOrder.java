package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopOrder {
    private int orderId;
    private String buyShopName;
    private int buyShopId;
    private String buyUser;
    private int buyNum;
    private double buyPrice;
    private String receiveName;
    private String receivePhone;
    private String receiveAddress;
    private String receiveRemarks;
    private Long buyTime;
    private String buyParamName1;
    private String buyParamValue1;
    private String buyParamName2;
    private String buyParamValue2;
    private String buyParamName3;
    private String buyParamValue3;
    private String buyParamName4;
    private String buyParamValue4;
    private String orderTrain;
    private String trainNumber;
    private String orderStatus;
}

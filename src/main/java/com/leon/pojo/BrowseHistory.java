package com.leon.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrowseHistory {
    private int browseId;
    private String browseUser;
    private String browseShop;
    private int browseShopId;
    private int browseNums;
    private Long browseTimes;

}

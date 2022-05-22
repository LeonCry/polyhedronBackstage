package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceWith {
    private int spaceWithId;
    private String userQQ;
    private String collections;
    private String goods;
    private String noGoods;
    private String shares;
}

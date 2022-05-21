package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StarSpace {
    private int publishId;
    private String publishQQ;
    private String spaceContent;
    private String publishTime;
    private String collector;
    private String gooder;
    private String noGooder;
    private String sharer;
    private int pageStart;
    private int pageEnd;
    private User user;
}

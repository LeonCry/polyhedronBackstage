package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentId;
    private int commentSpaceId;
    private String commentQQ;
    private String commentContent;
    private long commentTime;
    private int commentFloor;
    private User user;
    private int pageStart;
    private int pageEnd;
}

package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
    private int replyId;
    private int replySpaceId;
    private String replyQQ;
    private String replyContent;
    private String replyTargetQQ;
    private int isReplyComment;
    private int myFloor;
    private int replyTargetFloor;
    private long replyTime;
    private User user;
    private User targetUser;
    private int pageStart;
    private int pageEnd;
}

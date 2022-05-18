package com.leon.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendList {
    private int friendId;
    private String userQQ;
    private String friendQQ;
    private String friendRemarkName;
    private int isShowRecent;
    private long beFriendTime;
    private User user;
}

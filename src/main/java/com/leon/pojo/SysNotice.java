package com.leon.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//noticeType包括：0：空间动态消息；1：添加好友消息；2：删除好友消息；
//isAccept包括：0：未选择；1：接受添加为好友；2拒绝接受好友----仅针对添加好友信息
//isDelete:  0：用户未删除该条消息； 1：用户已删除该条消息
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysNotice {
    private int sysNoticeId;
    private String sendUserQQ;
    private String receiveUserQQ;
    private int noticeType;
    private String remarks;
    private int isAccept;
    private int isDelete;
    private long noticeTime;
}

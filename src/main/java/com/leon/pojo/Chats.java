package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chats {
    private int chatId;
    private String sendUserQQ;
    private String receiveUserQQ;
    private String chatContent;
    private long chatTime;
    private int pageStart;
    private int pageEnd;
}

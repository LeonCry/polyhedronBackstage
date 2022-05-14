package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSetting {
    private int settingId;
    private String userQQ;
    private int voiceNotice;
    private int messageNotice;
    private int spaceNotice;
    private int loginNotice;


}

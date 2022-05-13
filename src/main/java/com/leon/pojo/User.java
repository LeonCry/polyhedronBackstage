//用户的个人信息pojo
package com.leon.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userQQ;
    private String userPassword;
    private String userEmail;
    private String userName;
    private String userSign;
    private String userHead;
    private String userBack;
    private int userMoney;
    private int isOnline;
}

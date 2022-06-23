package com.leon.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PicComment {
    private int picCommentId;
    private int picCommentPicId;
    private String picCommentQQ;
    private String picCommentContent;
    private Long picCommentTime;
}

package com.example.community.dto;

import com.example.community.model.User;
import lombok.Data;

@Data
public class QuestionDto {
    private  Integer id;
    private String title;
    private String description;
    private String  tag;
    private Long gmtCreate;
    private Long gmtModified;
    private  Integer creator;
    private   Integer viewCount;
    private  Integer commentCount;
    private  Integer likeCount;
    private User user;
}

package com.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDto {
    private long id;

    private long userId;

    private long articleId;

    private String str;

    private Date postedDate;

    private UserDto user;
}

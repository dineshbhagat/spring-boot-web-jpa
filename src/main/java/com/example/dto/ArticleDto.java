package com.example.dto;

import com.example.entity.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleDto {
    private long id;
    private String articleText;
    private List<CommentDto> comments;
}

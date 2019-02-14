package com.example.converter;

import com.example.dto.CommentDto;
import com.example.entity.Comment;

public class CommentConverter {
    public static CommentDto getDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setStr(comment.getStr());
        commentDto.setPostedDate(comment.getPostedDate());
        commentDto.setUserId(comment.getUser().getId());
        commentDto.setArticleId(comment.getArticleTable().getId());
        commentDto.setUser(UserConverter.getDto(comment.getUser()));
        commentDto.setId(comment.getId());
        return commentDto;
    }
}


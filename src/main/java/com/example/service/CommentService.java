package com.example.service;

import com.example.dto.CommentDto;
import com.example.entity.Comment;

public interface CommentService {
    Comment addComment(CommentDto commentDto);

    Comment getComment(Long commentId) throws Exception;
}

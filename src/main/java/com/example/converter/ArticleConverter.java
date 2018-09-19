package com.example.converter;

import com.example.dto.ArticleDto;
import com.example.dto.CommentDto;
import com.example.entity.Article;
import com.example.entity.Comment;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ArticleConverter {
    public static ArticleDto getDto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArticleText(article.getArticleText());
        articleDto.setId(article.getId());
        articleDto.setComments(article.getComments().parallelStream().map(CommentConverter::getDto).collect(Collectors.toList()));
        return articleDto;
    }
}

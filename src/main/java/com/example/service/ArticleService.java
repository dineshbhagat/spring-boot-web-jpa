package com.example.service;

import com.example.dto.ArticleDto;
import com.example.entity.Article;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ArticleService {
    Article addArticle(ArticleDto articleDto);

    ArticleDto getArticle(String articleId) throws Exception;
    
    CompletableFuture<List<Article>> getAnswerForSO();
}

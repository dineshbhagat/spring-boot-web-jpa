package com.example.service.impl;

import com.example.converter.ArticleConverter;
import com.example.dao.ArticleDao;
import com.example.dto.ArticleDto;
import com.example.entity.Article;
import com.example.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("ArticleService")
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    /// No need for autowire if you are adding as constructor dependency.
    ///
    /// @param articleDao the article data access object
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    @Transactional
    public Article addArticle(ArticleDto articleDto) {
        Article article = new Article();
        article.setArticleText(articleDto.getArticleText());
        articleDao.save(article);
        return article;
    }

    @Override
    public ArticleDto getArticle(String articleId) throws Exception {
        Optional<Article> article = articleDao.findById(Long.parseLong(articleId));
        if (article.isPresent()) {
            return ArticleConverter.getDto(article.get());
        }
        throw new Exception("Article not found!");
    }
    
    @Override
    public CompletableFuture<List<Article>> getAnswerForSO() {

        System.out.println("In DAO");

        CompletableFuture<List<Article>> completableFuture
                = new CompletableFuture<>();
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(2);
        threadPoolExecutor.submit(() -> {
            Thread.sleep(500);
            System.out.println("Before DAO");
            List<Article> article = articleDao.findAll();
            System.out.println("After DAO");
            return completableFuture.complete(article);
        });

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Testing My DB Connection");
            return this.testConnection();
        }, threadPoolExecutor).thenAccept(val -> {
            if(val) {
                System.out.println("My DB Connection Test SUCCESS");
            } else {
                throw new RuntimeException("CONNECTION TO MY DB FAILED");
            }
        }).join();

        return completableFuture;
    }

    private boolean testConnection() {
        return true;
    }
}

package com.example.service.impl;

import com.example.converter.ArticleConverter;
import com.example.dao.ArticleDao;
import com.example.dto.ArticleDto;
import com.example.entity.Article;
import com.example.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    /**
     * No need for autowire if you are adding as constructor dependency
     * @param articleDao
     */
    public ArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
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
        throw new Exception("User not found!");
    }
}

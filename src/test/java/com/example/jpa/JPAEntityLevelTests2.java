package com.example.jpa;

import com.example.dao.ArticleDao;
import com.example.dao.CommentDao;
import com.example.dao.UserDao;
import com.example.entity.Article;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
public class JPAEntityLevelTests2 {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    public void testByArticleId() {
        Optional<Article> articleOptional = articleDao.findById(1L);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            Assertions.assertEquals(1L, article.getId());
        }
    }

}

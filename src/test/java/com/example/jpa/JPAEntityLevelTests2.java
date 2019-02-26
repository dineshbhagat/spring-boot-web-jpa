package com.example.jpa;

import com.example.dao.ArticleDao;
import com.example.dao.CommentDao;
import com.example.dao.UserDao;
import com.example.entity.Article;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

@RunWith(SpringRunner.class)
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
    public void testByTitle() {
        Optional<Article> articleOptional = articleDao.findById(1L);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            Assert.assertEquals(1L, article.getId());
        }
    }

}

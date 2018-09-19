package com.example.service.impl;

import com.example.dao.ArticleDao;
import com.example.dao.CommentDao;
import com.example.dao.UserDao;
import com.example.dto.CommentDto;
import com.example.entity.Article;
import com.example.entity.Comment;
import com.example.entity.User;
import com.example.service.CommentService;
import com.google.common.base.Strings;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;

    private UserDao userDao;

    private ArticleDao articleDao;

    public CommentServiceImpl(CommentDao commentDao, UserDao userDao, ArticleDao articleDao) {
        this.commentDao = commentDao;
        this.articleDao = articleDao;
        this.userDao = userDao;
    }

    @Override
    public Comment addComment(CommentDto commentDto) {
        if (commentDto == null ||
                Strings.isNullOrEmpty(commentDto.getStr())) {
            return null;
        }

        final long articleId = commentDto.getArticleId();
        final long userId = commentDto.getUserId();
        if (articleId <=0 ||
                userId<=0) {
            return null;
        }
        Optional<User> user = userDao.findById(userId);
        Optional<Article> article = articleDao.findById(articleId);

        if (!user.isPresent() || !article.isPresent()) {
            return null;
        }
        Comment comment = new Comment();
        comment.setUser(user.get());
        comment.setPostedDate(new Date());
        comment.setStr(commentDto.getStr());
        Article article1 = article.get();
        article1.getComments().add(comment);
//        comment.setArticle(article1);
        commentDao.save(comment);
        return comment;
    }

    @Override
    public Comment getComment(Long commentId) throws Exception {
        Optional<Comment> commentOpt = commentDao.findById(commentId);
        if (commentOpt.isPresent()) {
            return commentOpt.get();
        }
        throw new Exception("Comment not found!");
    }
}

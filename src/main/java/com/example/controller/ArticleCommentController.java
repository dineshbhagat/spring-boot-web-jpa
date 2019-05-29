package com.example.controller;


import com.example.converter.CommentConverter;
import com.example.dto.ArticleDto;
import com.example.dto.CommentDto;
import com.example.dto.UserDto;
import com.example.entity.Article;
import com.example.entity.Comment;
import com.example.entity.User;
import com.example.service.ArticleService;
import com.example.service.CommentService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ArticleCommentController {

    private UserService userService;

    @Autowired
    private CommentService commentService;

    private ArticleService articleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ArticleCommentController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @RequestMapping(value = "/health_check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getDemo() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "Hello World!");
        return map;
    }

    /**
     * ideally you should not return article's id as response"
     *
     * @param articleDto
     * @return
     */
    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Article addArticle(@RequestBody ArticleDto articleDto) {
        return articleService.addArticle(articleDto);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Comment addComment(@RequestBody CommentDto commentDto) {
        return commentService.addComment(commentDto);
    }

    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommentDto addComment(@PathVariable Long commentId) throws Exception {
        return CommentConverter.getDto(commentService.getComment(commentId));
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable String userId) throws Exception {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto getArticle(@PathVariable String articleId) throws Exception {
        return articleService.getArticle(articleId);
    }

    @RequestMapping(value = "/56347092/2987755", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Article> getAnswer() throws Exception {
        CompletableFuture<List<Article>> completableFuture = articleService.getAnswerForSO();
        System.out.println("At controller");
        List<Article> result = completableFuture.get();
        return result;
    }

}


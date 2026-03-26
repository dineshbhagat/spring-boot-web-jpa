package com.example;

import com.example.dto.ArticleDto;
import com.example.dto.CommentDto;
import com.example.dto.UserDto;
import com.example.entity.Article;
import com.example.entity.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Full end-to-end integration test that boots the real application on a random
 * port and exercises every CRUD endpoint using an HTTP client — exactly the
 * same flow as manual {@code curl} verification, but fully automated.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationEndToEndIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate rest;

    private String url(String path) {
        return "http://localhost:" + port + path;
    }

    // ───────────────────────── Health / Actuator ─────────────────────────

    @Test
    @Order(1)
    void healthCheckEndpointReturnsHelloWorld() {
        ResponseEntity<Map> response = rest.getForEntity(url("/health_check"), Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).containsEntry("a", "Hello World!");
    }

    @Test
    @Order(2)
    void actuatorHealthEndpointReturnsUp() {
        ResponseEntity<Map> response = rest.getForEntity(url("/actuator/health"), Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).containsEntry("status", "UP");
    }

    // ───────────────────────── User CRUD ─────────────────────────

    @Test
    @Order(10)
    void createUserAndGetUserById() {
        // Create
        UserDto input = new UserDto();
        input.setName("Dinesh");

        ResponseEntity<User> createResp = rest.postForEntity(url("/user"), input, User.class);

        assertThat(createResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        User created = createResp.getBody();
        assertThat(created).isNotNull();
        assertThat(created.getId()).isPositive();
        assertThat(created.getFullName()).isEqualTo("Dinesh");

        // Get
        ResponseEntity<User> getResp = rest.getForEntity(url("/user/" + created.getId()), User.class);

        assertThat(getResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResp.getBody().getFullName()).isEqualTo("Dinesh");
    }

    // ───────────────────────── Article CRUD ─────────────────────────

    @Test
    @Order(20)
    void createArticleAndGetArticleById() {
        // Create
        ArticleDto input = new ArticleDto();
        input.setArticleText("Spring Boot 4 integration test article");

        ResponseEntity<Article> createResp = rest.postForEntity(url("/article"), input, Article.class);

        assertThat(createResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        Article created = createResp.getBody();
        assertThat(created).isNotNull();
        assertThat(created.getId()).isPositive();
        assertThat(created.getArticleText()).isEqualTo("Spring Boot 4 integration test article");

        // Get (via DTO — includes comments list)
        ResponseEntity<ArticleDto> getResp = rest.getForEntity(url("/article/" + created.getId()), ArticleDto.class);

        assertThat(getResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        ArticleDto dto = getResp.getBody();
        assertThat(dto.getArticleText()).isEqualTo("Spring Boot 4 integration test article");
        assertThat(dto.getComments()).isEmpty();
    }

    // ───────────────────────── Comment CRUD ─────────────────────────

    @Test
    @Order(30)
    void createCommentAndGetCommentById() {
        // Prereqs — create user + article
        UserDto userInput = new UserDto();
        userInput.setName("TestUser");
        User user = rest.postForObject(url("/user"), userInput, User.class);

        ArticleDto articleInput = new ArticleDto();
        articleInput.setArticleText("Article for commenting");
        Article article = rest.postForObject(url("/article"), articleInput, Article.class);

        // Create comment
        CommentDto commentInput = new CommentDto();
        commentInput.setStr("Great article!");
        commentInput.setUserId(user.getId());
        commentInput.setArticleId(article.getId());

        ResponseEntity<Map> createResp = rest.postForEntity(url("/comment"), commentInput, Map.class);

        assertThat(createResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        Map body = createResp.getBody();
        assertThat(body).containsKey("id");
        assertThat(body.get("str")).isEqualTo("Great article!");

        // Get comment
        Number commentId = (Number) body.get("id");
        ResponseEntity<CommentDto> getResp = rest.getForEntity(url("/comment/" + commentId), CommentDto.class);

        assertThat(getResp.getStatusCode()).isEqualTo(HttpStatus.OK);
        CommentDto dto = getResp.getBody();
        assertThat(dto.getStr()).isEqualTo("Great article!");
        assertThat(dto.getUserId()).isEqualTo(user.getId());
        assertThat(dto.getArticleId()).isEqualTo(article.getId());
        assertThat(dto.getUser()).isNotNull();
        assertThat(dto.getUser().getName()).isEqualTo("TestUser");
    }

    // ───────────────────────── Article ↔ Comment Relationship ─────────────────────────

    @Test
    @Order(40)
    void articleIncludesItsComments() {
        // Create two separate users (comment.user_id has a UNIQUE constraint)
        UserDto userInput1 = new UserDto();
        userInput1.setName("RelationUser1");
        User user1 = rest.postForObject(url("/user"), userInput1, User.class);

        UserDto userInput2 = new UserDto();
        userInput2.setName("RelationUser2");
        User user2 = rest.postForObject(url("/user"), userInput2, User.class);

        ArticleDto articleInput = new ArticleDto();
        articleInput.setArticleText("Article with multiple comments");
        Article article = rest.postForObject(url("/article"), articleInput, Article.class);

        CommentDto c1 = new CommentDto();
        c1.setStr("First comment");
        c1.setUserId(user1.getId());
        c1.setArticleId(article.getId());
        rest.postForObject(url("/comment"), c1, Map.class);

        CommentDto c2 = new CommentDto();
        c2.setStr("Second comment");
        c2.setUserId(user2.getId());
        c2.setArticleId(article.getId());
        rest.postForObject(url("/comment"), c2, Map.class);

        // Fetch article — comments should be included
        ResponseEntity<ArticleDto> resp = rest.getForEntity(url("/article/" + article.getId()), ArticleDto.class);

        assertThat(resp.getStatusCode()).isEqualTo(HttpStatus.OK);
        ArticleDto dto = resp.getBody();
        assertThat(dto.getComments()).hasSize(2);
        assertThat(dto.getComments())
                .extracting(CommentDto::getStr)
                .containsExactlyInAnyOrder("First comment", "Second comment");
    }
}

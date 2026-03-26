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
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/// Full end-to-end integration test that boots the real application on a random
/// port and exercises every CRUD endpoint using [RestTestClient] — the
/// recommended Spring Boot 4.x replacement for the deprecated TestRestTemplate.
///
/// `@AutoConfigureRestTestClient` auto-configures a [RestTestClient]
/// bound to the running server (RANDOM_PORT), so no manual URL building is needed.
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationEndToEndIT {

    @Autowired
    private RestTestClient rest;

    private static final ParameterizedTypeReference<Map<String, Object>> MAP_TYPE =
            new ParameterizedTypeReference<>() {};

    // ───────────────────────── Health / Actuator ─────────────────────────

    @Test
    @Order(1)
    void healthCheckEndpointReturnsHelloWorld() {
        rest.get().uri("/health_check")
                .exchange()
                .expectStatus().isOk()
                .expectBody(MAP_TYPE)
                .value(body -> assertThat(body).containsEntry("a", "Hello World!"));
    }

    @Test
    @Order(2)
    void actuatorHealthEndpointReturnsUp() {
        rest.get().uri("/actuator/health")
                .exchange()
                .expectStatus().isOk()
                .expectBody(MAP_TYPE)
                .value(body -> assertThat(body).containsEntry("status", "UP"));
    }

    // ───────────────────────── User CRUD ─────────────────────────

    @Test
    @Order(10)
    void createUserAndGetUserById() {
        // Create
        UserDto input = new UserDto();
        input.setName("Dinesh");

        User created = rest.post().uri("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .body(input)
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class)
                .returnResult().getResponseBody();

        assertThat(created).isNotNull();
        assertThat(created.getId()).isPositive();
        assertThat(created.getFullName()).isEqualTo("Dinesh");

        // Get
        rest.get().uri("/user/" + created.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class)
                .value(user -> {
                    assert user != null;
                    assertThat(user.getFullName()).isEqualTo("Dinesh");
                });
    }

    // ───────────────────────── Article CRUD ─────────────────────────

    @Test
    @Order(20)
    void createArticleAndGetArticleById() {
        // Create
        ArticleDto input = new ArticleDto();
        input.setArticleText("Spring Boot 4 integration test article");

        Article created = rest.post().uri("/article")
                .contentType(MediaType.APPLICATION_JSON)
                .body(input)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Article.class)
                .returnResult().getResponseBody();

        assertThat(created).isNotNull();
        assertThat(created.getId()).isPositive();
        assertThat(created.getArticleText()).isEqualTo("Spring Boot 4 integration test article");

        // Get (via DTO — includes comments list)
        rest.get().uri("/article/" + created.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(ArticleDto.class)
                .value(dto -> {
                    assert dto != null;
                    assertThat(dto.getArticleText()).isEqualTo("Spring Boot 4 integration test article");
                    assertThat(dto.getComments()).isEmpty();
                });
    }

    // ───────────────────────── Comment CRUD ─────────────────────────

    @Test
    @Order(30)
    void createCommentAndGetCommentById() {
        // Prereqs — create user + article
        UserDto userInput = new UserDto();
        userInput.setName("TestUser");
        User user = rest.post().uri("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .body(userInput)
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class)
                .returnResult().getResponseBody();

        ArticleDto articleInput = new ArticleDto();
        articleInput.setArticleText("Article for commenting");
        Article article = rest.post().uri("/article")
                .contentType(MediaType.APPLICATION_JSON)
                .body(articleInput)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Article.class)
                .returnResult().getResponseBody();

        // Create comment
        CommentDto commentInput = new CommentDto();
        commentInput.setStr("Great article!");
        assert user != null;
        commentInput.setUserId(user.getId());
        assert article != null;
        commentInput.setArticleId(article.getId());

        Map<String, Object> body = rest.post().uri("/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .body(commentInput)
                .exchange()
                .expectStatus().isOk()
                .expectBody(MAP_TYPE)
                .returnResult().getResponseBody();

        assertThat(body).containsKey("id");
        assertThat(body.get("str")).isEqualTo("Great article!");

        // Get comment
        Number commentId = (Number) body.get("id");
        rest.get().uri("/comment/" + commentId)
                .exchange()
                .expectStatus().isOk()
                .expectBody(CommentDto.class)
                .value(dto -> {
                    assert dto != null;
                    assertThat(dto.getStr()).isEqualTo("Great article!");
                    assertThat(dto.getUserId()).isEqualTo(user.getId());
                    assertThat(dto.getArticleId()).isEqualTo(article.getId());
                    assertThat(dto.getUser()).isNotNull();
                    assertThat(dto.getUser().getName()).isEqualTo("TestUser");
                });
    }

    // ───────────────────────── Article ↔ Comment Relationship ─────────────────────────

    @Test
    @Order(40)
    void articleIncludesItsComments() {
        // Create two separate users (comment.user_id has a UNIQUE constraint)
        UserDto userInput1 = new UserDto();
        userInput1.setName("RelationUser1");
        User user1 = rest.post().uri("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .body(userInput1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class)
                .returnResult().getResponseBody();

        UserDto userInput2 = new UserDto();
        userInput2.setName("RelationUser2");
        User user2 = rest.post().uri("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .body(userInput2)
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class)
                .returnResult().getResponseBody();

        ArticleDto articleInput = new ArticleDto();
        articleInput.setArticleText("Article with multiple comments");
        Article article = rest.post().uri("/article")
                .contentType(MediaType.APPLICATION_JSON)
                .body(articleInput)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Article.class)
                .returnResult().getResponseBody();

        CommentDto c1 = new CommentDto();
        c1.setStr("First comment");
        assert user1 != null;
        c1.setUserId(user1.getId());
        assert article != null;
        c1.setArticleId(article.getId());
        rest.post().uri("/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .body(c1)
                .exchangeSuccessfully();

        CommentDto c2 = new CommentDto();
        c2.setStr("Second comment");
        assert user2 != null;
        c2.setUserId(user2.getId());
        c2.setArticleId(article.getId());
        rest.post().uri("/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .body(c2)
                .exchangeSuccessfully();

        // Fetch article — comments should be included
        rest.get().uri("/article/" + article.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(ArticleDto.class)
                .value(dto -> {
                    assert dto != null;
                    assertThat(dto.getComments()).hasSize(2);
                    assertThat(dto.getComments())
                            .extracting(CommentDto::getStr)
                            .containsExactlyInAnyOrder("First comment", "Second comment");
                });
    }
}

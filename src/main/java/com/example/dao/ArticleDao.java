package com.example.dao;

import com.example.entity.Article;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
Note: If you prefer to be selective about the methods being exposed, copy the methods you want to expose from CrudRepository into your domain repository
Doing so lets you define your own abstractions on top of the provided Spring Data Repositories functionality. 

public interface myRestrictedArticleDao extends JpaRepository<Article, Long> {
   Optional<T> findById(ID id);
}

@Repository
public interface ArticleDao extends myRestrictedArticleDao<Article, Long> {
}

Ref: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#preface
*/
@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {
}

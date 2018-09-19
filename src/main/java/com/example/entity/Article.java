package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "article")
@Data
public class Article implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "this is incremental id of table", nullable = false, unique = true)
    private long id;

    @Column(name = "article_text", columnDefinition = "this is main text of article")
    private String articleText;

    /**
     * One article can have multiple comments, hence oneToMany
     * We can navigate from article to comments
     * mappedBy indicates we can navigate from comment to Article.
     * CascadeType.ALL --> dependent object Comment will be persisted/updated/deleted automatically
     * on subsequent persist/update/delete on Article object.
     * No need to perform operation separately on Comment
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articleTable")
    private List<Comment> comments;
}

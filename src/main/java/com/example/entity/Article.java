package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
     * Ref: https://stackoverflow.com/a/2584591/2987755
     * To Understand one-to-many and bidirectional,
     * 2 paradigm Object oriented (OO) and Relational database
     * In OO the article owns the comments (comments are list in Article object). There can't be comment without an article.
     * So Article seems to be an owner of comments
     * <p>
     * But in SQL world(Relational db) one item will actually contain a pointer to the other. Since there is 1 Article for N comments,
     * each comment contains FK to the article it belongs to.
     * This is the "Connection" and this means that the Comment "owns" (or literally contains) the connection(information).
     * This is exactly opposite to the OO world.
     * <p>
     * <p>
     * Since there is no column to store comments in Article table which will tell that how many comments it has,
     * so we must tell article where it can save comment data (via mappedBy)
     * One article can have multiple comments, hence oneToMany
     * We can navigate from article to comments
     * mappedBy indicates we can navigate from comment to Article.
     * CascadeType.ALL --> dependent object Comment will be persisted/updated/deleted automatically
     * on subsequent persist/update/delete on Article object.
     * No need to perform operation separately on Comment
     *
     * @JsonIgnore is must because: There is cyclic dependency, Article has List<Comment> and Comment has Article ref.
     * Ref: https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
     */
//    @JsonIgnore
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articleTable")
    private List<Comment> comments;
}

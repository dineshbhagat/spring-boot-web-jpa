package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "article")
@Data
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "this is incremental id of table", nullable = false, unique = true)
    private long id;

    @Column(name = "article_text", columnDefinition = "this is main text of article")
    private String articleText;

    /**
     * <url>Ref: https://stackoverflow.com/a/2584591/2987755</url>
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
     * <url>Ref: https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion</url>
     */
    /**
     * We are overriding following methods to avoid recursive call between Article.toString() and Comment.toString(), and equals() and hashcode()
     * Since Article is dependent on List<Comment> and Comment is dependent on Article, so this is recursive-chain call which we have break
     * so we are not using Article's comment variable in equals, hashcode and toString() method
     */
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "articleTable")
    private List<Comment> comments;


    /**
     * <url>Ref: https://www.baeldung.com/hibernate-many-to-many</url>
     * <p>
     * One article can have multiple tags: e.g. java, hibernate, jpa etc.
     * and one tag can be a part of multiple Articles
     * So to map this we need an extra table where we will store the relationship
     * table: article_tag, it has primary key of both article and tag table
     * <p>
     * The @ManyToMany annotation is used in both classes to create the many-to-many relationship between the entities.
     * This association has two sides i.e. the owning side and the inverse side.
     * In our example, the owning side is `Article` so the join table is specified on the owning side
     * by using the @JoinTable annotation in Article class.
     * <p>
     * The @JoinTable is used to define the join/link table.
     * In this case, it is `article_tag`.
     * <p>
     * The @JoinColumn annotation is used to specify the join/linking column with the main table.
     * Here, the join column is article_id and tag_id is the inverse join column since tag is on the inverse side of the relationship.
     * <p>
     * The mappedBy attribute is used in the @ManyToMany annotation to indicate that
     * the Articles collection is mapped by the tags collection of the owner side.
     */
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "article_tag",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags;
}

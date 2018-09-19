package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comment")
@Data
public class Comment implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "this is incremental id of table", nullable = false, unique = true)
    private long id;

    @Column(name = "comment_str", length = 400)
    private String str;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date postedDate;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    /**
     * We do not make it mandatory, comment still exists even if post is not present
     * @JoinColumn says that Comment table will contain a separate column article_id
     * which will eventually act as a foreign key reference to primary key of Article table
     * @ManyToOne says that multiple Comment tuples can refer to same Article Tuples(Multiple Comment can be in same Article)
     * Additionally , with optional=false we make sure that no Comment tuple can exist without a Article tuple.
     */
    @ManyToOne(optional = true)
    @JoinColumn(name = "article_id")
    public Article articleTable;

}

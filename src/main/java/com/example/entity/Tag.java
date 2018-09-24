package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", columnDefinition = "this is incremental id of table", nullable = false, unique = true)
    private long tagId;

    private String name;
    private String description;

    /**
     * One tag can be a part of multiple articles e.g. there can be multiple articles on Java tag
     */
    @ManyToMany(mappedBy = "tags")
    private Set<Article> articles;
}

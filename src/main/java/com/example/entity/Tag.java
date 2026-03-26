package com.example.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id", nullable = false, unique = true)
    private long tagId;

    private String name;
    private String description;

    /// One tag can be a part of multiple articles e.g. there can be multiple articles on Java tag.
    /// Note `Set<Article>` against `List<Article>`.
    @ManyToMany(mappedBy = "tags")
    private Set<Article> articles;
}

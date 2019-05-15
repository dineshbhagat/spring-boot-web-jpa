package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nodes")
public class Nodes { 

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int node_id;
    private String name;
    private Date created_at;

    @ManyToOne
    @JoinColumn(name="type")
    private Nodetypes nodetypes;

    public Nodetypes getNodetypes() {
        return nodetypes;
    }

    public void setNodetypes(Nodetypes nodetypes) {
        this.nodetypes = nodetypes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
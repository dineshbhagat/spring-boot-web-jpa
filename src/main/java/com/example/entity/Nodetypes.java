package com.example.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "node_types")
    public class Nodetypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String label;
    private String name;
    private Boolean is_group;
    private Date created_at;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "nodetypes", cascade = CascadeType.ALL)
    private Set<Nodes> nodes;

    public Set<Nodes> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Nodes> nodes) {
        this.nodes = nodes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_group() {
        return is_group;
    }

    public void setIs_group(Boolean is_group) {
        this.is_group = is_group;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
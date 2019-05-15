package com.example.dao;

import com.example.entity.Nodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodesRepository extends JpaRepository<Nodes, Integer> {
}

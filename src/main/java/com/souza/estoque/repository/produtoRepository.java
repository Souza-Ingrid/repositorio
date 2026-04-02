package com.souza.estoque.repository;

import com.souza.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<Produto, Long> {
}
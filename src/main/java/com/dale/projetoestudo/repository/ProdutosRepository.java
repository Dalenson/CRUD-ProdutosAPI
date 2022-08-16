package com.dale.projetoestudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dale.projetoestudo.model.Produto;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
    
}

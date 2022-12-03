package com.bigstok.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigstok.models.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
    


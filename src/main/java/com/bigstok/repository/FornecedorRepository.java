package com.bigstok.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bigstok.models.Fornecedor;


@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

}

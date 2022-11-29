package com.bigstok.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int qtdProduto;
	private String categoria;
	private String codBarras;
	private String fornecedor;
	private String incluidoPor;
	private String produtoNome;
	private String validade;
	private String unidade;
	private String dataCadastro;
	private String descricao;

}

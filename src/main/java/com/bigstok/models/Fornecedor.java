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
// @AllArgsConstructor
public class Fornecedor {
	


	public Fornecedor(int id, String razaoSocial, String cnpj, String cpf, String endereco, String nomeFantasia,
			String dataCadastro, String telefone1, String telefone2, String observacoes) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.endereco = endereco;
		this.nomeFantasia = nomeFantasia;
		this.dataCadastro = dataCadastro;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.observacoes = observacoes;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String razaoSocial;
	private String cnpj;
	private String cpf;
	private String endereco;
	private String nomeFantasia;
	private String dataCadastro;
	private String telefone1;
	private String telefone2;
	private String observacoes;

}

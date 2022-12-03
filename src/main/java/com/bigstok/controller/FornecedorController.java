package com.bigstok.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bigstok.models.Fornecedor;
import com.bigstok.repository.FornecedorRepository;

@Controller
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	// cadastra fornecedor
	@PostMapping("/cadastraForn")
	public String cadFornecedor(@Valid Fornecedor fornecedor, BindingResult result) {
		fornecedorRepository.save(fornecedor);
		return "redirect:/fornecedores";
	}

	
	// =============================================================================================================//

	// deleta fornecedor
	@GetMapping("delete1/{id}")
	public String delete(@PathVariable(name = "id") int id, Model model) {

		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

		fornecedorRepository.delete(fornecedor);
		return "redirect:/fornecedores";
	}

	// =============================================================================================================//

	// atualiza o fornecedor selecionado na tabela pelo icone editar
	@PostMapping("update1/{id}")
	public String alterarFornecedor(@Valid Fornecedor fornecedor, BindingResult result, @PathVariable int id) {

		if (result.hasErrors()) {
			return "redirect:/CadFornecedores";
		}

		fornecedorRepository.save(fornecedor);
		return "redirect:/fornecedores";
	}

	// =============================================================================================================//

	// coleta item selecionado para ser atualizado
	@GetMapping("form1/{id}")
	public String buscaFornecedorPorId(Model model, @PathVariable(name = "id") int id) {

		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

		model.addAttribute("fornecedor", fornecedor);
		return "AtualizaFornecedor";
	}

	// =============================================================================================================//

	// lista todos os fornecedor na tabela
	@GetMapping("/fornecedores")
	public String mostrarTabelaFornecedores(Model model) {
		List<Fornecedor> fornecedores = fornecedorRepository.findAll();
		model.addAttribute("fornecedores", fornecedores);
		return "CadFornecedores";
	}

	// =============================================================================================================//

	

}

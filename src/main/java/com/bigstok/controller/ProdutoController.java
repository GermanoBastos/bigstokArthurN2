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

import com.bigstok.models.Produto;
import com.bigstok.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	// cadastra produto
	@PostMapping("/cadastraProd")
	public String cadProdutos(@Valid Produto produto, BindingResult result) {
		produtoRepository.save(produto);
		return "redirect:/produtos";
	}

	// =============================================================================================================//

	// deleta produto
	@GetMapping("delete/{id}")
	public String delete(@PathVariable(name = "id") int id, Model model) {

		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

		produtoRepository.delete(produto);
		return "redirect:/produtos";
	}

	// =============================================================================================================//

	// atualiza o produto selecionado na tabela pelo icone editar
	@PostMapping("update/{id}")
	public String alterarProduto(@Valid Produto produto, BindingResult result, @PathVariable int id) {

		if (result.hasErrors()) {
			return "redirect:/CadProdutos";
		}

		produtoRepository.save(produto);
		return "redirect:/produtos";
	}

	// =============================================================================================================//

	// coleta item selecionado para ser atualizado
	@GetMapping("form/{id}")
	public String buscaProdutoPorId(Model model, @PathVariable(name = "id") int id) {

		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

		model.addAttribute("produto", produto);
		return "AtualizaProduto";
	}

	// =============================================================================================================//

	// lista todos os produtos na tabela
	@GetMapping("/produtos")
	public String mostrarTabelaProdutos(Model model) {
		List<Produto> produtos = produtoRepository.findAll();
		model.addAttribute("produtos", produtos);
		return "CadProdutos";
	}

	// =============================================================================================================//

	// rota para exibir pagina de login
	@GetMapping("/")
	public String login() {
		return "index";
	}
	



}

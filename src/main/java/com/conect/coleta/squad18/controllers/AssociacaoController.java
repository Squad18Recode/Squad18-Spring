package com.conect.coleta.squad18.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.conect.coleta.squad18.model.Associacao;
import com.conect.coleta.squad18.services.AssociacaoService;

@Controller
@RequestMapping("/associacoes")
public class AssociacaoController {

	@Autowired
	private AssociacaoService associacaoService;

	@GetMapping
	public String listAssociacao(Model model) {
		List<Associacao> associacao = associacaoService.getAllAssociacoes();
		model.addAttribute("associacao", associacao);
		return "listarAssociacoes";
	}

	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Associacao associacao = new Associacao();
		model.addAttribute("associacao", associacao);
		return "./cadastroAssociacao/associacao.html";
	}

	@PostMapping("/save")
	public String saveAssociacao(@ModelAttribute("associacao") Associacao associacao) {
		associacaoService.saveAssociacao(associacao);
		return "redirect:/associacoes";
	}

	@GetMapping("/editar/{idAssociacao}")
	public String showFormForUpdate(@PathVariable Long idAssociacao, Model model) {
		Associacao associacao = associacaoService.getAssociacaoById(idAssociacao);
		model.addAttribute("associacao", associacao);
		return "./editarAssociacao/editarAssociacao";
	}

	@PostMapping("/editar/{idAssociacao}")
	public String updateAssociacao(@PathVariable Long idAssociacao, @ModelAttribute("associacao") Associacao associacao) {
		associacaoService.updateAssociacao(idAssociacao, associacao);
		return "redirect:/associacoes";
	}

	@GetMapping("/deletar/{idAssociacao}")
	public String deleteAssociacoes(@PathVariable Long idAssociacao) {
		associacaoService.deleteAssociacao(idAssociacao);
		return "redirect:/associacoes";
	}
	
}

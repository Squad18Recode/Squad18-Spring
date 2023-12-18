package com.conect.coleta.squad18.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.conect.coleta.squad18.model.Associacao;
import com.conect.coleta.squad18.model.Catadores;
import com.conect.coleta.squad18.services.AssociacaoService;
import com.conect.coleta.squad18.services.CatadoresService;

@Controller
@RequestMapping("/catadores")
public class CatadoresController {

	@Autowired
	private CatadoresService catadoresService;
	
	@Autowired
	private AssociacaoService associacaoService;
	
	@GetMapping
	public String listarCatadores(Model model) { 
		List<Catadores> catadores = catadoresService.getAllCatadores();
		model.addAttribute("catadores", catadores);
		return "listarCatadores";
	}
	
	@GetMapping("/novo")
	public String showForm(Model model) { 
		Catadores catador = new Catadores();
		List<Associacao> associacao = associacaoService.getAllAssociacoes();
		model.addAttribute("catador", catador);
		model.addAttribute("associacao", associacao);
		return "./cadastroCatadores/user.html";
	}
	
	@PostMapping("/save")
	public String saveCatadores(@ModelAttribute("catador") Catadores catador, @RequestParam Set<Long> associacao) { 
		catador.setAssociacao(associacao.stream()
				.map(associacaoService::getAssociacaoById)
				.collect(Collectors.toSet()));
		catadoresService.saveCatador(catador, associacao);
		return "redirect:/catadores";
	}
	
	@GetMapping("/editar/{idCatador}")
	public String ShowUpdateForm(@PathVariable("idCatador") Long idCatador, Model model) { 
		Catadores catador = catadoresService.getCatadorById(idCatador);
		model.addAttribute("catador", catador);
		model.addAttribute("associacao", associacaoService.getAllAssociacoes());
		return "./editarCatadores/editarCatador";
	}
	
	@PostMapping("/editar/{idCatador}")
	public String updateCatadores(@PathVariable("idCatador") Long idCatador, @ModelAttribute("catador") Catadores catador) { 
		catadoresService.updateCatador(idCatador, catador);
		return "redirect:/catadores";
	}
	
	@GetMapping("/deletar/{idCatador}")
	public String deleteCatadores(@PathVariable Long idCatador) { 
		catadoresService.deleteCatador(idCatador);
		return "redirect:/catadores";
		
	}
}


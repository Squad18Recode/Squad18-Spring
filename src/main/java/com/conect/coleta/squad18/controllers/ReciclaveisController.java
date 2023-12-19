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

import com.conect.coleta.squad18.model.Reciclaveis;
import com.conect.coleta.squad18.services.ReciclaveisService;


@Controller
@RequestMapping("/reciclaveis")
public class ReciclaveisController {
	
	@Autowired
	private ReciclaveisService reciclaveisService;

	@GetMapping
	public String listReciclaveis(Model model) {
		List<Reciclaveis> reciclaveis = reciclaveisService.getAllReciclaveis();
		model.addAttribute("reciclaveis", reciclaveis);
		return "listarReciclaveis";
	}

	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Reciclaveis reciclavel = new Reciclaveis();
		model.addAttribute("reciclavel", reciclavel);
		return "./cadastroReciclaveis/associacao.html";
	}

	@PostMapping("/save")
	public String saveReciclavel(@ModelAttribute("reciclavel") Reciclaveis reciclavel) {
		reciclaveisService.saveReciclavel(reciclavel);
		return "redirect:/reciclaveis";
	}

	@GetMapping("/editar/{idReciclavel}")
	public String showFormForUpdate(@PathVariable Long idReciclavel, Model model) {
		Reciclaveis reciclavel = reciclaveisService.getReciclavelById(idReciclavel);
		model.addAttribute("reciclavel", reciclavel);
		return "./editarReciclaveis/editarReciclaveis";
	}

	@PostMapping("/editar/{idReciclavel}")
	public String updateReciclaveis(@PathVariable Long idReciclavel, @ModelAttribute("reciclavel") Reciclaveis reciclavel) {
		reciclaveisService.updateReciclavel(idReciclavel, reciclavel);
		return "redirect:/reciclaveis";
	}

	@GetMapping("/deletar/{idReciclavel}")
	public String deleteReciclaveis(@PathVariable Long idReciclavel) {
		reciclaveisService.deleteReciclavel(idReciclavel);
		return "redirect:/reciclaveis";
	}
	
}

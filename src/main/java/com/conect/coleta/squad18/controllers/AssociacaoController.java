package com.conect.coleta.squad18.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.conect.coleta.squad18.model.Associacao;
import com.conect.coleta.squad18.services.AssociacaoService;

@Controller
@RequestMapping("/associacoes")
@CrossOrigin(origins = "http://localhost:3000")
public class AssociacaoController {

	@Autowired
	private AssociacaoService associacaoService;

	@GetMapping
	//public String listAssociacao(Model model) {
		//List<Associacao> associacao = associacaoService.getAllAssociacoes();
		//model.addAttribute("associacao", associacao);
		//return "listarAssociacoes";
	//}
	public ResponseEntity<List<Associacao>> listAssociacao() {
        List<Associacao> associacao = associacaoService.getAllAssociacoes();
        return ResponseEntity.ok(associacao);
    }
	//@GetMapping("/novo")
	//public String showFormForAdd(Model model) {
		//Associacao associacao = new Associacao();
		//model.addAttribute("associacao", associacao);
		//return "./cadastroAssociacao/associacao.html";
	//}

	@PostMapping("/save")
	public ResponseEntity<String> saveAssociacao(@RequestBody Associacao associacao) {
        try {
            associacaoService.saveAssociacao(associacao);
            return ResponseEntity.ok("Associação salva com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar a associação");
        }
    }


	
	//public String saveAssociacao(@ModelAttribute("associacao") Associacao associacao) {
		//associacaoService.saveAssociacao(associacao);
		//return "redirect:/associacoes";
	//}

	//@GetMapping("/editar/{idAssociacao}")
	//public String showFormForUpdate(@PathVariable Long idAssociacao, Model model) {
		//Associacao associacao = associacaoService.getAssociacaoById(idAssociacao);
		//model.addAttribute("associacao", associacao);
		//return "./editarAssociacao/editarAssociacao";
	//}
	
	@PutMapping("/editar/{idAssociacao}")
	public ResponseEntity<String> updateAssociacao(@PathVariable Long idAssociacao, @RequestBody Associacao associacao) {
	    associacaoService.updateAssociacao(idAssociacao, associacao);
	    return ResponseEntity.ok("Associação foi editada com sucesso");
	//public String updateAssociacao(@PathVariable Long idAssociacao, @ModelAttribute("associacao") Associacao associacao) {
		//associacaoService.updateAssociacao(idAssociacao, associacao);
		//return "redirect:/associacoes";
	}
	@DeleteMapping("/deletar/{idAssociacao}")
	 public ResponseEntity<String> deleteCatador(@PathVariable Long idAssociacao) { 
		associacaoService.deleteAssociacao(idAssociacao);
		 return ResponseEntity.ok("Associacao excluída  com sucesso");
		    
		   
		}
	 
	//@GetMapping("/deletar/{idAssociacao}")
	//public String deleteAssociacoes(@PathVariable Long idAssociacao) {
		//associacaoService.deleteAssociacao(idAssociacao);
		//return "redirect:/associacoes";
	//}
	
}

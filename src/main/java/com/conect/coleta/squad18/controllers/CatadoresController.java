package com.conect.coleta.squad18.controllers;

import java.util.List;
//import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
import com.conect.coleta.squad18.model.Catadores;
import com.conect.coleta.squad18.services.AssociacaoService;
import com.conect.coleta.squad18.services.CatadoresService;


@Controller
@RequestMapping("/catadores")
@CrossOrigin(origins = "http://localhost:3000")
public class CatadoresController {

	@Autowired
	private CatadoresService catadoresService;
	
	@Autowired
	private AssociacaoService associacaoService;
	
	//@GetMapping
	//public String listarCatadores(Model model) { 
		//List<Catadores> catadores = catadoresService.getAllCatadores();
		//model.addAttribute("catadores", catadores);
		//return "listarCatadores";
	//}
	
	@GetMapping
    public ResponseEntity<List<Catadores>> listarCatadores() {
        List<Catadores> catadores = catadoresService.getAllCatadores();
        return ResponseEntity.ok().body(catadores);
    }
	
	///@GetMapping("/novo")
	//public String showForm(Model model) { 
		//Catadores catador = new Catadores();
		///List<Associacao> associacao = associacaoService.getAllAssociacoes();
		//model.addAttribute("catador", catador);
		//model.addAttribute("associacao", associacao);
		//return "./cadastroCatadores/user.html";
	//}
	
	//@PostMapping("/save")
	//public String saveCatadores(@ModelAttribute("catador") Catadores catador, @RequestParam Set<Long> associacao) { 
		//catador.setAssociacao(associacao.stream()
				//.map(associacaoService::getAssociacaoById)
				//.collect(Collectors.toSet()));
		//catadoresService.saveCatador(catador, associacao);
		//return "redirect:/catadores";
	//}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCatadores(@RequestBody Catadores catador) { 
	    try {
	        Set<Long> associacaoIds = catador.getAssociacao()
	                .stream()
	                .map(Associacao::getIdAssociacao)
	                .collect(Collectors.toSet());

	        catador.setAssociacao(null);
	        catadoresService.saveCatador(catador, associacaoIds);
	        return ResponseEntity.ok("Catador salvo com sucesso");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o catador");
	    }
	}


	
	
	
	//@GetMapping("/editar/{idCatador}")
	//public String ShowUpdateForm(@PathVariable("idCatador") Long idCatador, Model model) { 
		//Catadores catador = catadoresService.getCatadorById(idCatador);
		//model.addAttribute("catador", catador);
		//model.addAttribute("associacao", associacaoService.getAllAssociacoes());
		//return "./editarCatadores/editarCatador";
	//}
	
	
	 @PutMapping("/editar/{idCatador}")
	    public ResponseEntity<String> updateCatadores(@PathVariable("idCatador") Long idCatador, @RequestBody Catadores catador) {
	        try {
	            catadoresService.updateCatador(idCatador, catador);
	            return ResponseEntity.ok("Catador atualizado com sucesso");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o catador");
	        }
	    }
	
	
	//@PostMapping("/editar/{idCatador}")
	//public String updateCatadores(@PathVariable("idCatador") Long idCatador, @ModelAttribute("catador") Catadores catador) { 
		//catadoresService.updateCatador(idCatador, catador);
		//return "redirect:/catadores";
	//}
	 @DeleteMapping("/deletar/{idCatador}")
	 public ResponseEntity<String> deleteCatador(@PathVariable Long idCatador) { 
		 catadoresService.deleteCatador(idCatador);
		 return ResponseEntity.ok("Catador excluído com sucesso");
		    
		   
		}
	 
	 
	//@GetMapping("/deletar/{idCatador}")
	//public String deleteCatadores(@PathVariable Long idCatador) { 
		//catadoresService.deleteCatador(idCatador);
		//return "redirect:/catadores";
		
	//}
	 
	 
}


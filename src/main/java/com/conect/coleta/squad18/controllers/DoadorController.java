package com.conect.coleta.squad18.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.conect.coleta.squad18.model.Doadores;
import com.conect.coleta.squad18.services.DoadoresService;
import com.conect.coleta.squad18.services.ReciclaveisService;
import com.conect.coleta.squad18.model.Reciclaveis;
@Controller
@RequestMapping("/doadores")
@CrossOrigin(origins = "http://localhost:3000")
public class DoadorController {
	@Autowired
	private DoadoresService doadoresService;
	
	@Autowired
	private ReciclaveisService reciclaveisService;
	
	@GetMapping
	public ResponseEntity<List<Doadores>> listarDoadores() {
        List<Doadores> doadores = doadoresService.getAllDoadores();
        return ResponseEntity.ok().body(doadores);
    }
	@PostMapping("/save")
	public ResponseEntity<String> saveDoadores(@RequestBody Doadores doadores) { 
	    try {
	        Set<Long> doadorIds = doadores.getReciclaveis()
	                .stream()
	                .map(Reciclaveis::getIdDoador)
	                .collect(Collectors.toSet());

	        doadores.setReciclaveis(null);
	        doadoresService.saveDoador(doadores, doadorIds);
	        return ResponseEntity.ok("Doador salvo com sucesso");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o doador");
	    }
	}
	
	@PutMapping("/editar/{idDoador}")
    public ResponseEntity<String> updateDoadores(@PathVariable("idDoador") Long idDoador, @RequestBody Doadores doadores) {
        try {
            doadoresService.updateDoador(idDoador, doadores);
            return ResponseEntity.ok("Doador atualizado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o doador");
        }
    }
	
	@DeleteMapping("/deletar/{idDoador}")
	 public ResponseEntity<String> deleteCatador(@PathVariable Long idDoador) { 
		 doadoresService.deleteDoador(idDoador);
		 return ResponseEntity.ok("Catador excluído com sucesso");
		    
		   
		}
	
}

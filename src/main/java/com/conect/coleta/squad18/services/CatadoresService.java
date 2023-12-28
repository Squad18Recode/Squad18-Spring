package com.conect.coleta.squad18.services;

import java.util.List;
import java.util.Set;

import com.conect.coleta.squad18.model.Catadores;

public interface CatadoresService {
	
	List<Catadores> getAllCatadores();

	Catadores getCatadorById(Long idCatador);

	Catadores saveCatador(Catadores catadores, Set<Long> associacaoIds);

	Catadores updateCatador(Long idCatador, Catadores catadorAtualizado);

	void deleteCatador(Long idCatador);

	

	//void saveCatador(Catadores catador);

}

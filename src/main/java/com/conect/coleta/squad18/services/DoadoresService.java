package com.conect.coleta.squad18.services;

import java.util.List;
import java.util.Set;

import com.conect.coleta.squad18.model.Doadores;

public interface DoadoresService {
	
	List<Doadores> getAllDoadores();

	Doadores getDoadorById(Long idDoador);

	Doadores saveDoador(Doadores doadores, Set<Long> reciclavelIds);

	Doadores updateDoador(Long idDoador, Doadores doadorAtualizado);

	void deleteDoador(Long idDoador);
}

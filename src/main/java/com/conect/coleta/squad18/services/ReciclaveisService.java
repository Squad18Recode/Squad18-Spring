package com.conect.coleta.squad18.services;

import java.util.List;

import com.conect.coleta.squad18.model.Reciclaveis;

public interface ReciclaveisService {
	
	List<Reciclaveis> getAllReciclaveis();

	Reciclaveis getReciclavelById(Long idReciclavel);

	Reciclaveis saveReciclavel(Reciclaveis reciclavel);

	Reciclaveis updateReciclavel(Long idReciclavel, Reciclaveis reciclavelAtualizado);

	void deleteReciclavel(Long idReciclavel);
}

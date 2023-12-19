package com.conect.coleta.squad18.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conect.coleta.squad18.model.Reciclaveis;
import com.conect.coleta.squad18.repository.ReciclaveisRepository;
import com.conect.coleta.squad18.services.ReciclaveisService;

@Service
public class ReciclaveisServiceImpl implements ReciclaveisService{

	@Autowired
	private ReciclaveisRepository reciclaveisRepository;

	@Override
	public List<Reciclaveis> getAllReciclaveis() {
		return reciclaveisRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Reciclaveis getReciclavelById(Long idReciclavel) {
		return reciclaveisRepository.findById(idReciclavel).orElse(null);
	}

	@Override
	@Transactional
	public Reciclaveis saveReciclavel(Reciclaveis reciclavel) {
		return reciclaveisRepository.save(reciclavel);
	}
	
	@Override
	public Reciclaveis updateReciclavel(Long idReciclavel, Reciclaveis reciclavelAtualizado) {
		Reciclaveis reciclavelExistente = reciclaveisRepository.findById(idReciclavel).orElse(null);
		if (reciclavelExistente != null) {
			reciclavelExistente.setTipo(reciclavelAtualizado.getTipo());
			reciclavelExistente.setQuantidade(reciclavelAtualizado.getQuantidade());
			return reciclaveisRepository.save(reciclavelExistente);
		} else {
			throw new RuntimeException("Reciclável com o ID:" + idReciclavel + " não encontrado.");
		}
	}

	@Override
	public void deleteReciclavel(Long idReciclavel) {
		reciclaveisRepository.deleteById(idReciclavel);
	}
}

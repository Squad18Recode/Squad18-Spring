package com.conect.coleta.squad18.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conect.coleta.squad18.model.Doadores;
import com.conect.coleta.squad18.model.Reciclaveis;
import com.conect.coleta.squad18.repository.DoadoresRepository;
import com.conect.coleta.squad18.services.DoadoresService;
import com.conect.coleta.squad18.services.ReciclaveisService;

@Service
public class DoadoresServiceImpl implements DoadoresService{
	
	@Autowired
	private DoadoresRepository doadoresRepository;
	
	@Autowired
	private ReciclaveisService ReciclaveisService;

	public List<Doadores> getAllDoadores() {
		return doadoresRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Doadores getDoadorById(Long idDoador) {
		return doadoresRepository.findById(idDoador).orElse(null);
	}

	@Transactional
	public Doadores saveDoador(Doadores doador, Set<Long> reciclavelIds) {
		Set<Reciclaveis> reciclaveis = reciclavelIds.stream().map(ReciclaveisService::getReciclavelById).filter(Objects::nonNull)
				.collect(Collectors.toSet());

		doador.setReciclaveis(reciclaveis);

		return doadoresRepository.save(doador);
	}
	
	public Doadores updateDoador(Long idDoador, Doadores doadorAtualizado) {
		Doadores doadorExistente = doadoresRepository.findById(idDoador).orElse(null);
		if (doadorExistente != null) {
			doadorExistente.setNome(doadorAtualizado.getNome());
			doadorExistente.setEmail(doadorAtualizado.getEmail());
			doadorExistente.setTelefone(doadorAtualizado.getTelefone());
			doadorExistente.setEndereco(doadorAtualizado.getEndereco());
			doadorExistente.setDisponibilidade(doadorAtualizado.getDisponibilidade());
			doadorExistente.setCep(doadorAtualizado.getCep());
			doadorExistente.setEstado(doadorAtualizado.getEstado());
			doadorExistente.setCidade(doadorAtualizado.getCidade());
			doadorExistente.setBairro(doadorAtualizado.getBairro());
			doadorExistente.setNumeroDaCasa(doadorAtualizado.getNumeroDaCasa());
			

			Set<Reciclaveis> reciclavelAtualizados = doadorAtualizado.getReciclaveis();
			for (Reciclaveis reciclavel : reciclavelAtualizados) {
				reciclavel.getDoadores().add(doadorExistente);
			}

			doadorExistente.setReciclaveis(reciclavelAtualizados);

			return doadoresRepository.save(doadorExistente);
		} else {
			throw new RuntimeException("Doador com o ID" + idDoador + "não encontrado.");
		}
	}

	public void deleteDoador(Long idDoador) {
		doadoresRepository.deleteById(idDoador);
	}
}

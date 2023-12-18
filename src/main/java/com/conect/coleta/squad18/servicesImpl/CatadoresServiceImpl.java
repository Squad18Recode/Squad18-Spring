package com.conect.coleta.squad18.servicesImpl;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conect.coleta.squad18.model.Associacao;
import com.conect.coleta.squad18.model.Catadores;
import com.conect.coleta.squad18.repository.CatadoresRepository;
import com.conect.coleta.squad18.services.AssociacaoService;
import com.conect.coleta.squad18.services.CatadoresService;

@Service
public class CatadoresServiceImpl implements CatadoresService {
	
	@Autowired
	private CatadoresRepository catadoresRepository;
	
	@Autowired
	private AssociacaoService associacoesService;

	public List<Catadores> getAllCatadores() {
		return catadoresRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Catadores getCatadorById(Long id) {
		return catadoresRepository.findById(id).orElse(null);
	}

	@Transactional
	public Catadores saveCatador(Catadores catador, Set<Long> associacaoIds) {
		Set<Associacao> associacoes = associacaoIds.stream().map(associacoesService::getAssociacaoById).filter(Objects::nonNull)
				.collect(Collectors.toSet());

		catador.setAssociacao(associacoes);

		return catadoresRepository.save(catador);
	}

	public Catadores updateCatador(Long idCatador, Catadores catadorAtualizado) {
		Catadores catadorExistente = catadoresRepository.findById(idCatador).orElse(null);
		if (catadorExistente != null) {
			catadorExistente.setNome(catadorAtualizado.getNome());
			catadorExistente.setRg(catadorAtualizado.getRg());
			catadorExistente.setCpf(catadorAtualizado.getCpf());

			catadorExistente.setTelefone(catadorAtualizado.getTelefone());
			catadorExistente.setEndereco(catadorAtualizado.getEndereco());
			catadorExistente.setDisponibilidade(catadorAtualizado.getDisponibilidade());
			catadorExistente.setCep(catadorAtualizado.getCep());
			catadorExistente.setEstado(catadorAtualizado.getEstado());
			catadorExistente.setCidade(catadorAtualizado.getCidade());
			catadorExistente.setBairro(catadorAtualizado.getBairro());
			catadorExistente.setNumeroDaCasa(catadorAtualizado.getNumeroDaCasa());
			

			Set<Associacao> associacaoAtualizados = catadorAtualizado.getAssociacao();
			for (Associacao associacao : associacaoAtualizados) {
				associacao.getCatadores().add(catadorExistente);
			}

			catadorExistente.setAssociacao(associacaoAtualizados);

			return catadoresRepository.save(catadorExistente);
		} else {
			throw new RuntimeException("Catador com o ID" + idCatador + "não encontrado.");
		}
	}

	public void deleteCatador(Long idCatador) {
		catadoresRepository.deleteById(idCatador);
	}
}

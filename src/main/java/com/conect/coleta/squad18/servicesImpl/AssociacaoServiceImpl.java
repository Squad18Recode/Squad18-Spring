package com.conect.coleta.squad18.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.conect.coleta.squad18.model.Associacao;
import com.conect.coleta.squad18.repository.AssociacaoRepository;
import com.conect.coleta.squad18.services.AssociacaoService;

@Service
public class AssociacaoServiceImpl implements AssociacaoService {

	@Autowired
	private AssociacaoRepository associacaoRepository;

	@Override
	public List<Associacao> getAllAssociacoes() {
		return associacaoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Associacao getAssociacaoById(Long idAssociacao) {
		return associacaoRepository.findById(idAssociacao).orElse(null);
	}

	@Override
	@Transactional
	public Associacao saveAssociacao(Associacao associacao) {
		return associacaoRepository.save(associacao);
	}

	@Override
	public Associacao updateAssociacao(Long idAssociacao, Associacao associacaoAtualizada) {
		Associacao destinoExistente = associacaoRepository.findById(idAssociacao).orElse(null);
		if (destinoExistente != null) {
			destinoExistente.setNome(associacaoAtualizada.getNome());
			destinoExistente.setCaracteristicas(associacaoAtualizada.getCaracteristicas());
			destinoExistente.setCnpj(associacaoAtualizada.getCnpj());
			return associacaoRepository.save(destinoExistente);
		} else {
			throw new RuntimeException("Associação com o ID:" + idAssociacao + " não encontrada.");
		}
	}

	@Override
	public void deleteAssociacao(Long idAssociacao) {
		associacaoRepository.deleteById(idAssociacao);
	}
}

package com.conect.coleta.squad18.services;

import java.util.List;

import com.conect.coleta.squad18.model.Associacao;

public interface AssociacaoService {

	List<Associacao> getAllAssociacoes();

	Associacao getAssociacaoById(Long idAssociacao);

	Associacao saveAssociacao(Associacao associacao);

	Associacao updateAssociacao(Long idAssociacao, Associacao associacaoAtualizada);

	void deleteAssociacao(Long idAssociacao);
}

package com.conect.coleta.squad18.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Catadores")
public class Catadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCatador;
	private String nome;
	private String rg;
	private String cpf;
	private String telefone;
	private String endereco;
	
	@Column(columnDefinition = "TEXT")
	private String disponibilidade;
	private String numeroDaCasa;
	private String estado;
	private String cidade;
	private String bairro;
	private String cep;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "catadorAssociacao", joinColumns = @JoinColumn(name = "idCatador"), inverseJoinColumns = @JoinColumn(name = "idAssociacao"))
	private Set<Associacao> associacao = new HashSet<>();

	public Catadores() {
		super();
	}

	public Catadores(Long idCatador, String nome, String rg, String cpf, String telefone, String endereco,
			String disponibilidade, String numeroDaCasa, String estado, String cidade, String bairro, String cep,
			Set<Associacao> associacao) {
		super();
		this.idCatador = idCatador;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.disponibilidade = disponibilidade;
		this.numeroDaCasa = numeroDaCasa;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.associacao = associacao;
	}

	public Long getIdCatador() {
		return idCatador;
	}

	public void setIdCatador(Long idCatador) {
		this.idCatador = idCatador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}

	public void setNumeroDaCasa(String numeroDaCasa) {
		this.numeroDaCasa = numeroDaCasa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Set<Associacao> getAssociacao() {
		return associacao;
	}

	public void setAssociacao(Set<Associacao> associacao) {
		this.associacao = associacao;
	}
	
	
	public Set<Long> getAssociacaoIds() {
	    if (associacao != null) {
	        return associacao.stream()
	                .map(Associacao::getIdAssociacao)
	                .collect(Collectors.toSet());
	    } else {
	        return Collections.emptySet(); 
	    }
	}
}

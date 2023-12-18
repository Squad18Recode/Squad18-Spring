package com.conect.coleta.squad18.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Associacao")
public class Associacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAssociacao;
	private String nome;
	private String caracteristicas;
	private String cnpj;
	private String telefone;
	
	@ManyToMany(mappedBy = "associacao",fetch = FetchType.EAGER)
	private Set<Catadores> catadores = new HashSet<>();

	public Associacao() {
		super();
	}

	public Associacao(Long idAssociacao, String nome, String caracteristicas, String cnpj, String telefone,
			Set<Catadores> catadores) {
		super();
		this.idAssociacao = idAssociacao;
		this.nome = nome;
		this.caracteristicas = caracteristicas;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.catadores = catadores;
	}

	public Long getIdAssociacao() {
		return idAssociacao;
	}

	public void setIdAssociacao(Long idAssociacao) {
		this.idAssociacao = idAssociacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Catadores> getCatadores() {
		return catadores;
	}

	public void setCatadores(Set<Catadores> catadores) {
		this.catadores = catadores;
	}

}

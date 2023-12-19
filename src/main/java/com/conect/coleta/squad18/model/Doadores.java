package com.conect.coleta.squad18.model;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "Doadores")
public class Doadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDoador;
	private String nome;
	private String sobrenome;
	private String email;
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
	@JoinTable(name = "doadorReciclavel", joinColumns = @JoinColumn(name = "idReciclavel"), inverseJoinColumns = @JoinColumn(name = "idDoador"))
	private Set<Reciclaveis> reciclaveis = new HashSet<>();
	
	public Doadores() {
		super();
	}

	public Doadores(Long idDoador, String nome, String sobrenome, String email, String telefone, String endereco,
			String disponibilidade, String numeroDaCasa, String estado, String cidade, String bairro, String cep,
			Set<Reciclaveis> reciclaveis) {
		super();
		this.idDoador = idDoador;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.disponibilidade = disponibilidade;
		this.numeroDaCasa = numeroDaCasa;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.reciclaveis = reciclaveis;
	}

	public Long getIdDoador() {
		return idDoador;
	}

	public void setIdDoador(Long idDoador) {
		this.idDoador = idDoador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Set<Reciclaveis> getReciclaveis() {
		return reciclaveis;
	}

	public void setReciclaveis(Set<Reciclaveis> reciclaveis) {
		this.reciclaveis = reciclaveis;
	}

}

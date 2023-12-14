package com.conect.coleta.squad18.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Doadores() {
		super();
	}

	public Doadores(Long idDoador, String nome, String sobrenome, String email, String telefone, String endereco,
			String disponibilidade, String numeroDaCasa, String estado, String cidade, String bairro, String cep) {
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

}

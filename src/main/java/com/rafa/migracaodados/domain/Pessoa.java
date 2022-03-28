package com.rafa.migracaodados.domain;

import java.util.Date;

import org.apache.logging.log4j.util.Strings;

public class Pessoa {
	
	private int id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private int idade;
	
	public Pessoa() {}

	public Pessoa(int id, String nome, String email, Date dataNascimento, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public boolean isValida() {
		return Strings.isNotBlank(nome) && Strings.isNotBlank(email) && dataNascimento != null;
	}
}

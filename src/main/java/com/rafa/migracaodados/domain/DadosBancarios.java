package com.rafa.migracaodados.domain;

import java.io.Serializable;
import java.util.Objects;

public class DadosBancarios implements Serializable {
	
	private static final long serialVersionUID = 8443507515218668231L;
	
	private int id;
	private int pessoaId;
	private int agencia;
	private int conta;
	private int banco;
	
	public DadosBancarios() {}

	public DadosBancarios(int id, int pessoaId, int agencia, int conta, int banco) {
		this.id = id;
		this.pessoaId = pessoaId;
		this.agencia = agencia;
		this.conta = conta;
		this.banco = banco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(int pessoaId) {
		this.pessoaId = pessoaId;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getBanco() {
		return banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosBancarios other = (DadosBancarios) obj;
		return id == other.id;
	}
}

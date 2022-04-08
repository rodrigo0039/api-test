package com.example.jogosApi.Model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	private String cidade;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNumeroString() {
		return numero;
	}
	public void setNumeroString(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

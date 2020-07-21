package com.integradorjdbc.model;

public class Endereco {
	private long idEndereco;
	private String cep;
	private String uf;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private long numero;
	private Cliente cliente;
	
	public Endereco(){
		super();
	}	
	
	
	public Endereco (long idEndereco, String cep, String uf, String estado, String cidade, String bairro, String rua, long numero){
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.uf = uf;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;		
	}
	public long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
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
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	

}

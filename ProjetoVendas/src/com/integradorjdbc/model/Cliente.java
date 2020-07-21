package com.integradorjdbc.model;

public class Cliente {
	private long idCliente;
	private String nomeCliente;
	private String emailCliente;
	private String pedido;
	private String cnpj;
	private String fotoCliente;
	
	public Cliente(){
		super();
	}
	public Cliente(long idCliente, String nomeCliente, String emailCliente, String pedido, String cnpj, String fotoCliente){
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.pedido = pedido;
		this.cnpj = cnpj;
		this.fotoCliente = fotoCliente;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getFotoCliente() {
		return fotoCliente;
	}
	public void setFotoCliente(String fotoCliente) {
		this.fotoCliente = fotoCliente;
	}
	

}

package com.integradorjdbc.model;

public class Telefone {
	private long idTelefone;
	private String ddd;
	private String numero;
	private Distribuidor distribuidor;		
	private Cliente cliente;
	

	public Telefone(){
		super();
	}
	
	public Telefone(long idTelefone, String ddd, String numero){
		this.idTelefone = idTelefone;
		this.ddd = ddd;
		this.numero = numero;		
	}
	
	
	public long getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(long idTelefone) {
		this.idTelefone = idTelefone;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}

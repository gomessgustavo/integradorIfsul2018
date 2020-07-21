package com.integradorjdbc.model;

public class Distribuidor {
	private long idDistribuidor;
	private String nomeDistribuidor;
	private String emailDistribuidor;
	private String senha;	
	
	public Distribuidor(){
		super();
	}
	public Distribuidor (long idDistribuidor, String nomeDistribuidor, String emailDistribuidor, String senha){
		this.idDistribuidor = idDistribuidor;
		this.nomeDistribuidor = nomeDistribuidor;
		this.emailDistribuidor = emailDistribuidor;
		this.senha = senha;		
	}
	public long getIdDistribuidor() {
		return idDistribuidor;
	}
	public void setIdDistribuidor(long idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}
	public String getNomeDistribuidor() {
		return nomeDistribuidor;
	}
	public void setNomeDistribuidor(String nomeDistribuidor) {
		this.nomeDistribuidor = nomeDistribuidor;
	}
	public String getEmailDistribuidor() {
		return emailDistribuidor;
	}
	public void setEmailDistribuidor(String emailDistribuidor) {
		this.emailDistribuidor = emailDistribuidor;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}

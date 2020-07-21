package com.integradorjdbc.model;

public class DistribuidorCliente {
	private long idDistribuidorCliente;
	private Distribuidor distribuidor;
	private Cliente cliente;
	
	public DistribuidorCliente(){
		super();
	}
	public DistribuidorCliente(long idDistribuidorCliente, Distribuidor distribuidor, Cliente cliente){
		this.idDistribuidorCliente = idDistribuidorCliente;
		this.distribuidor = distribuidor;
		this.cliente = cliente;
	}
	public long getIdDistribuidorCliente() {
		return idDistribuidorCliente;
	}
	public void setIdDistribuidorCliente(long idDistribuidorCliente) {
		this.idDistribuidorCliente = idDistribuidorCliente;
	}
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}

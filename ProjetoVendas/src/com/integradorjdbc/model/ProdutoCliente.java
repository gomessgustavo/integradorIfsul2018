package com.integradorjdbc.model;

public class ProdutoCliente {
	private long idProdutoCliente;
	private Produto produto;
	private Cliente cliente;
	
	public ProdutoCliente(){
		super();
	}
	public ProdutoCliente(long idProdutoCliente, Produto produto, Cliente cliente){
		this.idProdutoCliente = idProdutoCliente;
		this.produto = produto;
		this.cliente = cliente;		
	}
	public long getIdProdutoCliente() {
		return idProdutoCliente;
	}
	public void setIdProdutoCliente(long idProdutoCliente) {
		this.idProdutoCliente = idProdutoCliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}

package com.integradorjdbc.model;

public class Produto {
	private long idProduto;
	private String nomeProduto;
	private String fotoProduto;
	private float preco;
	private String categoria;
	private Distribuidor distribuidor;
	
	public Produto(){
		super();
	}	
	
	
	public Produto(long idProduto, String nomeProduto, String fotoProduto, float preco, String categoria){
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.fotoProduto = fotoProduto;
		this.preco = preco;
		this.categoria = categoria;
	}

    public Produto(int i, String nomep, String fotop, float precop, String catP, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	public long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getFotoProduto() {
		return fotoProduto;
	}
	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

    public Object setCliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	

}

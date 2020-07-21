package com.integradorjdbc.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.integradorjdbc.model.Distribuidor;
import com.integradorjdbc.model.Produto;

public class ProdutoDAO {

private ConexaoMysql conexao;
Distribuidor distribuidor = new Distribuidor();
	
	public ProdutoDAO(){
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto_vendas");
	}
	public Produto cadastrar(Produto produto) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "INSERT INTO produto VALUES(null, ?, ?, ?, ?, null, null);";
		try {			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);			
			statement.setString(1, produto.getNomeProduto());
			statement.setString(2, produto.getFotoProduto());
			statement.setFloat(3, produto.getPreco());
			statement.setString(4, produto.getCategoria());						
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				produto.setIdProduto(rs.getLong(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			this.conexao.fecharConexao();
		}
		return produto;
	}
	public void editar(Produto produto){
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE produto SET nome_produto=?, foto_produto=?, preco=?, categoria=? WHERE id_produto=?;";
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);			
			statement.setLong(1, produto.getIdProduto());
			statement.setString(2, produto.getNomeProduto());
			statement.setString(3, produto.getFotoProduto());
			statement.setFloat(4, produto.getPreco());
			statement.setString(5, produto.getCategoria());	

			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}	
	public void excluir(long id) {		
		this.conexao.abrirConexao();		
		String sqlDelete = "DELETE FROM produto WHERE id_produto=?;";		
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, id);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
	
	public Produto buscarPorId(long id) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "SELECT * FROM produto INNER JOIN distribuidor ON produto.id_distribuidor = distribuidor.id_distribuidor WHERE id_produto=?;";
		PreparedStatement statement;
		Produto produto = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {				
				produto = new Produto();
				produto.setIdProduto(rs.getLong("id_produto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setFotoProduto(rs.getString("foto_produto"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setCategoria(rs.getString("categoria"));
				distribuidor = new Distribuidor();
				distribuidor.setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidor.setNomeDistribuidor(rs.getString("nome_distribuidor"));
				distribuidor.setEmailDistribuidor(rs.getString("email_distribuidor"));
				distribuidor.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return produto;
	}	
	
	public List<Produto> buscarTodos() {		
		this.conexao.abrirConexao();		
		String sqlSelect = "SELECT * FROM produto INNER JOIN distribuidor ON produto.id_distribuidor = distribuidor.id_distribuidor;";
		PreparedStatement statement;
		Produto produto = null;
		List<Produto> listaProduto = new ArrayList<Produto>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {				
				produto = new Produto();
				produto.setIdProduto(rs.getLong("id_produto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setFotoProduto(rs.getString("foto_produto"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setCategoria(rs.getString("categoria"));
				distribuidor = new Distribuidor();
				distribuidor.setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidor.setNomeDistribuidor(rs.getString("nome_distribuidor"));
				distribuidor.setEmailDistribuidor(rs.getString("email_distribuidor"));
				distribuidor.setSenha(rs.getString("senha"));
				listaProduto.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaProduto;
	}	
	
	public Produto buscarPorCategoria(String categoria) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "SELECT * FROM produto WHERE categoria=?;";
		PreparedStatement statement;
		Produto produto = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, categoria);			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {			
				produto = new Produto();
				produto.setIdProduto(rs.getLong("id_produto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setFotoProduto(rs.getString("foto_produto"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setCategoria(rs.getString("categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return produto;
	}
	}




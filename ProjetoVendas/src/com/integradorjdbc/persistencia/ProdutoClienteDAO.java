package com.integradorjdbc.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.integradorjdbc.model.Cliente;
import com.integradorjdbc.model.ProdutoCliente;
import com.integradorjdbc.model.Produto;

public class ProdutoClienteDAO {
	private ConexaoMysql conexao;
	Produto produto = new Produto();
	Cliente cliente = new Cliente();
	
	public ProdutoClienteDAO(){
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto_vendas");
	}
	public ProdutoCliente cadastrar(ProdutoCliente produtoCliente) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "INSERT INTO produto_cliente VALUES(null, ?, ?);";
		try {			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);			
			statement.setLong(2, produtoCliente.getProduto().getIdProduto());
			statement.setLong(3, produtoCliente.getCliente().getIdCliente());		
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				produtoCliente.setIdProdutoCliente(rs.getLong(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			this.conexao.fecharConexao();
		}
		return produtoCliente;
	}
	
	public void editar(ProdutoCliente produtoCliente){
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE produto_cliente SET id_produto=?, id_cliente=? WHERE id_produto_cliente=?;";
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);			
			statement.setLong(1, produtoCliente.getIdProdutoCliente());
			statement.setLong(2, produtoCliente.getProduto().getIdProduto());
			statement.setLong(3, produtoCliente.getCliente().getIdCliente());
			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}	
	public void excluir(long id) {		
		this.conexao.abrirConexao();		
		String sqlDelete = "DELETE FROM produto_cliente WHERE id_produto_cliente=?;";		
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
	
	public ProdutoCliente buscarPorId(long id) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "SELECT * FROM distribuidor_cliente INNER JOIN distribuidor ON distribuidor_cliente.id_distribuidor = distribuidor.id_distribuidor INNER JOIN cliente ON distribuidor_cliente.id_cliente = cliente.id_cliente WHERE id_distribuidor_cliente=?;";
		PreparedStatement statement;
		ProdutoCliente produtoCliente = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {				
				produtoCliente = new ProdutoCliente();
				produtoCliente.setIdProdutoCliente(rs.getLong("id_distribuidor_cliente"));
				produtoCliente.getProduto().setIdProduto(rs.getLong("id_produto"));
				produtoCliente.getCliente().setIdCliente(rs.getLong("id_cliente"));							
				cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNomeCliente(rs.getString("nome_cliente"));
				cliente.setEmailCliente(rs.getString("email_cliente"));
				cliente.setPedido(rs.getString("pedido"));
				cliente.setCnpj(rs.getString("cnpj"));
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
		return produtoCliente;
	}	
	
	public List<ProdutoCliente> buscarTodos() {		
		this.conexao.abrirConexao();		
		String sqlSelect = "SELECT * FROM produto_cliente INNER JOIN produto ON produto_cliente.id_produto = produto.id_produto INNER JOIN cliente ON produto_cliente.id_cliente = cliente.id_cliente;";
		PreparedStatement statement;
		ProdutoCliente produtoCliente = null;
		List<ProdutoCliente> listaProdutoCliente = new ArrayList<ProdutoCliente>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {				
				produtoCliente = new ProdutoCliente();
				produtoCliente.setIdProdutoCliente(rs.getLong("id_distribuidor_cliente"));
				produtoCliente.getProduto().setIdProduto(rs.getLong("id_produto"));
				produtoCliente.getCliente().setIdCliente(rs.getLong("id_cliente"));							
				cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNomeCliente(rs.getString("nome_cliente"));
				cliente.setEmailCliente(rs.getString("email_cliente"));
				cliente.setPedido(rs.getString("pedido"));
				cliente.setCnpj(rs.getString("cnpj"));
				produto = new Produto();
				produto.setIdProduto(rs.getLong("id_produto"));
				produto.setNomeProduto(rs.getString("nome_produto"));
				produto.setFotoProduto(rs.getString("foto_produto"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setCategoria(rs.getString("categoria"));		
				listaProdutoCliente.add(produtoCliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaProdutoCliente;
	}	
	

	}
	







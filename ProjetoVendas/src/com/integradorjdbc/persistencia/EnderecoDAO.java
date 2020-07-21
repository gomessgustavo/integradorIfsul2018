package com.integradorjdbc.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.integradorjdbc.model.Cliente;
import com.integradorjdbc.model.Endereco;

public class EnderecoDAO {
private ConexaoMysql conexao;
Cliente cliente = new Cliente();
	
	public EnderecoDAO(){
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto_vendas");
	}
	public Endereco cadastrar(Endereco endereco) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "INSERT INTO endereco VALUES(null, ?, ?, ?, ?, ?, ?, ?);";
		try {			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);			
			statement.setString(1, endereco.getCep());
			statement.setString(2, endereco.getUf());
			statement.setString(3, endereco.getEstado());
			statement.setString(4, endereco.getCidade());
			statement.setString(5, endereco.getBairro());
			statement.setString(6, endereco.getRua());
			statement.setLong(7, endereco.getNumero());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				endereco.setIdEndereco(rs.getLong(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			this.conexao.fecharConexao();
		}
		return endereco;
	}
	public void editar(Endereco endereco){
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE endereco SET cep=?, uf=?, estado=?, cidade=?, bairro=?, rua=?, numero=? WHERE id_endereco=?;";
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);			
			statement.setString(1, endereco.getCep());
			statement.setString(2, endereco.getUf());
			statement.setString(3, endereco.getEstado());
			statement.setString(4, endereco.getCidade());
			statement.setString(5, endereco.getBairro());
			statement.setString(6, endereco.getRua());
			statement.setLong(7, endereco.getNumero());
			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}	
	public void excluir(long id) {		
		this.conexao.abrirConexao();		
		String sqlDelete = "DELETE FROM endereco WHERE id_endereco=?;";		
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
	
	public Endereco buscarPorId(long id) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "SELECT * FROM endereco INNER JOIN cliente ON endereco.id_cliente = cliente.id_cliente WHERE id_endereco=?;";
		PreparedStatement statement;
		Endereco endereco = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {				
				endereco = new Endereco();
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setCep(rs.getString("cep"));
				endereco.setUf(rs.getString("uf"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getLong("numero"));
				cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNomeCliente(rs.getString("nome_cliente"));
				cliente.setEmailCliente(rs.getString("email_cliente"));
				cliente.setPedido(rs.getString("pedido"));
				cliente.setCnpj(rs.getString("cnpj"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return endereco;
	}	
	
	public List<Endereco> buscarTodos() {		
		this.conexao.abrirConexao();		
		String sqlSelect = "SELECT * FROM endereco INNER JOIN cliente ON endereco.id_cliente = cliente.id_cliente;";
		PreparedStatement statement;
		Endereco endereco = null;
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {	
				endereco = new Endereco();
				endereco.setIdEndereco(rs.getLong("id_endereco"));
				endereco.setCep(rs.getString("cep"));
				endereco.setUf(rs.getString("uf"));
				endereco.setEstado(rs.getString("estado"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getLong("numero"));
				cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNomeCliente(rs.getString("nome_cliente"));
				cliente.setEmailCliente(rs.getString("email_cliente"));
				cliente.setPedido(rs.getString("pedido"));
				cliente.setCnpj(rs.getString("cnpj"));
				listaEndereco.add(endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaEndereco;

	}
	}



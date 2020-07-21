package com.integradorjdbc.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.integradorjdbc.model.Cliente;

public class ClienteDAO {
	
	private ConexaoMysql conexao;
	
	public ClienteDAO(){
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto_vendas");
	}
	public Cliente cadastrar(Cliente cliente) {		
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO cliente VALUES(null, ?, ?, ?, ?, ?, null, null);";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);							
			statement.setString(1, cliente.getNomeCliente());
			statement.setString(2, cliente.getEmailCliente());
			statement.setString(3, cliente.getPedido());
                        statement.setString(4, cliente.getCnpj());
                        statement.setString(5, cliente.getFotoCliente());
			statement.executeUpdate();
			
			
 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
            return null;
        }
	public void editar(Cliente cliente){
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE cliente SET nome_cliente=?, email_cliente=?, pedido=?, cnpj=? WHERE id_cliente=?;";
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);			
			statement.setString(1, cliente.getNomeCliente());
			statement.setString(2, cliente.getEmailCliente());
			statement.setString(3, cliente.getPedido());
			statement.setString(4, cliente.getCnpj());
			statement.setLong(5, cliente.getIdCliente());

			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}	
	public void excluir(long id) {		
		this.conexao.abrirConexao();		
		String sqlDelete = "DELETE FROM cliente WHERE id_cliente=?;";		
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
	
	public Cliente buscarPorId(long id) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "SELECT * FROM cliente WHERE id_cliente=?;";
		PreparedStatement statement;
		Cliente cliente = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {				
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
		return cliente;
	}	
	
	public List<Cliente> buscarTodos() {		
		this.conexao.abrirConexao();		
		String sqlSelect = "SELECT * FROM cliente;";
		PreparedStatement statement;
		Cliente cliente = null;
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {				
				cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNomeCliente(rs.getString("nome_cliente"));
				cliente.setEmailCliente(rs.getString("email_cliente"));
				cliente.setPedido(rs.getString("pedido"));
				cliente.setCnpj(rs.getString("cnpj"));
				listaCliente.add(cliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaCliente;
	}	
	
	public Cliente buscarPorEmail(String email) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "SELECT * FROM cliente WHERE email_cliente=?;";
		PreparedStatement statement;
		Cliente cliente = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, email);			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {			
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
		return cliente;
	}
	}



package com.integradorjdbc.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.integradorjdbc.model.Cliente;
import com.integradorjdbc.model.Distribuidor;
import com.integradorjdbc.model.DistribuidorCliente;

public class DistribuidorClienteDAO {
	private ConexaoMysql conexao;
	Distribuidor distribuidor = new Distribuidor();
	Cliente cliente = new Cliente();
	
	public DistribuidorClienteDAO(){
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto_vendas");
	}
	public DistribuidorCliente cadastrar(DistribuidorCliente distribuidorCliente) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "INSERT INTO distribuidor_cliente VALUES(null, ?, ?);";
		try {			
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);			
			statement.setLong(1, distribuidorCliente.getDistribuidor().getIdDistribuidor());
			statement.setLong(2, distribuidorCliente.getCliente().getIdCliente());		
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if(rs.next()) {
				distribuidorCliente.setIdDistribuidorCliente(rs.getLong(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {			
			this.conexao.fecharConexao();
		}
		return distribuidorCliente;
	}
	
	public void editar(DistribuidorCliente distribuidorCliente){
		this.conexao.abrirConexao();
		
		String sqlUpdate = "UPDATE distribuidor_cliente SET id_distruibuidor=?, id_cliente=? WHERE id_distribuidor_cliente=?;";
		try{
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);			
			statement.setLong(1, distribuidorCliente.getIdDistribuidorCliente());
			statement.setLong(2, distribuidorCliente.getDistribuidor().getIdDistribuidor());
			statement.setLong(3, distribuidorCliente.getCliente().getIdCliente());
			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}	
	public void excluir(long id) {		
		this.conexao.abrirConexao();		
		String sqlDelete = "DELETE FROM distribuidor_cliente WHERE id_distribuidor_cliente=?;";		
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
	
	public DistribuidorCliente buscarPorId(long id) {		
		this.conexao.abrirConexao();		
		String sqlInsert = "SELECT * FROM distribuidor_cliente INNER JOIN distribuidor ON distribuidor_cliente.id_distribuidor = distribuidor.id_distribuidor INNER JOIN cliente ON distribuidor_cliente.id_cliente = cliente.id_cliente WHERE id_distribuidor_cliente=?;";
		PreparedStatement statement;
		DistribuidorCliente distribuidorCliente = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {				
				distribuidorCliente = new DistribuidorCliente();
				distribuidorCliente.setIdDistribuidorCliente(rs.getLong("id_distribuidor_cliente"));
				distribuidorCliente.getDistribuidor().setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidorCliente.getCliente().setIdCliente(rs.getLong("id_cliente"));
				distribuidor = new Distribuidor();
				distribuidor.setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidor.setNomeDistribuidor(rs.getString("nome_distribuidor"));
				distribuidor.setEmailDistribuidor(rs.getString("email_distribuidor"));
				distribuidor.setSenha(rs.getString("senha"));			
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
		return distribuidorCliente;
	}	
	
	public List<DistribuidorCliente> buscarTodos() {		
		this.conexao.abrirConexao();		
		String sqlSelect = "SELECT * FROM distribuidor_cliente INNER JOIN distribuidor ON distribuidor_cliente.id_distribuidor = distribuidor.id_distribuidor INNER JOIN cliente ON distribuidor_cliente.id_cliente = cliente.id_cliente;";
		PreparedStatement statement;
		DistribuidorCliente distribuidorCliente = null;
		List<DistribuidorCliente> listaDistribuidorCliente = new ArrayList<DistribuidorCliente>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {				
				distribuidorCliente = new DistribuidorCliente();
				distribuidorCliente.setIdDistribuidorCliente(rs.getLong("id_distribuidor_cliente"));
				distribuidorCliente.getDistribuidor().setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidorCliente.getCliente().setIdCliente(rs.getLong("id_cliente"));
				distribuidor = new Distribuidor();
				distribuidor.setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidor.setNomeDistribuidor(rs.getString("nome_distribuidor"));
				distribuidor.setEmailDistribuidor(rs.getString("email_distribuidor"));
				distribuidor.setSenha(rs.getString("senha"));			
				cliente = new Cliente();
				cliente.setIdCliente(rs.getLong("id_cliente"));
				cliente.setNomeCliente(rs.getString("nome_cliente"));
				cliente.setEmailCliente(rs.getString("email_cliente"));
				cliente.setPedido(rs.getString("pedido"));
				cliente.setCnpj(rs.getString("cnpj"));		
				listaDistribuidorCliente.add(distribuidorCliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDistribuidorCliente;
	}	
	

	}
	






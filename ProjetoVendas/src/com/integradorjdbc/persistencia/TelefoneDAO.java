package com.integradorjdbc.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.integradorjdbc.model.Cliente;
import com.integradorjdbc.model.Distribuidor;
import com.integradorjdbc.model.Telefone;

public class TelefoneDAO {
	private ConexaoMysql conexao;
	Cliente cliente = new Cliente();
	Distribuidor distribuidor = new Distribuidor();
		
		public TelefoneDAO(){
			super();
			this.conexao = new ConexaoMysql("localhost", "root", "", "projeto_vendas");
		}
		public Telefone cadastrar(Telefone telefone) {		
			this.conexao.abrirConexao();		
			String sqlInsert = "INSERT INTO telefone VALUES(null, ?, ?);";
			try {			
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);			
				statement.setString(1, telefone.getDdd());
				statement.setString(2, telefone.getNumero());				
				statement.executeUpdate();
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					telefone.setIdTelefone(rs.getLong(1));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {			
				this.conexao.fecharConexao();
			}
			return telefone;
		}
		public void editar(Telefone telefone){
			this.conexao.abrirConexao();
			
			String sqlUpdate = "UPDATE telefone SET ddd=?, numero=? WHERE id_telefone=?;";
			try{
				PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);			
				statement.setString(1, telefone.getDdd());
				statement.setString(2, telefone.getNumero());
				statement.setLong(3, telefone.getIdTelefone());				
				statement.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.conexao.fecharConexao();
			}
		}	
		public void excluir(long id) {		
			this.conexao.abrirConexao();		
			String sqlDelete = "DELETE FROM telefone WHERE id_telefone=?;";		
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
		
		public Telefone buscarPorId(long id) {		
			this.conexao.abrirConexao();		
			String sqlInsert = "SELECT * FROM telefone INNER JOIN distribuidor ON telefone.id_distribuidor = distribuidor.id_distribuidor INNER JOIN cliente ON telefone.id_cliente = cliente.id_cliente WHERE id_telefone=?;";
			PreparedStatement statement;
			Telefone telefone = null;
			try {
				statement = this.conexao.getConexao().prepareStatement(sqlInsert);
				statement.setLong(1, id);
				ResultSet rs = statement.executeQuery();
				if(rs.next()) {				
					telefone = new Telefone();
					telefone.setIdTelefone(rs.getLong("id_telefone"));
					telefone.setDdd(rs.getString("ddd"));
					telefone.setNumero(rs.getString("numero"));					
					cliente = new Cliente();
					cliente.setIdCliente(rs.getLong("id_cliente"));
					cliente.setNomeCliente(rs.getString("nome_cliente"));
					cliente.setEmailCliente(rs.getString("email_cliente"));
					cliente.setPedido(rs.getString("pedido"));
					cliente.setCnpj(rs.getString("cnpj"));
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
			return telefone;
		}	
		
		public List<Telefone> buscarTodos() {		
			this.conexao.abrirConexao();		
			String sqlSelect = "SELECT * FROM telefone INNER JOIN distribuidor ON telefone.id_distribuidor = distribuidor.id_distribuidor INNER JOIN cliente ON telefone.id_cliente = cliente.id_cliente;";
			PreparedStatement statement;
			Telefone telefone = null;
			List<Telefone> listaTelefone = new ArrayList<Telefone>();
			try {
				statement = this.conexao.getConexao().prepareStatement(sqlSelect);
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {	
					telefone = new Telefone();
					telefone.setIdTelefone(rs.getLong("id_telefone"));
					telefone.setDdd(rs.getString("ddd"));
					telefone.setNumero(rs.getString("numero"));					
					cliente = new Cliente();
					cliente.setIdCliente(rs.getLong("id_cliente"));
					cliente.setNomeCliente(rs.getString("nome_cliente"));
					cliente.setEmailCliente(rs.getString("email_cliente"));
					cliente.setPedido(rs.getString("pedido"));
					cliente.setCnpj(rs.getString("cnpj"));
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
			return listaTelefone;
		}
		
		public Telefone buscarPorNumero(String numero) {		
			this.conexao.abrirConexao();		
			String sqlInsert = "SELECT * FROM produto WHERE categoria=?;";
			PreparedStatement statement;
			Telefone telefone = null;
			try {
				statement = this.conexao.getConexao().prepareStatement(sqlInsert);
				statement.setString(1, numero);			
				ResultSet rs = statement.executeQuery();
				if(rs.next()) {			
					telefone = new Telefone();
					telefone.setIdTelefone(rs.getLong("id_telefone"));
					telefone.setDdd(rs.getString("ddd"));
					telefone.setNumero(rs.getString("numero"));	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				this.conexao.fecharConexao();
			}
			return telefone;
		}
		}



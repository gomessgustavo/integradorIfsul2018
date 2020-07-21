package com.integradorjdbc.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.integradorjdbc.model.Distribuidor;

public class DistribuidorDAO {
	private ConexaoMysql conexao;

	public DistribuidorDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "","projeto_vendas");
				
	}

	public void cadastrar(Distribuidor distribuidor) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO distribuidor VALUES(null, ?, ?, ?, null, null);";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlInsert);							
			statement.setString(1, distribuidor.getNomeDistribuidor());
			statement.setString(2, distribuidor.getEmailDistribuidor());
			statement.setString(3, distribuidor.getSenha());
			statement.executeUpdate();
			
			
                        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		
	}

	public void editar(Distribuidor distribuidor) {
		this.conexao.abrirConexao();

		String sqlUpdate = "UPDATE distribuidor SET nome_distribuidor=?, email_distribuidor=?, senha=? WHERE id_distribuidor=?;";
		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlUpdate);
			statement.setString(1, distribuidor.getNomeDistribuidor());
			statement.setString(2, distribuidor.getEmailDistribuidor());
			statement.setString(3, distribuidor.getSenha());
			statement.setLong(4, distribuidor.getIdDistribuidor());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM distribuidor WHERE id_distribuidor=?;";
		try {
			PreparedStatement statement = this.conexao.getConexao()
					.prepareStatement(sqlDelete);
			statement.setLong(1, id);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public Distribuidor buscarPorId(long id) {
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM distribuidor WHERE id_distribuidor=?;";
		PreparedStatement statement;
		Distribuidor distribuidor = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				distribuidor = new Distribuidor();
				distribuidor.setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidor.setNomeDistribuidor(rs
						.getString("nome_distribuidor"));
				distribuidor.setEmailDistribuidor(rs
						.getString("email_distribuidor"));
				distribuidor.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return distribuidor;
	}

	public List<Distribuidor> buscarTodos() {
		this.conexao.abrirConexao();
		String sqlSelect = "SELECT * FROM distribuidor;";
		PreparedStatement statement;
		Distribuidor distribuidor = null;
		List<Distribuidor> listaDistribuidor = new ArrayList<Distribuidor>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				distribuidor = new Distribuidor();
				distribuidor.setIdDistribuidor(rs.getLong("id_distribuidor"));
				distribuidor.setNomeDistribuidor(rs
						.getString("nome_distribuidor"));
				distribuidor.setEmailDistribuidor(rs
						.getString("email_distribuidor"));
				distribuidor.setSenha(rs.getString("senha"));
				listaDistribuidor.add(distribuidor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
		return listaDistribuidor;
	}

	public Distribuidor login(String email, String senha) {
		this.conexao.abrirConexao();
		String sqlInsert = "SELECT * FROM distribuidor WHERE email_distribuidor=? AND senha=?;";
		PreparedStatement statement;
		Distribuidor distribuidor = null;
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlInsert);
			statement.setString(1, email);	
			statement.setString(2, senha);	
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
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
		return distribuidor;
	}

}

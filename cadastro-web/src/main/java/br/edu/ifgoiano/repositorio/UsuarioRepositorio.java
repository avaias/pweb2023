package br.edu.ifgoiano.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifgoiano.controle.entidade.Usuario;

public class UsuarioRepositorio {
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:h2:~/usuariodb", "sa", "sa");
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> lstUsuarios = new ArrayList<Usuario>();
		String sql = "select id, nome, email, senha, data_nascimento from usuario";

		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setDataNascimento(resultSet.getDate("data_nascimento"));
				
				lstUsuarios.add(usuario);
			}

		} catch (Exception e) {
			System.out.println("Erro na consulta de usuários!");
		}
		
		return lstUsuarios;
	}
	
	public void inserirUsuario(Usuario usuario) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO usuario").append("(nome, email, senha)").append("VALUES (?, ?, ?);");
		
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql.toString());){
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			
			pst.execute();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("Erro na inclusão de usuários");
			e.printStackTrace();
		}
	}
	public Usuario obterUsuario(int id) {
		String sql = "SELECT nome, email, senha FROM usuario WHERE id = ?";
		
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setInt(1, id);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(id);
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				
				return usuario;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar o usuário");
			e.printStackTrace();
		}
		
		throw new RuntimeException("Usuário não encontrado!");	
	}
	
	public Usuario obterUsuario(String email) {
		String sql = "SELECT nome, email, senha FROM usuario WHERE email = ?";
		
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, email);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				
				return usuario;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar o usuário");
			e.printStackTrace();
		}
		
		throw new RuntimeException("Usuário não encontrado!");
		
	}
	
	public void alterarUsuario(Usuario usuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario ");
		sql.append("SET nome = ?, email = ?, senha = ?");
		sql.append("WHERE id= ?");
		
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql.toString())) {
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setInt(4, usuario.getId());
			pst.execute();
			
			conn.commit();
		} catch (SQLException e) {
			System.out.println("Erro na edição de usuários");
			e.printStackTrace();
		}
		
	}
	
	public void excluirUsuario(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql.toString())) {
			pst.setInt(1, usuario.getId());
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro na exlucsão do usuário");
			e.printStackTrace();
		}
	}
}

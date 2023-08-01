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
		
		System.out.println(sql);
		
		try (Connection conn = this.getConnection(); PreparedStatement pst = conn.prepareStatement(sql.toString());){
			ResultSet resultSet = pst.executeQuery();
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
}

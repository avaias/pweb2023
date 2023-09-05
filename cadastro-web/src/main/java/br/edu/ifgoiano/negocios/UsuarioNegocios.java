package br.edu.ifgoiano.negocios;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

public class UsuarioNegocios {
	private final UsuarioRepositorio repositorio = new UsuarioRepositorio();
	
	public String validaCadastroUsuario(String nome, String email, String senha01, String senha02) {	
		
		if(nome.isBlank() || email.isBlank() || senha01.isBlank() || senha02.isBlank()){
			return "O preenchimento de todos os campos é obrigatório.";
		}
		
		
		if(!senha01.equals(senha02)) {
			return  nome.concat(", as senhas não são iguais.");
		}
		
		if(!repositorio.obterUsuario(email).getEmail().isBlank()) {
			return nome.concat(", o e-mail inserido já está cadastrado. Por favor, informe outro.");
		}
		
		
		return "";
	}
	
	public boolean validaLogin(String email, String senha) {
		if(senha.equals(repositorio.obterUsuario(email).getSenha())) {
			return true;
		}
		
		return false;
	}
}

package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 7036815389008473423L;
	private static final String senhaCorreta = "123456";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email"), senha = req.getParameter("senha");
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		Usuario usuario = new Usuario();
		
		usuario = repositorio.obterUsuario(email);
		System.out.println("Info do usu:"+usuario.getEmail());
		
		
		System.out.println(email);
		System.out.println(senha);
		String html = new String();
		
		
		if(senha.equals(usuario.getSenha())) {
			html = "<html><body><h1>Login realizado com sucesso!</h1></body></html>";
		}else {
			html = "<html><body><h1>Falha no login: email e/ou senha inválido(s)</h1></body></html>";
		}
		
		PrintWriter writer = resp.getWriter();
		writer.println(html);
	}
}



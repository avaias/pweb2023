package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.negocios.UsuarioNegocios;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	private final UsuarioRepositorio repositorio = new UsuarioRepositorio();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String nome = req.getParameter("nome"), email = req.getParameter("email") , senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		UsuarioNegocios negocios = new UsuarioNegocios();

		String mensagem = negocios.validaCadastroUsuario(nome, email, senha01, senha02);
		
		if(mensagem.isBlank()) {
			Usuario usuario = new Usuario();
			resp.sendRedirect("index.html");
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha01);
			repositorio.inserirUsuario(usuario);
		}else {
			req.setAttribute("mensagem", mensagem);
			req.getRequestDispatcher("usuarioCadastro.jsp").forward(req , resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listaUsuarios", repositorio.listarUsuarios());
		req.getRequestDispatcher("usuarioListagem.jsp").forward(req, resp);
	}
	
	
}

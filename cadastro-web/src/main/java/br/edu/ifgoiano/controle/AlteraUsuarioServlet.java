package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.negocios.UsuarioNegocios;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/alterarUsuario")

public class AlteraUsuarioServlet extends HttpServlet {
	private UsuarioRepositorio repositorio = new UsuarioRepositorio();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"), nome = req.getParameter("nome"), email = req.getParameter("email"), senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		UsuarioNegocios negocios = new UsuarioNegocios();
		Usuario usuario = new Usuario();
		usuario.setId(Integer.valueOf(id));
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha01);
		String mensagem = negocios.validaAlteracaoUsuario(nome, email, senha01, senha02);
		
		if(mensagem.isBlank()) {
			
			repositorio.alterarUsuario(usuario);
			
			//Redirecionar o usuário para a tela de listagem
			resp.sendRedirect("cadastrarUsuario");
	
		}else {
			req.setAttribute("mensagem", mensagem);
			req.setAttribute("usuario", usuario);
			
			req.getRequestDispatcher("usuarioAlterar.jsp").forward(req , resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("usuarioId"));
		Usuario usuario = repositorio.obterUsuario(id);
		req.setAttribute("usuario", usuario);
		req.getRequestDispatcher("usuarioAlterar.jsp").forward(req, resp);
	}
}


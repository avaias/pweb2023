package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/alterarUsuario")

public class AlteraUsuarioServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"), nome = req.getParameter("nome"), email = req.getParameter("email"), senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		Usuario usuario = new Usuario();
		usuario.setId(Integer.valueOf(id));
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha01);
		
		if( (senha01.equals(senha02)) && !senha01.isBlank()) {
			
			UsuarioRepositorio repositorio = new UsuarioRepositorio();
			repositorio.alterarUsuario(usuario);
			
			//Redirecionar o usuário para a tela de listagem
			resp.sendRedirect("cadastrarUsuario");
	
		}else {
			String mensagem = usuario.getNome().concat(", as senhas informadas não são iguais");
			req.setAttribute("mensagem", mensagem);
			req.setAttribute("usuario", usuario);
			
			req.getRequestDispatcher("usuarioAlterar.jsp").forward(req , resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("usuarioId"));
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		Usuario usuario = repositorio.obterUsuario(id);
		req.setAttribute("usuario", usuario);
		req.getRequestDispatcher("usuarioAlterar.jsp").forward(req, resp);
	}
}


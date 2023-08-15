package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet(urlPatterns = "/excluirUsuario")
public class ExcluiUsuarioServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("usuarioId"));
		Usuario usuario = new Usuario();
		usuario.setId(id);
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		repositorio.excluirUsuario(usuario);
		resp.sendRedirect("cadastrarUsuario");
	}
}

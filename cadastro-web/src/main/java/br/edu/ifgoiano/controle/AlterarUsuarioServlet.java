package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/alterarUsuario")

public class AlterarUsuarioServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"),nome = req.getParameter("nome"), email = req.getParameter("email"), senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		System.out.println(id);
		if( (senha01.equals(senha02)) && !senha01.isBlank()  ) {
			Usuario usuario = new Usuario();
			//Redirecionar o usuário para a tela de login
			resp.sendRedirect("cadastrarUsuario");
			usuario.setId(Integer.parseInt(id));
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha01);
			UsuarioRepositorio repositorio = new UsuarioRepositorio();
			repositorio.alterarUsuario(usuario);
		}else {
			//Redirecionar o usuário para a mesma página de cadastro do usuário
			req.getRequestDispatcher("usuarioAlterar.jsp").forward(req , resp);
			
		}
	}
}


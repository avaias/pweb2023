package br.edu.ifgoiano.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifgoiano.controle.entidade.Usuario;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = new Usuario();
		//Verificar se as senhas são iguais
		String nome = req.getParameter("nome"), email = req.getParameter("email") , senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		if(senha01.equals(senha02)) {
			//Redirecionar o usuário para a tela de login
			resp.sendRedirect("index.html");
		}else {
			//Redirecionar o suário para a mesma página de cadastro do usuário
			req.getRequestDispatcher("cadastroUsuario.html").forward(req,resp);
		}
	}
}

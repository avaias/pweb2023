package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.negocios.UsuarioNegocios;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 7036815389008473423L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email"), senha = req.getParameter("senha");
		UsuarioNegocios negocios = new UsuarioNegocios();
		String html = new String();
		
		if(negocios.validaLogin(email, senha)) {
			html = "<html><body><h1>Login realizado com sucesso!</h1></body></html>";
		}else {
			req.setAttribute("mensagem", "Falha no login: email e/ou senha inválido(s)");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		PrintWriter writer = resp.getWriter();
		writer.println(html);
	}
}



package ifgoiano.edu.br.controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email"), senha = req.getParameter("senha");
		String html;
		if(senha.equals("123456")) {
			html = "<body><h1>Login efetuado com sucesso!</h1></body>";
		}else {
			html = "<body><h1>Login recusado! Por favor, insira a senha correta.</h1></body>";
		}
		
		PrintWriter writer = resp.getWriter();
		writer.write(html);
	}
}

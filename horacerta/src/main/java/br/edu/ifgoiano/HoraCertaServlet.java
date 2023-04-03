package br.edu.ifgoiano;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/agora")
public class HoraCertaServlet extends HttpServlet {

	private static final long serialVersionUID = -1359692602392548578L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date dataAtual = new Date();
		
		StringBuilder conteudoHtml = new StringBuilder()
		.append("<!DOCTYPE html>")
		.append("<html>")
		.append("<head>")
		.append("<meta charset=\"UTF-8\">")
		.append("<title>Horário dinâmico</title>")
		.append("</head>")
		.append("<body>")
		.append("	<h1><span>Horário dinâmico: ").append(dataAtual.toString()).append("</span></h1>")
		.append("</body>")
		.append("</html>");
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println(conteudoHtml);
	}

}

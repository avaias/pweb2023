package br.ifgoiano.edu.br.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/conversorDeMoeda")
public class ConversorDeMoedaServlet extends HttpServlet {

	private static final long serialVersionUID = 9103959933621421300L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cotacao = req.getParameter("cotacao");
		String reais = req.getParameter("reais");
		
		if(cotacao.isEmpty() || reais.isEmpty()) {
			//Retornar para página de erro
			resp.sendRedirect("erroDeConversao.jsp");
		}else {
			//Calcular o valor em dolar
			Float vlrCotacao = Float.parseFloat(cotacao);
			Float vlrReais = Float.parseFloat(reais);
			
			Float vlrDolares = vlrReais / vlrCotacao;
			
			//Retornar o valor para o usuário
			resp.getWriter().print(obterHtmlDeMoedaConvertida(vlrReais, vlrDolares));
		}
	}
	
	private String obterHtmlDeMoedaConvertida(Float vlrReais, Float vlrDolares) {
		String html = new String()
		.concat("<html>")
		.concat("<body>")
			.concat("<p>")
			.concat("O valor R$ " + vlrReais + " equivale a $ " + vlrDolares + " na contação atual do dólar.")
			.concat("</p>")
			.concat("<p>Vindo do Servlet</p>")
			.concat("<a href=\"index.jsp\">Voltar</a>")
		.concat("</body>")
		.concat("</html>");
		
		return html;
	}
}

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
		String cotacao = req.getParameter("cotacao"), reais = req.getParameter("reais");
		
		if(cotacao.isEmpty() || reais.isEmpty()) {
			//Retornar para página de erro
			resp.sendRedirect("erroDeConversao.jsp");
		}else {
			//Calcular o valor em dolar
			Float vlrCotacao = Float.parseFloat(cotacao), vlrReais = Float.parseFloat(reais);
			Float vlrDolares = vlrReais / vlrCotacao;
			req.setAttribute("cotacao", vlrCotacao);
			req.setAttribute("reais", vlrReais);
			req.setAttribute("dolares", vlrDolares);
			req.getRequestDispatcher("moedaConvertida.jsp").forward(req, resp);
		}
	}
	
	
}

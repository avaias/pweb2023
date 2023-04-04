import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/soma")
public class SomaServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1")), num2 = Integer.parseInt(req.getParameter("num2"));
		int soma = num1 + num2;
		PrintWriter writer = resp.getWriter();
		writer.write("<body><h1>A soma dos dois números inseridos anteriormente é igual a "+soma+"</h1></body>");
	}
}

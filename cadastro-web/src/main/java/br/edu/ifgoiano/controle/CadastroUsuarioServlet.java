package br.edu.ifgoiano.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifgoiano.controle.entidade.Usuario;
import br.edu.ifgoiano.repositorio.UsuarioRepositorio;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuarioServlet extends HttpServlet {
	private final UsuarioRepositorio repositorio = new UsuarioRepositorio();
	
	private void sendErrorRedirect(HttpServletRequest req, HttpServletResponse resp, String mensagem) throws ServletException, IOException {
		req.setAttribute("mensagem", mensagem);
		req.getRequestDispatcher("usuarioCadastro.jsp").forward(req , resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String nome = req.getParameter("nome"), email = req.getParameter("email") , senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		
		/*
		 * Verifica se todos os campos estão preenchidos, se as senhas são iguais e se o e-mail já está cadastrado. Caso a verificação falhe, o usuário retornará para a mesma página com uma mensagem de erro.
		 */
		
		if(!nome.isBlank() && !email.isBlank() && !senha01.isBlank() && !senha02.isBlank()){
			if(senha01.equals(senha02)) {
				String repositorioUsuarioEmail = repositorio.obterUsuario(email).getEmail();					

				if(repositorioUsuarioEmail.isBlank()) {
					Usuario usuario = new Usuario();
					resp.sendRedirect("index.html");
					usuario.setNome(nome);
					usuario.setEmail(email);
					usuario.setSenha(senha01);
					repositorio.inserirUsuario(usuario);
				}else {
					sendErrorRedirect(req, resp, nome.concat(", o e-mail inserido já está cadastrado. Por favor, informe outro."));
				}
			}else {
				sendErrorRedirect(req, resp, nome.concat(", as senhas não são iguais."));
			}
		}else {
			sendErrorRedirect(req, resp, "O preenchimento de todos os campos é obrigatório.");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("listaUsuarios", repositorio.listarUsuarios());
		req.getRequestDispatcher("usuarioListagem.jsp").forward(req, resp);
	}
	
	
}

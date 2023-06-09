package br.edu.ifgoiano.controle;

import java.io.IOException;
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
	
	//Simulando o banco de dados
	private List<Usuario> listaDeUsuario;
	
	@Override
	public void init() throws ServletException {
		this.listaDeUsuario = new ArrayList<Usuario>();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Verificar se as senhas são iguais
		String nome = req.getParameter("nome"), email = req.getParameter("email") , senha01 = req.getParameter("senha01"), senha02 = req.getParameter("senha02");
		if(senha01.equals(senha02)) {
			Usuario usuario = new Usuario();
			//Redirecionar o usuário para a tela de login
			resp.sendRedirect("index.html");
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha01);
			UsuarioRepositorio repositorio = new UsuarioRepositorio();
			
			listaDeUsuario.add(usuario);
			
		}else {
			//Redirecionar o suário para a mesma página de cadastro do usuário
			req.getRequestDispatcher("usuarioCadastro.jsp").forward(req , resp);
			
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioRepositorio repositorio = new UsuarioRepositorio();
		req.setAttribute("listaUsuarios", repositorio.listarUsuarios());
		req.getRequestDispatcher("usuarioListagem.jsp").forward(req, resp);
		
	}
	
	@Override
	public void destroy() {
		try {
			UsuarioRepositorio.conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.listaDeUsuario.clear();
		
	}
}

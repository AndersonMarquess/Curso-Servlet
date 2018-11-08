package com.andersonmarques.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();
		boolean isUsuarioNaoAutenticado = (sessao.getAttribute("usuarioLogado") == null);
		boolean isEndpointProtegido = !(acao.equals("LoginForm") || acao.equals("AutenticarUsuario"));
		if(isUsuarioNaoAutenticado && isEndpointProtegido) {
			response.sendRedirect("?acao=LoginForm");
			return;
		}
		
		
		//Instância a classe pelo Full Qualified Name
		String nomeDaClasse = "com.andersonmarques.controllers."+acao;
		Acao classeInstanciada;
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			classeInstanciada = (Acao)classe.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		//Recebe o tipo da operação{ forward ou redirect } e a página jsp.
		String result = classeInstanciada.executar(request, response);
		String[] tipoEJsp = result.split(":");
		
		String operacao = tipoEJsp[0]; 
		String endpoint = tipoEJsp[1];
		
		if(operacao.equals("forward")) {
			RequestDispatcher rD = request.getRequestDispatcher("WEB-INF/view/"+endpoint);
			rD.forward(request, response);
		}else {
			response.sendRedirect(endpoint);
		}
	}
}

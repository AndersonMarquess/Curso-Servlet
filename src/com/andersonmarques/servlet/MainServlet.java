package com.andersonmarques.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		//Instância a classe pelo Full Qualified Name
		String nomeDaClasse = "com.andersonmarques."+acao;
		Acao classeInstanciada;
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			classeInstanciada = (Acao)classe.newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		
		String nome = classeInstanciada.executar(request, response);
		String[] operacao = nome.split(":");
		
		if(operacao[0].equals("forward")) {
			RequestDispatcher rD = request.getRequestDispatcher("WEB-INF/view/" + operacao[1]);
			rD.forward(request, response);
		}
		response.sendRedirect("WEB-INF/view/" + operacao[1]);
	}
}

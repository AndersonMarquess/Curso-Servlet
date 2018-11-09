package com.andersonmarques.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.controllers.Acao;

public class MainFilter implements Filter {

	@Override
	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtro principal");
		
		HttpServletRequest request = (HttpServletRequest) requestServlet; 
		HttpServletResponse response = (HttpServletResponse) responseServlet;
		
		String acao = request.getParameter("acao");
		
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

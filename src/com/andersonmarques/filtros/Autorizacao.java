package com.andersonmarques.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Autorizacao
 */
//@WebFilter("/")
public class Autorizacao implements Filter {

	public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtro de autorização");
		String acao = requestServlet.getParameter("acao");
		
		HttpServletRequest  request = (HttpServletRequest) requestServlet;
		HttpServletResponse response = (HttpServletResponse) responseServlet;

		HttpSession sessao = request.getSession();
		boolean isUsuarioNaoAutenticado = (sessao.getAttribute("usuarioLogado") == null);
		boolean isEndpointProtegido = !(acao.equals("LoginForm") || acao.equals("AutenticarUsuario"));
		if (isUsuarioNaoAutenticado && isEndpointProtegido) {
			response.sendRedirect("?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}
}

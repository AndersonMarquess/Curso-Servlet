package com.andersonmarques.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/")
public class Monitoramento implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Filtro de monitoramento");
		
		//Inicio de um requisi��o
		long inicio = System.currentTimeMillis();

		//Continua a requisi��o
		chain.doFilter(request, response);
		
		//Fim de uma requisi��o
		long fim = System.currentTimeMillis();
		System.out.println("Tempo decorrido: "+(fim-inicio)+" ms, para o endpoint: "+request.getParameter("acao"));
	}
}

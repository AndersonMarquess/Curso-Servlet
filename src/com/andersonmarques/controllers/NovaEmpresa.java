package com.andersonmarques.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/NovaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {
		System.out.println("Fazendo o cadastro de uma nova empresa");
		PrintWriter out = arg1.getWriter();
		
		String nomeEmpresa = arg0.getParameter("nome");
		out.println("Cadastro da empresa: "+nomeEmpresa+" efetuado com sucesso.");
	}
}

package com.andersonmarques.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/NovaEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("Fazendo o cadastro de uma nova empresa");
		String nomeEmpresa = request.getParameter("nome");
		
		Empresa emp = new Empresa();
		emp.setNome(nomeEmpresa);
		
		EmpresaDAO empDAO = new EmpresaDAO();
		empDAO.adicionar(emp);
		
		//Chama a página JSP
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		//atributo de chave valor
		request.setAttribute("nomeEmpresa", emp.getNome());
		rDispatcher.forward(request, response);
	}
	
}

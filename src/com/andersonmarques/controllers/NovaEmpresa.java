package com.andersonmarques.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {
		System.out.println("Fazendo o cadastro de uma nova empresa");
		String nomeEmpresa = arg0.getParameter("nome");
		
		Empresa emp = new Empresa();
		emp.setNome(nomeEmpresa);
		
		EmpresaDAO empDAO = new EmpresaDAO();
		empDAO.adicionar(emp);
	}
	
}

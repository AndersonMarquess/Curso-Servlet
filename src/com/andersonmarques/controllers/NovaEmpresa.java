package com.andersonmarques.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		String dataAbertura = request.getParameter("data");
		
		Empresa emp = new Empresa();
		emp.setNome(nomeEmpresa);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			emp.setDataAbertura(sdf.parse(dataAbertura));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		EmpresaDAO empDAO = new EmpresaDAO();
		empDAO.adicionar(emp);
		
		//Redireciona para o recursos /ListarEmpresas
		response.sendRedirect("ListarEmpresas");
	}
}

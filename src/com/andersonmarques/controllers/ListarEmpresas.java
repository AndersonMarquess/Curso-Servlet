package com.andersonmarques.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;

/**
 * Servlet implementation class ListarEmpresas
 * http://localhost:8080/Curso-Servlet/ListarEmpresas
 */
@WebServlet("/ListarEmpresas")
public class ListarEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		EmpresaDAO empDAO = new EmpresaDAO();
		List<Empresa> empresas = empDAO.getEmpresa();
		
		empresas.forEach(e -> System.out.println(e.getNome()));

		//Chama o JSP
		RequestDispatcher rDispatcher = req.getRequestDispatcher("/listarEmpresas.jsp");
		req.setAttribute("empresas", empresas);
		rDispatcher.forward(req, resp);

	}
}

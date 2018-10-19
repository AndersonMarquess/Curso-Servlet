package com.andersonmarques.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;

/**
 * Servlet implementation class ListarEmpresas
 */
@WebServlet("/ListarEmpresas")
public class ListarEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		EmpresaDAO empDAO = new EmpresaDAO();
		List<Empresa> empresas = empDAO.getEmpresa();

		PrintWriter writer = resp.getWriter();

		empresas.forEach(e -> writer.println("=> " + e.getNome()));

	}
}

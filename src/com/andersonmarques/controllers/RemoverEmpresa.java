package com.andersonmarques.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;

@WebServlet(urlPatterns="/remover")
public class RemoverEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmpresaDAO empDAO = new EmpresaDAO();
		empDAO.removerEmpresaComId(id);
		
		resp.sendRedirect("ListarEmpresas");
	}
}

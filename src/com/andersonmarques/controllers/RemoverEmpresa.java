package com.andersonmarques.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;

@WebServlet(urlPatterns="/remover")
public class RemoverEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		
		EmpresaDAO empDAO = new EmpresaDAO();
		List<Empresa> empresas = empDAO.getEmpresa();

		System.out.println("Tamnho da lista: "+empresas.size());
		empresas.removeIf(e -> e.getId().equals(id));
		System.out.println("Tamnho da lista: "+empresas.size());
		
		resp.sendRedirect("ListarEmpresas");
	}
}

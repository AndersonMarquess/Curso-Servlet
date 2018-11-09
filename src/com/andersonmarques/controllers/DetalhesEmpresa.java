package com.andersonmarques.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;

public class DetalhesEmpresa implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		EmpresaDAO dao = new EmpresaDAO();

		request.setAttribute("empresa", dao.findEmpresaById(id));
		return "forward:formEditarEmpresa.jsp";
	}
}

package com.andersonmarques.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.servlet.Acao;

@WebServlet(urlPatterns="/remover")
public class RemoverEmpresa implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		EmpresaDAO empDAO = new EmpresaDAO();
		empDAO.removerEmpresaComId(id);
		
		return ":?acao=ListarEmpresas";
	}
}

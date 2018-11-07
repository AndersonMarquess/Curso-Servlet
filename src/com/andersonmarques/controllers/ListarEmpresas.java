package com.andersonmarques.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;
import com.andersonmarques.servlet.Acao;

public class ListarEmpresas implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpresaDAO empDAO = new EmpresaDAO();
		List<Empresa> empresas = empDAO.getEmpresa();
		
		empresas.forEach(e -> System.out.println(e.getNome()));
		request.setAttribute("empresas", empresas);
		
		return "forward:listarEmpresas.jsp";
	}
}

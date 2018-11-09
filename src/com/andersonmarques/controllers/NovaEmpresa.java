package com.andersonmarques.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;

public class NovaEmpresa implements Acao {
	
	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
		
		return "redirect:?acao=ListarEmpresas";
	}
}

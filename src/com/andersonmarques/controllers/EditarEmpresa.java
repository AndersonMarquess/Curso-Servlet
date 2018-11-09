package com.andersonmarques.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;

public class EditarEmpresa implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		
		Empresa emp = new Empresa();
		emp.setId(id);
		emp.setNome(nome);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataFormatada = sdf.parse(data);
			emp.setDataAbertura(dataFormatada);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EmpresaDAO dao = new EmpresaDAO();
		dao.atualizar(emp);

		return ":?acao=ListarEmpresas";
	}
}

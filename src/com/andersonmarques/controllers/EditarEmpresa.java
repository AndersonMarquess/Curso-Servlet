package com.andersonmarques.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;

@WebServlet("/editar")
public class EditarEmpresa extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmpresaDAO dao = new EmpresaDAO();
		
		req.setAttribute("empresa", dao.findEmpresaById(id));
		RequestDispatcher rd = req.getRequestDispatcher("/formEditarEmpresa.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String data = req.getParameter("data");
		
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

		resp.sendRedirect("ListarEmpresas");
	}
}

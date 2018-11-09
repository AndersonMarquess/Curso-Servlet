package com.andersonmarques.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.DAO.EmpresaDAO;
import com.andersonmarques.models.Empresa;
import com.google.gson.Gson;

@WebServlet("/empresas")
public class EmpresasServiceJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Empresa> empresas = new EmpresaDAO().getEmpresa();
		
		//Responde com um JSON
		Gson gson = new Gson();
		String empresasJSON = gson.toJson(empresas);
		
		resp.setContentType("application/json");
		resp.getWriter().println(empresasJSON);
	}
}

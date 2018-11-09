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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Servlet implementation class EmpresaServiceXML
 */
@WebServlet("/empresasXML")
public class EmpresasServiceXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Empresa> empresas = new EmpresaDAO().getEmpresa();
		
		//Responde com um XML
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("empresa", Empresa.class);
		String empresasXML = xstream.toXML(empresas);
		
		resp.setContentType("application/xml");
		resp.getWriter().print(empresasXML);
	}
}

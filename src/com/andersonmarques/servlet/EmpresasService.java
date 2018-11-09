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
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Empresa> empresas = new EmpresaDAO().getEmpresa();

		String tipoAceito = req.getHeader("Accept");

		// Responde com um JSON
		if (tipoAceito.contains("json")) {
			Gson gson = new Gson();
			String empresasJSON = gson.toJson(empresas);

			resp.setContentType("application/json");
			resp.getWriter().println(empresasJSON);
			
		} else if (tipoAceito.contains("xml")) {
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("empresa", Empresa.class);
			String empresasXML = xstream.toXML(empresas);

			resp.setContentType("application/xml");
			resp.getWriter().println(empresasXML);
			
		} else {
			resp.getWriter().println("{'message':'Especifique o tipo aceito entre JSON ou XML'}");
		}
	}
}

package com.andersonmarques.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Mapeamento duplo
@WebServlet(urlPatterns= {"/oi", "/ola"})
public class OiMundo extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Olá mundo");
	}
}

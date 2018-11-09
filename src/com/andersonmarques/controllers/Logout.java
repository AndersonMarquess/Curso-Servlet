package com.andersonmarques.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		//Remove a sess�o e inv�lida o cookie
		sessao.invalidate();

		return "redirect:?acao=LoginForm";
	}

}

package com.andersonmarques.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonmarques.servlet.Acao;

public class LoginForm implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Recebido: "+login+" "+senha);
		
		return "forward:formLogin.jsp";
	}

}

package com.andersonmarques.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andersonmarques.DAO.UsuarioDAO;
import com.andersonmarques.models.Usuario;
import com.andersonmarques.servlet.Acao;

public class AutenticarUsuario implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Recebido: "+login+" "+senha);

		UsuarioDAO dao = new UsuarioDAO();
		Optional<Usuario> usuario = dao.findUsuarioByCredenciais(login, senha);
		
		if(!usuario.isPresent()) {
			request.setAttribute("erroLogin", "Usuário inválido.");
			return "forward:formLogin.jsp";
		}
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogado", usuario.get());
		
		return "redirect:?acao=ListarEmpresas";
	}
}
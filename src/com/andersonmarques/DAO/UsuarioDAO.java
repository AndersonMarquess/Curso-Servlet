package com.andersonmarques.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.andersonmarques.models.Usuario;

public class UsuarioDAO {

	private static List<Usuario> usuarios = new ArrayList<>();
	
	static {
		Usuario u1 = new Usuario("admin", "1234");
		Usuario u2 = new Usuario("abc", "abc");
		
		usuarios.add(u1);
		usuarios.add(u2);
	}

	public Optional<Usuario> findUsuarioByCredenciais(String login, String senha) {
		return usuarios.stream().filter(u -> u.isValido(login, senha)).findFirst();
	}
}

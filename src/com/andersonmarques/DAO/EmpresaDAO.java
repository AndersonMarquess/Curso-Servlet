package com.andersonmarques.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.andersonmarques.models.Empresa;

public class EmpresaDAO {
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	//É inicializado automaticamente no carregamento da classe
	static {
		Empresa e1 = new Empresa();
//		e1.setId(1);
		e1.setNome("Empresa 001");
		e1.setDataAbertura(new Date());
		Empresa e2 = new Empresa();
//		e2.setId(2);
		e2.setNome("Empresa 002");
		e2.setDataAbertura(new Date());
		empresas.addAll(Arrays.asList(e1, e2));
	}
	

	public void adicionar(Empresa emp) {
		empresas.add(emp);
	}
	
	public List<Empresa> getEmpresa(){
		return EmpresaDAO.empresas;
	}

}

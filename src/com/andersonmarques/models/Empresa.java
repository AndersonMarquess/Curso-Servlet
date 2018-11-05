package com.andersonmarques.models;

import java.util.Date;

public class Empresa {
	
	private static int index;
	
	private Integer id;
	private String nome;
	private Date dataAbertura;
	
	public Empresa() {
		id = index++;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
}
package com.aula.model;

public class Livro {
	
	private int id;
	private String nome;
	private String edicao;
	private double valor;
	
	public Livro() {
		
	}

	public Livro(String nome, String edicao, double valor) {
		this.nome = nome;
		this.edicao = edicao;
		this.valor = valor;
	}
	
	public Livro(int id, String nome, String edicao, double valor) {
		this.id = id;
		this.nome = nome;
		this.edicao = edicao;
		this.valor = valor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
	
}

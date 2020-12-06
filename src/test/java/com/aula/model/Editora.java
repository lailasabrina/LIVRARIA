package com.aula.model;

public class Editora {
	
	private int idEdit;
	private String nomeEdit;
	private String telefone;
	private String emailEdit;
	
	public Editora () {
		
	}

	public Editora(String nomeEdit, String telefone, String emailEdit) {
		this.nomeEdit = nomeEdit;
		this.telefone = telefone;
		this.emailEdit = emailEdit;
	}
	
	
	public Editora(int idEdit, String nomeEdit, String telefone, String emailEdit) {
		this.idEdit = idEdit;
		this.nomeEdit = nomeEdit;
		this.telefone = telefone;
		this.emailEdit = emailEdit;
	}

	public String getNomeEdit() {
		return nomeEdit;
	}

	public void setNomeEdit(String nomeEdit) {
		this.nomeEdit = nomeEdit;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmailEdit() {
		return emailEdit;
	}

	public void setEmailEdit(String emailEdit) {
		this.emailEdit = emailEdit;
	}

	public int getIdEdit() {
		return idEdit;
	}
	
	
	
	
}

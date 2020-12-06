package com.aula.model;

public class Autor {

	private int idAut; 
	private String nomeAut;
	private String emailAut;
	
	public Autor() {
		
	}

	public Autor(String nomeAut, String emailAut) {
		this.nomeAut = nomeAut;
		this.emailAut = emailAut;
	}
	
	public Autor(int idAut, String nomeAut, String emailAut) {
		this.idAut = idAut;
		this.nomeAut = nomeAut;
		this.emailAut = emailAut;
	}

	public String getNomeAut() {
		return nomeAut;
	}

	public void setNomeAut(String nomeAut) {
		this.nomeAut = nomeAut;
	}

	public String getEmailAut() {
		return emailAut;
	}

	public void setEmailAut(String emailAut) {
		this.emailAut = emailAut;
	}

	public int getIdAut() {
		return idAut;
	}
	
	
	
	
}

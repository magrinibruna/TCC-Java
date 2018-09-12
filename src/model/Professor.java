package model;

import java.sql.Date;

public class Professor {
	
	int idProfessor;
	String nomeProfessor;
String sobrenomeProfessor;
	String cpfProfessor;
	String emailProfessor;
	int statusProfessor;
	Date cadastroProfessor;
	
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public String getCpfProfessor() {
		return cpfProfessor;
	}
	public void setCpfProfessor(String cpfProfessor) {
		this.cpfProfessor = cpfProfessor;
	}
	public String getEmailProfessor() {
		return emailProfessor;
	}
	public void setEmailProfessor(String emailProfessor) {
		this.emailProfessor = emailProfessor;
	}
	public int getStatusProfessor() {
		return statusProfessor;
	}
	public void setStatusProfessor(int statusProfessor) {
		this.statusProfessor = statusProfessor;
	}
	public Date getCadastroProfessor() {
		return cadastroProfessor;
	}
	public void setCadastroProfessor(Date cadastroProfessor) {
		this.cadastroProfessor = cadastroProfessor;
	}
	
	public String getSobrenomeProfessor() {
		return sobrenomeProfessor;
	}
	public void setSobrenomeProfessor(String sobrenomeProfessor) {
		this.sobrenomeProfessor = sobrenomeProfessor;
	}

	public String toString() {
		return  nomeProfessor + " " + sobrenomeProfessor;
	}

}

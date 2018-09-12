package model;

import java.sql.Date;

public class Aluno {
	
	int rmAluno;
	String nomeAluno;
	String sobrenomeAluno;
	String cpfAluno;
	Date nascimentoAluno;
	int turmaAluno;
	String emailAluno;
	String anoAluno;
	int statusAluno;
	Date exclusaoAluno;
	String caminhoFoto;
	
	//Usadas para consulta de tabela
	String turmaString;
	String statusString;
	
	public String getTurmaString() {
		return turmaString;
	}
	public void setTurmaString(String turmaString) {
		this.turmaString = turmaString;
	}
	public String getStatusString() {
		return statusString;
	}
	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	public int getRmAluno() {
		return rmAluno;
	}
	public void setRmAluno(int rmAluno) {
		this.rmAluno = rmAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getCpfAluno() {
		return cpfAluno;
	}
	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
	public Date getNascimentoAluno() {
		return nascimentoAluno;
	}
	public void setNascimentoAluno(Date nascimentoAluno) {
		this.nascimentoAluno = nascimentoAluno;
	}
	public int getTurmaAluno() {
		return turmaAluno;
	}
	public void setTurmaAluno(int turmaAluno) {
		this.turmaAluno = turmaAluno;
	}
	public String getEmailAluno() {
		return emailAluno;
	}
	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	public String getAnoAluno() {
		return anoAluno;
	}
	public void setAnoAluno(String anoAluno) {
		this.anoAluno = anoAluno;
	}
	
	public int getStatusAluno() {
		return statusAluno;
	}
	public void setStatusAluno(int statusAluno) {
		this.statusAluno = statusAluno;
	}
	public Date getExclusaoAluno() {
		return exclusaoAluno;
	}
	public void setExclusaoAluno(Date exclusaoAluno) {
		this.exclusaoAluno = exclusaoAluno;
	}
	
	public String getSobrenomeAluno() {
		return sobrenomeAluno;
	}
	public void setSobrenomeAluno(String sobrenomeAluno) {
		this.sobrenomeAluno = sobrenomeAluno;
	}
	public String getCaminhoFoto() {
		return caminhoFoto;
	}
	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	
	public String toString() {
		return String.valueOf(rmAluno) + " - " +  nomeAluno + " " + sobrenomeAluno;		
	}
	
	
	
}

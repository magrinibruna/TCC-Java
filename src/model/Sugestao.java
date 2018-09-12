package model;

import java.sql.Date;

public class Sugestao {
	
	int idSugestao;
	int fkSugestao;
	String alunoSugestao;
	Date dataSugestao;
	String mensagemSugestao;
	
	public String getAlunoSugestao() {
		return alunoSugestao;
	}
	public void setAlunoSugestao(String alunoSugestao) {
		this.alunoSugestao = alunoSugestao;
	}
	
	
	public int getIdSugestao() {
		return idSugestao;
	}
	public void setIdSugestao(int idSugestao) {
		this.idSugestao = idSugestao;
	}
	public int getFkSugestao() {
		return fkSugestao;
	}
	public void setFkSugestao(int fkSugestao) {
		this.fkSugestao = fkSugestao;
	}
	public Date getDataSugestao() {
		return dataSugestao;
	}
	public void setDataSugestao(Date dataSugestao) {
		this.dataSugestao = dataSugestao;
	}
	public String getMensagemSugestao() {
		return mensagemSugestao;
	}
	public void setMensagemSugestao(String mensagemSugestao) {
		this.mensagemSugestao = mensagemSugestao;
	}
	

}

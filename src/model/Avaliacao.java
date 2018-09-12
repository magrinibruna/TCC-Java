package model;

import java.sql.Date;

public class Avaliacao {
	
	int id_Avaliacao;
	Date ano;
	String nomeAvaliacao;
	int pesoAvaliacao;
	
	public int getId_Avaliacao() {
		return id_Avaliacao;
	}
	public void setId_Avaliacao(int id_Avaliacao) {
		this.id_Avaliacao = id_Avaliacao;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
	}
	public String getNomeAvaliacao() {
		return nomeAvaliacao;
	}
	public void setNomeAvaliacao(String nomeAvaliacao) {
		this.nomeAvaliacao = nomeAvaliacao;
	}
	public int getPesoAvaliacao() {
		return pesoAvaliacao;
	}
	public void setPesoAvaliacao(int pesoAvaliacao) {
		this.pesoAvaliacao = pesoAvaliacao;
	}
	

}

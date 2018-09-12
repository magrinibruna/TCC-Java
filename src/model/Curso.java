package model;

import java.sql.Date;

public class Curso {

	int idCurso;
	String nomeCurso;
	String abreviaturaCurso;
	int AICurso;
	Date exclusaoCurso;
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getAbreviaturaCurso() {
		return abreviaturaCurso;
	}
	public void setAbreviaturaCurso(String abreviaturaCurso) {
		this.abreviaturaCurso = abreviaturaCurso;
	}
	public int getAICurso() {
		return AICurso;
	}
	public void setAICurso(int aICurso) {
		AICurso = aICurso;
	}
	public Date getExclusaoCurso() {
		return exclusaoCurso;
	}
	public void setExclusaoCurso(Date exclusaoCurso) {
		this.exclusaoCurso = exclusaoCurso;
	}
	@Override
	public String toString() {
		return  nomeCurso;
	}
	
	

	
}

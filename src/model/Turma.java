package model;

public class Turma {
	
	int idTurma;
	int idCurso;
	String anoTurma;
	String nomeTurma;
	String periodoTurma;
	String anoLetivoTurma;
	String completoTurma;
	
	String nomeCurso;
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getAnoTurma() {
		return anoTurma;
	}
	public void setAnoTurma(String anoTurma) {
		this.anoTurma = anoTurma;
	}
	public String getNomeTurma() {
		return nomeTurma;
	}
	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
	public String getPeriodoTurma() {
		return periodoTurma;
	}
	public void setPeriodoTurma(String periodoTurma) {
		this.periodoTurma = periodoTurma;
	}
	public String getAnoLetivoTurma() {
		return anoLetivoTurma;
	}
	public void setAnoLetivoTurma(String anoLetivoTurma) {
		this.anoLetivoTurma = anoLetivoTurma;
	}
	public String getCompletoTurma() {
		return completoTurma;
	}
	public void setCompletoTurma(String completoTurma) {
		this.completoTurma = completoTurma;
	}
	
	@Override
	public String toString() {
		return  completoTurma;
	}
	

	


	
	

}

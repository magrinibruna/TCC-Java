package model;


public class Disciplina {
	
	int idDisciplina;
	String idAno;
	String nomeDisciplina;
	int serieDisciplina;
	int cursoDisciplina;

	String nomeSerie;
	String nomeCurso;

	
	public String getNomeSerie() {
		return nomeSerie;
	}
	public void setNomeSerie(String nomeSerie) {
		this.nomeSerie = nomeSerie;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public int getCursoDisciplina() {
		return cursoDisciplina;
	}
	public void setCursoDisciplina(int cursoDisciplina) {
		this.cursoDisciplina = cursoDisciplina;
	}
	
	public int getIdDisciplina() {
		return idDisciplina;
	}
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public String getIdAno() {
		return idAno;
	}
	public void setIdAno(String idAno) {
		this.idAno = idAno;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public int getSerieDisciplina() {
		return serieDisciplina;
	}
	public void setSerieDisciplina(int serieDisciplina) {
		this.serieDisciplina = serieDisciplina;
	}

	public String toString() {
		return  nomeDisciplina + " - " + serieDisciplina + "º ano";
	}
	

}

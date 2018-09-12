package model;

public class Ranking {
	
	private String trimestre;
	private String turma;
	private double notas;
	
	public String getTrimestre() {
		return trimestre;
	}
	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public double getNotas() {
		return notas;
	}
	public void setNotas(double notas) {
		this.notas = notas;
	}	
	
	public String toString() {
		return trimestre + " " +  turma + " " + String.valueOf(notas);		
	}

}

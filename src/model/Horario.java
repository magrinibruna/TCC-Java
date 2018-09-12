package model;

public class Horario {
	
	private int id_Horario;
	private int id_Turma;
	private String caminhoHorario;
	private String status;
	public int getId_Horario() {
		return id_Horario;
	}
	public void setId_Horario(int id_Horario) {
		this.id_Horario = id_Horario;
	}
	public int getId_Turma() {
		return id_Turma;
	}
	public void setId_Turma(int id_Turma) {
		this.id_Turma = id_Turma;
	}
	public String getCaminhoHorario() {
		return caminhoHorario;
	}
	public void setCaminhoHorario(String caminhoHorario) {
		this.caminhoHorario = caminhoHorario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}

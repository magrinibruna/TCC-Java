package model;

import java.sql.Date;

public class Mensagem {
	
	int idMensagem;
	int EnviaMensagem_Aluno;
	int EnviaMensagem_Professor;
	int RecebeMensagem_Aluno;
	int RecebeMensagem_Turma;
	int RecebeMensagem_Professor;
	Date DataMensagem;
	String AssuntoMensagem;
	String DescricaoMensagem;
	
	
	
	public int getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}
	public int getEnviaMensagem_Aluno() {
		return EnviaMensagem_Aluno;
	}
	public void setEnviaMensagem_Aluno(int enviaMensagem_Aluno) {
		EnviaMensagem_Aluno = enviaMensagem_Aluno;
	}
	public int getEnviaMensagem_Professor() {
		return EnviaMensagem_Professor;
	}
	public void setEnviaMensagem_Professor(int enviaMensagem_Professor) {
		EnviaMensagem_Professor = enviaMensagem_Professor;
	}
	public int getRecebeMensagem_Aluno() {
		return RecebeMensagem_Aluno;
	}
	public void setRecebeMensagem_Aluno(int recebeMensagem_Aluno) {
		RecebeMensagem_Aluno = recebeMensagem_Aluno;
	}
	public int getRecebeMensagem_Turma() {
		return RecebeMensagem_Turma;
	}
	public void setRecebeMensagem_Turma(int recebeMensagem_Turma) {
		RecebeMensagem_Turma = recebeMensagem_Turma;
	}
	public int getRecebeMensagem_Professor() {
		return RecebeMensagem_Professor;
	}
	public void setRecebeMensagem_Professor(int recebeMensagem_Professor) {
		RecebeMensagem_Professor = recebeMensagem_Professor;
	}
	public Date getDataMensagem() {
		return DataMensagem;
	}
	public void setDataMensagem(Date dataMensagem) {
		DataMensagem = dataMensagem;
	}
	public String getAssuntoMensagem() {
		return AssuntoMensagem;
	}
	public void setAssuntoMensagem(String assuntoMensagem) {
		AssuntoMensagem = assuntoMensagem;
	}
	public String getDescricaoMensagem() {
		return DescricaoMensagem;
	}
	public void setDescricaoMensagem(String descricaoMensagem) {
		DescricaoMensagem = descricaoMensagem;
	}
	
	
}

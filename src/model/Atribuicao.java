package model;

public class Atribuicao {

	int id_Atrib;
	int id_Prof;
	int id_disc;
	String nome;
	int id_Ano;
	int StatusAtrib;
	
	String nomeProfessor;
	String nomeDisciplina;
	String ano;
	
	
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId_Atrib() {
		return id_Atrib;
	}
	public void setId_Atrib(int id_Atrib) {
		this.id_Atrib = id_Atrib;
	}
	public int getId_Prof() {
		return id_Prof;
	}
	public void setId_Prof(int id_Prof) {
		this.id_Prof = id_Prof;
	}
	public int getId_disc() {
		return id_disc;
	}
	public void setId_disc(int id_disc) {
		this.id_disc = id_disc;
	}
	public int getId_Ano() {
		return id_Ano;
	}
	public void setId_Ano(int id_Ano) {
		this.id_Ano = id_Ano;
	}
	public int getStatusAtrib() {
		return StatusAtrib;
	}
	public void setStatusAtrib(int statusAtrib) {
		StatusAtrib = statusAtrib;
	}
	
	@Override
	public String toString() {
		return  nome;
	}


}

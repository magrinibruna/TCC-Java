package model;

public class Nota {

	int id_Nota;
	int id_Aluno;
	String nomeAluno;
	int id_Atrib;
	int id_Aval;
	int Trim;
	int Falta;
	double Nota;

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getId_Nota() {
		return id_Nota;
	}

	public void setId_Nota(int id_Nota) {
		this.id_Nota = id_Nota;
	}

	public int getId_Aluno() {
		return id_Aluno;
	}

	public void setId_Aluno(int id_Aluno) {
		this.id_Aluno = id_Aluno;
	}

	public int getId_Atrib() {
		return id_Atrib;
	}

	public void setId_Atrib(int id_Atrib) {
		this.id_Atrib = id_Atrib;
	}

	public int getId_Aval() {
		return id_Aval;
	}

	public void setId_Aval(int id_Aval) {
		this.id_Aval = id_Aval;
	}

	public int getTrim() {
		return Trim;
	}

	public void setTrim(int trim) {
		Trim = trim;
	}

	public int getFalta() {
		return Falta;
	}

	public void setFalta(int falta) {
		Falta = falta;
	}

	public double getNota() {
		return Nota;
	}

	public void setNota(double nota) {
		Nota = nota;
	}

	public String toString() {
		return String.valueOf(id_Nota) + " " + String.valueOf(Nota);

	}
}

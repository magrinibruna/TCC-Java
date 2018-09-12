package tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Aluno;
import model.Professor;

public class ProfessorTableModel extends AbstractTableModel {

	private List<Professor> dados;

	public ProfessorTableModel(List<Professor> listaProfessor) {
		dados = listaProfessor;
	}

	public int getColumnCount() {
		return 6;
	}

	public int getRowCount() {
		return dados.size();
	}

	public String getColumnName(int numCol) {
		String coluna = "";

		switch (numCol) {
		case 0:
			coluna = "Código";
			break;
		case 1:
			coluna = "Nome";
			break;
		case 2:
			coluna = "Sobrenome";
			break;
		case 3:
			coluna = "CPF";
			break;
		case 4:
			coluna = "Email";
			break;
		case 5:
			coluna = "Status";
			break;
		default:
			coluna = "Coluna inválida";
		}

		return coluna;
	}

	public Object getValueAt(int numLin, int numCol) {
		Object valor = null;

		model.Professor objProfessor = dados.get(numLin);

		switch (numCol) {
		case 0:
			valor = objProfessor.getIdProfessor();
			break;
		case 1:
			valor = objProfessor.getNomeProfessor();
			break;
		case 2:
			valor = objProfessor.getSobrenomeProfessor();
			break;
		case 3:
			valor = objProfessor.getCpfProfessor();
			break;
		case 4:
			valor = objProfessor.getEmailProfessor();
			break;
		case 5:
			valor = objProfessor.getStatusProfessor();
			break;
		default:
			valor = "Valor invalido";
		}
		
		return valor;
	}

}

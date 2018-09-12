package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Turma;

public class TurmaTableModel extends AbstractTableModel {

	private List<Turma> dados;

	public TurmaTableModel(List<Turma> listTurma) {
		dados = listTurma;
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
			coluna = "Curso";
			break;
		case 2: 
			coluna = "Ano";
			break;
		case 3:
			coluna = "Periodo";
			break;
		case 4:
			coluna = "Ano Letivo";
			break;
		case 5:
			coluna = "Turma";
			break;
		default:
			coluna = "Coluna invalida";
		}
		
		return coluna;
	}
	
	public Object getValueAt(int numLin, int numCol) {
		
		model.Turma objTurma = dados.get(numLin);
		
		Object valor = null;
		
		switch(numCol) {
		case 0: 
			valor = objTurma.getIdTurma();
			break;
		case 1:
			valor = objTurma.getNomeCurso();
			break;
		case 2: 
			valor = objTurma.getAnoTurma();
			break;
		case 3:
			valor = objTurma.getPeriodoTurma();
			break;
		case 4:
			valor = objTurma.getAnoLetivoTurma();
			break;
		case 5:
			valor = objTurma.getCompletoTurma();
			break;
		default:
			valor = "Valor inválido";
		}
		
		return valor;
	}

}

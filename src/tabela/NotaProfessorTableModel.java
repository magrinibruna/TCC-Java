package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ProcNota;

public class NotaProfessorTableModel  extends AbstractTableModel {
	
	private List<ProcNota> dados;
	
	public NotaProfessorTableModel(List<ProcNota> listNota) {
		dados = listNota;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public int getRowCount() {
		return dados.size();
	}
	
	public String getColumnName(int numCol) {
		String coluna = "";

		switch (numCol) {
		case 0:
			coluna = "RM";
			break;
		case 1:
			coluna = "Aluno";
			break;
		case 2:
			coluna = "Avaliação";
			break;
		case 3:
			coluna = "Nota";
			break;
		default:
			coluna = "Coluna inválida";
		}

		return coluna;
	}
	
	public Object getValueAt(int numLin, int numCol) {
		Object valor = null;
		
		model.ProcNota objNota = dados.get(numLin);
		
		switch (numCol) {
		case 0:
			valor = objNota.getRm();
			break;
		case 1:
			valor = objNota.getNomeAluno();
			break;
		case 2:
			valor = objNota.getAvaliacao();
			break;
		case 3:
			valor = objNota.getNota();
			break;
		default:
			valor = "Valor invalido";
		}
		
		return valor;
	}
	

}

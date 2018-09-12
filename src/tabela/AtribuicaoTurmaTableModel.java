package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.AtribuicaoTurma;


public class AtribuicaoTurmaTableModel extends AbstractTableModel {
	
	private List<AtribuicaoTurma> dados;
	
	public AtribuicaoTurmaTableModel (List<AtribuicaoTurma> listAtribuicaoTurma) {
		dados = listAtribuicaoTurma;
	}
	
	public int getColumnCount() {
		return 3;
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
			coluna = "Turma";
			break;
		default:
			coluna = "Coluna";
		}

		return coluna;

	}
	
	public Object getValueAt(int numLin, int numCol) {

		model.AtribuicaoTurma objAtribuicaoTurma = dados.get(numLin);

		Object valor = null;

		switch (numCol) {
		case 0:
			valor = objAtribuicaoTurma.getId_AtribTurma();
			break;
		case 1:
			valor = objAtribuicaoTurma.getNome();
			break;
		case 2:
			valor = objAtribuicaoTurma.getTurma();
			break;
		default:
			valor = "Valor invalido";
		}

		return valor;
	}

}

package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ProcNota;

public class Nota2TableModel extends AbstractTableModel {

	private List<ProcNota> dados;

	public Nota2TableModel(List<ProcNota> listNota) {
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
			coluna = "Ano";
			break;
		case 1:
			coluna = "Trimestre";
			break;
		case 2:
			coluna = "Matéria";
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
			valor = objNota.getAno();
			break;
		case 1:
			valor = objNota.getTrimestre();
			break;
		case 2:
			valor = objNota.getMateria();
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

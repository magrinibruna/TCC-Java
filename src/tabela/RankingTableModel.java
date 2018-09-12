package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ranking;

public class RankingTableModel extends AbstractTableModel 	{
	
private List<Ranking> dados;
	
	public RankingTableModel(List<Ranking> listRanking) {
		dados = listRanking;
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
			coluna = "Trimestre";
			break;
		case 1:
			coluna = "Turma";
			break;
		case 2:
			coluna = "Notas";
			break;
		default:
			coluna = "Coluna inválida";
		}
		
		return coluna;
	}
	
	public Object getValueAt(int numLin, int numCol) {
		Object valor = null;
		
		model.Ranking objRanking = dados.get(numLin);
		
		switch (numCol) {
		case 0:
			valor = objRanking.getTrimestre();
			break;
		case 1:
			valor = objRanking.getTurma();
			break;
		case 2:
			valor = objRanking.getNotas();
			break;
		default:
			valor = "Valor invalido";
		}
		
		return valor;
	}
	

}

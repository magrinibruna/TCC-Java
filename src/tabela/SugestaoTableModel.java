package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Sugestao;

public class SugestaoTableModel extends AbstractTableModel {
	
	private List<Sugestao> dados;

	public SugestaoTableModel(List<Sugestao> listSugestao) {
		dados = listSugestao;
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
			coluna = "Código";
			break;
		case 1:
			coluna = "Aluno";
			break;
		case 2:
			coluna = "Data";
			break;
		case 3:
			coluna = "Sugestão";
			break;
		default:
			coluna = "Coluna inválida";
		}

		return coluna;
	}
	
	public Object getValueAt(int numLin, int numCol) {
		Object valor = null;
		
		model.Sugestao objSugestao = dados.get(numLin);
		
		switch (numCol) {
		case 0:
			valor = objSugestao.getIdSugestao();
			break;
		case 1:
			valor = objSugestao.getAlunoSugestao();
			break;
		case 2:
			valor = objSugestao.getDataSugestao();
			break;
		case 3:
			valor = objSugestao.getMensagemSugestao();
			break;
		default:
			valor = "Valor invalido";
		}
		
		return valor;
		
	}
	
	

}

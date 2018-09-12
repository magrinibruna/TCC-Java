package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Atribuicao;

public class AtribuicaoTableModel extends AbstractTableModel {

	private List<Atribuicao> dados;

	public AtribuicaoTableModel(List<Atribuicao> listAtribuicao) {
		dados = listAtribuicao;
	}

	public int getColumnCount() {
		return 5;
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
			coluna = "Professor";
			break;
		case 2:
			coluna = "Disciplina";
			break;
		case 3:
			coluna = "Nome";
			break;
		case 4:
			coluna = "Ano";
			break;
		default:
			coluna = "Coluna";
		}

		return coluna;

	}

	public Object getValueAt(int numLin, int numCol) {
		
		Object valor = null;
		
		model.Atribuicao objAtribuicao = dados.get(numLin);
		
		switch(numCol) {
		case 0:
			valor = objAtribuicao.getId_Atrib();
			break;
		case 1: 
			valor = objAtribuicao.getNomeProfessor();
			break;
		case 2:
			valor = objAtribuicao.getNomeDisciplina();
			break;
		case 3:
			valor = objAtribuicao.getNome();
			break;
		case 4: 
			valor = objAtribuicao.getAno();
			break;
		default: 
			valor = "Valor invalido";
		}
		
		return valor;
		
	}

}

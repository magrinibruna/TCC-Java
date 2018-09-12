package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Curso;

public class CursoTableModel extends AbstractTableModel {
	
	private List<Curso> dados;
	
	public CursoTableModel(List<Curso> listCurso) {
		dados = listCurso;
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
			coluna = "Abreviatura";
			break;
		default:
			coluna = "Coluna inválida";
		}
		
		return coluna;
	}
	
	public Object getValueAt(int numLin, int numCol) {
		Object valor = null;
		
		model.Curso objCurso = dados.get(numLin);
		
		switch (numCol) {
		case 0:
			valor = objCurso.getIdCurso();
			break;
		case 1:
			valor = objCurso.getNomeCurso();
			break;
		case 2:
			valor = objCurso.getAbreviaturaCurso();
			break;
		default:
			valor = "Valor invalido";
		}
		
		return valor;
	}
	

}

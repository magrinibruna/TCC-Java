package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Disciplina;

public class DisciplinaTableModel extends AbstractTableModel {
	
	private List<Disciplina> dados;
	
	public DisciplinaTableModel(List<Disciplina> listDisciplina) {
		dados = listDisciplina;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public int getRowCount() {
		return dados.size();
	}
	
	public String getColumnName(int numCol) {
		String coluna = "";
		
		switch(numCol) {
		case 0:
			coluna = "Código";
			break;
		case 1:
			coluna = "Nome";
			break;
		case 2:
			coluna = "Série";
			break;
		case 3:
			coluna = "Curso";
			break;
		case 4:
			coluna = "Ano Letivo";
			break;
		default:
			coluna = "Coluna inválida";
		}
		
		return coluna;
	}   
	
	public Object getValueAt(int numLin, int numCol) {
		model.Disciplina objDisciplina = dados.get(numLin);
		Object valor = null;
		
		switch(numCol) {
		case 0:
			valor = objDisciplina.getIdDisciplina();
			break;
		case 1:
			valor = objDisciplina.getNomeDisciplina();
			break;
		case 2:
			valor = objDisciplina.getNomeSerie();
			break;
		case 3:
			valor = objDisciplina.getNomeCurso();
			break;
		case 4:
			valor = objDisciplina.getIdAno();
			break;
		default:
			valor = "Valor inválido";
			
		}
		
		return valor;
	}
	

}

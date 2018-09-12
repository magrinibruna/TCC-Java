package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Evento;

public class EventoTableModel extends AbstractTableModel {
	
	private List<Evento> dados;
	
	public EventoTableModel(List<Evento> listEvento) {
		dados = listEvento;
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
			coluna = "Título";
			break;
		case 2:
			coluna = "Descrição";
			break;
		case 3:
			coluna = "Data";
			break;
		default:
			coluna = "Coluna";
		}

		return coluna;
	}
	
	public Object getValueAt(int numLin, int numCol) {
		
		Object valor = null;
		
		model.Evento objEvento = dados.get(numLin);
		
		switch(numCol) {
		case 0:
			valor = objEvento.getIdEvento();
			break;
		case 1:
			valor = objEvento.getTituloEvento();
			break;
		case 2: 
			valor = objEvento.getDescricaoEvento();
			break;
		case 3:
			valor = objEvento.getDataEvento();
			break;
		default: 
			valor = "Valor invalido";
		}
		
		return valor;
		
	}

}

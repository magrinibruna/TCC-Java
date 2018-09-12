package tabela;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ProcMensagem;

public class MensagemTableModel extends AbstractTableModel {
	
	private List<ProcMensagem> dados;
	
	public MensagemTableModel(List<ProcMensagem> listMensagem) {
		dados = listMensagem;
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
			coluna = "Enviado(Código)";
			break;
		case 1:
			coluna = "Enviado(Nome)";
			break;
		case 2:
			coluna = "Data";
			break;
		case 3:
			coluna = "Assunto";
			break;
		case 4:
			coluna = "Descrição";
			break;
		default:
			coluna = "Coluna inválida";
		}
		
		return coluna;
		
	}
	
	public Object getValueAt(int numLin, int numCol) {
		Object valor = null;
		
		model.ProcMensagem objMensagem = dados.get(numLin);
		
		switch (numCol) {
		case 0:
			valor = objMensagem.getEnvio();
			break;
		case 1:
			valor = objMensagem.getEnvia();
			break;
		case 2:
			valor = objMensagem.getData();
			break;
		case 3:
			valor = objMensagem.getAssunto();
			break;
		case 4:
			valor = objMensagem.getDescricao();
			break;
		default:
			valor = "Valor invalido";
		}
		
		return valor;
	}

}

package tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Aluno;

public class AlunoTableModel extends AbstractTableModel {

	/* atributos */
	private ArrayList linhas = null; // coleção que armazena qualquer tipo de objeto, vai representar as linhas
	private String[] colunas = null; // vetor tipo string, vai representar as colunas

	private List<Aluno> dados;

	/*
	 * public ModeloTabela(ArrayList lin, String[] col) { setLinhas(lin);
	 * setColunas(col); }
	 */

	public AlunoTableModel(List<Aluno> listaAluno) {
		dados = listaAluno;
	}

	/*
	 * public ArrayList getLinhas() { return linhas; }
	 * 
	 * public void setLinhas(ArrayList linhas) { this.linhas = linhas; }
	 * 
	 * public String[] getColunas() { return colunas; }
	 * 
	 * public void setColunas(String[] colunas) { this.colunas = colunas; }
	 */

	/* conta o número de colunas */
	public int getColumnCount() {
		return 8;
	}

	/* conta o numero de linhas */
	public int getRowCount() {
		return dados.size();
	}

	/* vai pegar o nome das colunas */
	public String getColumnName(int numCol) {

		String coluna = "";

		switch (numCol) {
		case 0:
			coluna = "RM";
			break;
		case 1:
			coluna = "Nome";
			break;
		case 2:
			coluna = "Sobrenome";
			break;
		case 3:
			coluna = "CPF";
			break;
		case 4:
			coluna = "Nascimento";
			break;
		case 5: 
			coluna = "Email";
			break;
		case 6:
			coluna = "Turma";
			break;
		case 7:
			coluna = "Status";
			break;
		default:
			coluna = "Coluna";
		}

		return coluna;

	}

	/* metodo que vai montar a tabela */
	public Object getValueAt(int numLin, int numCol) {

		// Object[] linha = (Object[])getLinhas().get(numLin);
		// return linha[numCol];

		model.Aluno objAluno = dados.get(numLin);
	
		
		Object valor = null;
		
		switch(numCol) {
		case 0:
			valor = objAluno.getRmAluno();
			break;
		case 1: 
			valor = objAluno.getNomeAluno();
			break;
		case 2:
			valor = objAluno.getSobrenomeAluno();
			break;
		case 3:
			valor = objAluno.getCpfAluno();
			break;
		case 4: 
			valor = objAluno.getNascimentoAluno();
			break;
		case 5:
			valor = objAluno.getEmailAluno();
			break;
		case 6: 
			valor = objAluno.getTurmaString();
			break;
		case 7:
			valor = objAluno.getStatusString();
			break;
		default: 
			valor = "Valor invalido";
		}
		
		return valor;

	}

}

package tabela;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Aluno;

public class ModeloTabela extends AbstractTableModel {

	/* atributos */
	private ArrayList linhas = null; //coleção que armazena qualquer tipo de objeto, vai representar as linhas
	private String[] colunas = null; //vetor tipo string, vai representar as colunas
	
	private List<Aluno> dados;
	
	/*public ModeloTabela(ArrayList lin, String[] col) {
		setLinhas(lin);
		setColunas(col);
	}*/
	

	public ModeloTabela(List<Aluno> listaAluno) {
		this.dados = listaAluno;
	}


	/*public ArrayList getLinhas() {
		return linhas;
	}

	public void setLinhas(ArrayList linhas) {
		this.linhas = linhas;
	}

	public String[] getColunas() {
		return colunas;
	}

	public void setColunas(String[] colunas) {
		this.colunas = colunas;
	}*/
	
	/* conta o número de colunas */
	public int getColumnCount() {
		return 3;
	}
	
	/* conta o numero de linhas */
	public int getRowCount() {
		return dados.size();
	}
 	
	/* vai pegar o nome das colunas */
	public String getColumnName(int numCol)	{
		return "Colunas";
	}
	
	/* metodo que vai montar a tabela */
	public Object getValueAt(int numLin, int numCol) {
		//Object[] linha = (Object[])getLinhas().get(numLin);
		//return linha[numCol];
		return null;
	}
	
}

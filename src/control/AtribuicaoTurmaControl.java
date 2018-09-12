package control;

import java.util.List;

import model.AtribuicaoTurma;
import tabela.AtribuicaoTurmaTableModel;

public class AtribuicaoTurmaControl {
	
	
	public static List<AtribuicaoTurma> listAtribuicaoTurma;

	public static void CadastrarAtribuicaoTurma(int atribuicao, int turma) {

		model.AtribuicaoTurma objAtribuicaoTurma = new model.AtribuicaoTurma();

		objAtribuicaoTurma.setId_Atrib(atribuicao);
		objAtribuicaoTurma.setId_Turma(turma);

		model.AtribuicaoTurmaDAO objAtribuicaoTurmaDAO = new model.AtribuicaoTurmaDAO();
		objAtribuicaoTurmaDAO.CadastrarAtribuicaoTurma(objAtribuicaoTurma);
	}

	public static boolean AtribuicaoTurmaValidacao(int idatrib, int idturma) {
		model.AtribuicaoTurmaDAO objAtribuicaoTurmaDAO = new model.AtribuicaoTurmaDAO();

		if (objAtribuicaoTurmaDAO.AtribuicaoValidacao(idatrib, idturma)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void ConsultarAtribuicaoTurma() {
		model.AtribuicaoTurmaDAO objAtribuicaoTurma = new model.AtribuicaoTurmaDAO();
		listAtribuicaoTurma = objAtribuicaoTurma.ConsultarAtribuicaoTurma();
		if(listAtribuicaoTurma != null) {
			view.Administracao.pnlAtribuicaoConsulta.tblAtribuicaoTurma.setModel(new AtribuicaoTurmaTableModel(listAtribuicaoTurma));
		}
		
	}
	
	public static void BuscarAtribuicacoTurma(int atrib, int turma) { 
		model.AtribuicaoTurmaDAO objAtribuicaoTurma = new model.AtribuicaoTurmaDAO();
		int codigo = objAtribuicaoTurma.BuscarAtribuicacoTurma(atrib, turma);
		if(codigo != 0) {
			view.Professor.pnlNota.codigoAtribuicaoTurma = codigo;
			view.Professor.pnlNotaConsulta.codigoAtribuicaoTurma = codigo;
		}
	}

}

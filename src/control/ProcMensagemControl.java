package control;

import java.util.List;

import model.ProcMensagem;
import tabela.MensagemTableModel;

public class ProcMensagemControl {
	
	private static List<ProcMensagem> listMensagem;
	
	public static void ConsultarMensagemProfessor(int recebido) {
		model.ProcMensagemDAO objMensagemDAO = new model.ProcMensagemDAO();
		listMensagem = objMensagemDAO.ConsultarMensagemProfessor(recebido);
		if(listMensagem != null) {
			view.Professor.pnlMensagem.tblMensagem.setModel(new MensagemTableModel(listMensagem));
		}
	}
	
	public static void ConsultarMensagemAluno(int recebido) {
		model.ProcMensagemDAO objMensagemDAO = new model.ProcMensagemDAO();
		listMensagem = objMensagemDAO.ConsultarMensagemAluno(recebido);
		if(listMensagem != null) {
			view.Aluno.pnlMensagem.tblMensagem.setModel(new MensagemTableModel(listMensagem));
		}
	}

}

package control;

import java.util.List;

import model.Sugestao;
import tabela.SugestaoTableModel;

public class SugestaoControl {
	
	private static List<Sugestao> listSugestao;
	
		public static void CadastrarSugestao(int rm, String mensagem) {
			
			model.Sugestao objSugestao = new model.Sugestao();
			
			objSugestao.setFkSugestao(rm);
			objSugestao.setMensagemSugestao(mensagem);
			
			model.SugestaoDAO objSugestaoDAO = new model.SugestaoDAO();
			objSugestaoDAO.CadastrarSugestao(objSugestao);
		
		
		
	}

		
	public static void ConsultarSugestao() {
		
		model.SugestaoDAO objSugestaoDAO = new model.SugestaoDAO();
		listSugestao = objSugestaoDAO.ConsultarSugestao();
		if(listSugestao != null) {
			
			view.Administracao.pnlSugestao.tblSugestao.setModel(new SugestaoTableModel(listSugestao));
		}
		
		
		
	}
		
}

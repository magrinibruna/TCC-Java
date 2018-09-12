package control;

import java.sql.Date;

public class AvaliacaoControl {
	

	
	public static void CadastrarAvaliacao(String nome, int peso) {
		
		model.Avaliacao objAvaliacao = new model.Avaliacao();
		
		objAvaliacao.setNomeAvaliacao(nome);
		objAvaliacao.setPesoAvaliacao(peso);
		
		model.AvaliacaoDAO objAvaliacaoDAO = new model.AvaliacaoDAO();
		objAvaliacaoDAO.CadastrarAvaliacao(objAvaliacao);
		
	}

}

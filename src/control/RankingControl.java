package control;

import java.util.ArrayList;
import java.util.List;

import model.Ranking;

public class RankingControl {
	
	public static void listarRanking() {
		List<Ranking> listRanking = new ArrayList<>();
		model.RankingDAO objRankingDAO = new model.RankingDAO();
		listRanking = objRankingDAO.ListarRanking();
		
		view.Login.frmLogin.lblRanking1.setText(listRanking.get(0).toString());
		view.Login.frmLogin.lblRanking2.setText(listRanking.get(1).toString());
		view.Login.frmLogin.lblRanking3.setText(listRanking.get(2).toString());
	}

}

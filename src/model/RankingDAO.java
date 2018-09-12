package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class RankingDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Ranking objRanking;
	// representa a tabela
	
	public List<Ranking> ListarRanking() {
		int resultado = 0;
		String SQL = "select * from vw_Ranking;";
		List<Ranking> listRanking = new ArrayList<>();
		
		try {
			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();
			
			while(rs.next()) {
				objRanking =  new Ranking();
				objRanking.setTrimestre(rs.getString(1));
				objRanking.setTurma(rs.getString(2));
				objRanking.setNotas(rs.getDouble(3));
				listRanking.add(objRanking);
			}
			
			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listRanking;
		
	}


}

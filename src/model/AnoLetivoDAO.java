package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class AnoLetivoDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();
	
	PreparedStatement st;
	ResultSet rs;
	AnoLetivo objAnoLevito;
	
	public int CadastrarAnoLetivo(AnoLetivo objAnoLetivo) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_AnoLetivo(desc_ano)" +
		"values (?)";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			st.setString(1, objAnoLetivo.getAno());
			
			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Curso cadastrada com sucesso!");
			}
			
			conexao.close();
			st.close();
			return resultado;
			
			
		} catch (Exception e) {
			
			try {
				
				if (conexao != null) {
					conexao.rollback();
				}
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
				
			}
			
			e.printStackTrace();
		}
		
		
		return resultado;
	}
	


}

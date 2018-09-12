package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class AvaliacaoDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();
	
	PreparedStatement st;
	//envia as informações pro banco
	ResultSet rs;
	//pega as informações
	Avaliacao objAvaliacao;
	//representa a tabela 
	
	public int CadastrarAvaliacao(Avaliacao objAvaliacao) {
		int resultado = 0;
		
		String SQL = "INSERT INTO tb_Avaliacao(Desc_Aval, Peso_Aval)" + 
		"values(?, ?)";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			//o st vai enviar por meio da conexão o valor do SQL
			
			st.setString(1, objAvaliacao.getNomeAvaliacao());
			st.setInt(2, objAvaliacao.getPesoAvaliacao());
			
			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Avaliação cadastrada com sucesso!");
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

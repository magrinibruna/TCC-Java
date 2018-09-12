package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class SugestaoDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();
	
	PreparedStatement st;
	//envia as informações pro banco
	ResultSet rs;
	//pega as informações
	Sugestao objSugestao;
	//representa a tabela 	
	
	public int CadastrarSugestao(Sugestao objSugestao) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Sugestao(FKSgt, MsgSgt) VALUES (?,?)";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			//o st vai enviar por meio da conexão o valor do SQL
			
			st.setInt(1, objSugestao.getFkSugestao());
			st.setString(2, objSugestao.getMensagemSugestao());

			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Sugestão cadastrada com sucesso");
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
	
	
	public List<Sugestao> ConsultarSugestao(){
		
		List<Sugestao> listSugestao = new ArrayList<Sugestao>();
		
		
		try {
			
			st = conexao.prepareStatement("select * from TabelaSugestao ORDER BY Data_Envio desc");
			rs = st.executeQuery();
			
			while(rs.next()) {
				objSugestao = new Sugestao();
				objSugestao.setIdSugestao(rs.getInt(1));
				objSugestao.setAlunoSugestao(rs.getString(2));
				objSugestao.setDataSugestao(rs.getDate(3));
				objSugestao.setMensagemSugestao(rs.getString(4));
				listSugestao.add(objSugestao);
				
			}
			
			rs.close();
			st.close();
			conexao.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return listSugestao;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
	}
 	

}

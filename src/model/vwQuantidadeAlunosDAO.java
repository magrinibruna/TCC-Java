package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class vwQuantidadeAlunosDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();
	
	PreparedStatement st;
	//envia as informações pro banco
	ResultSet rs;
	//pega as informações
	vwQuantidadeAlunos objvwQuantidadeAlunos;
	//representa a tabela 	

	public vwQuantidadeAlunos QuantidadeAlunos(int idTurma) {
		String SQL = "SELECT * FROM vw_QuantidadeAlunos WHERE id_Turma = ?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, idTurma);
			
			rs = st.executeQuery();
			if (rs.next()) {
				//se o rs vir vazio, ele recebe 0, logo, vai pro else, se encotnrar recebe 1, executando o if	
				
				objvwQuantidadeAlunos = new vwQuantidadeAlunos();
				
				objvwQuantidadeAlunos.setIdTurma(rs.getInt(1));
				objvwQuantidadeAlunos.setCompletoTurma(rs.getString(2));
				objvwQuantidadeAlunos.setQuantidadeAlunos(rs.getInt(3));
				
							
			} else {
					
				JOptionPane.showMessageDialog(null, "turma não possui alunos cadastrados");
				return null;
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return objvwQuantidadeAlunos;
	}

}

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;

public class ProcMensagemDAO {

	Connection conexao = new ConnectionFactory().getConnection();
	PreparedStatement st;
	ResultSet rs;
	ProcMensagem objMensagem;
	
	public List<ProcMensagem> ConsultarMensagemProfessor(int recebido) {
		List<ProcMensagem> listMensagem = new ArrayList<ProcMensagem>();
		
		String SQL = "execute Proc_BuscaMensagem 1,?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, recebido);
			rs = st.executeQuery();
			
			while(rs.next()) {
				objMensagem = new ProcMensagem();
				objMensagem.setEnvio(rs.getInt(4));
				objMensagem.setEnvia(rs.getString(5));
				objMensagem.setData(rs.getDate(6));
				objMensagem.setAssunto(rs.getString(7));
				objMensagem.setDescricao(rs.getString(8));
				
				listMensagem.add(objMensagem);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listMensagem;
	}
	
	public List<ProcMensagem> ConsultarMensagemAluno(int recebido) {
		List<ProcMensagem> listMensagem = new ArrayList<ProcMensagem>();
		
		String SQL = "execute Proc_BuscaMensagem 5,?";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, recebido);
			rs = st.executeQuery();
			
			while(rs.next()) {
				objMensagem = new ProcMensagem();
				objMensagem.setEnvio(rs.getInt(4));
				objMensagem.setEnvia(rs.getString(5));
				objMensagem.setData(rs.getDate(6));
				objMensagem.setAssunto(rs.getString(7));
				objMensagem.setDescricao(rs.getString(8));
				
				listMensagem.add(objMensagem);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listMensagem;
	}

}

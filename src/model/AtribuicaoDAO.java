package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class AtribuicaoDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Atribuicao objAtribuicao;
	// representa a tabela
	
	public int CadastrarAtribuicao(Atribuicao objAtribuicao) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Atribuicao(id_Prof, id_disc, nome) VALUES (?,?,?)";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL
			
			st.setInt(1, objAtribuicao.getId_Prof());
			st.setInt(2, objAtribuicao.getId_disc());
			st.setString(3, objAtribuicao.getNome());
			
			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Atribuição cadastrada com sucesso!");
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
	
	public Atribuicao BuscarAtribuicaoNome(String nome) {
		String SQL = "SELECT * FROM tb_Atribuicao WHERE nome = ?";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			rs = st.executeQuery();
			
			if(rs.next()) {
				objAtribuicao = new Atribuicao();
				objAtribuicao.setId_Atrib(rs.getInt(1));
				objAtribuicao.setId_Prof(rs.getInt(2));
				objAtribuicao.setId_disc(rs.getInt(3));
				objAtribuicao.setNome(rs.getString(4));
 				
			} else {
				JOptionPane.showMessageDialog(null, "Atribuição não encontrada");
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return objAtribuicao;
	}
	
	public Vector<Atribuicao> carregarComboAtribuicao() {
	
		Vector<Atribuicao> vAtribuicao = new Vector<Atribuicao>();
		
		try {
			
			String SQL = "SELECT * FROM tb_Atribuicao ORDER BY NOME";
			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				Atribuicao objAtribuicao = new Atribuicao();
				objAtribuicao.setNome(rs.getString(4));
				vAtribuicao.add(objAtribuicao);
				
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vAtribuicao;
		
	} 
	
	public boolean AtribuicaoValidacao(String nome) {
		String SQL = "SELECT * FROM tb_Atribuicao where nome = ?";
	
		try {
				st = conexao.prepareStatement(SQL);
				st.setString(1, nome);
				
				rs = st.executeQuery();
				
				if (rs.next()) {
					return true;
				}
				
				conexao.close();
				st.close();
			
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
		
		return false;
	}
	
	public List<Atribuicao> ConsultarAtribuicao() {
		
		List<Atribuicao> listAtribuicao = new ArrayList<>();
		
		try {
			String SQL = "select * from TabelaAtribuicao";
			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();
			
			while(rs.next()) {
				objAtribuicao = new Atribuicao();
				
				objAtribuicao.setId_Atrib(rs.getInt(1));
				objAtribuicao.setNomeProfessor(rs.getString(2));
				objAtribuicao.setNomeDisciplina(rs.getString(3));
				objAtribuicao.setNome(rs.getString(4));
				objAtribuicao.setAno(rs.getString(5));
				
				listAtribuicao.add(objAtribuicao);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAtribuicao;
	}

}

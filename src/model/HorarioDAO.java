package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class HorarioDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Horario objHorario;
	// representa a tabela
	
	public void CadastrarHorario(Horario objHorario) {
		String SQL = "INSERT INTO tb_Horario(id_Turma, caminho_Horario) VALUES (?, ?)";
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, objHorario.getId_Turma());
			st.setString(2,objHorario.getCaminhoHorario());
			
			int resultado = 0;
			resultado = st.executeUpdate();
			if(resultado == 1) {
				JOptionPane.showMessageDialog(null, "Horario cadastrado com sucesso");
			}
			
			conexao.close();
			st.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public Horario BuscarHorarioTurma(int codigo) {
		String SQL = "SELECT * from tb_Horario where id_Turma = ?";
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);;
			rs = st.executeQuery();
			if(rs.next()) {
				objHorario = new Horario();
				objHorario.setId_Horario(rs.getInt(1));
				objHorario.setId_Turma(rs.getInt(2));
				objHorario.setCaminhoHorario(rs.getString(3));
				objHorario.setStatus(rs.getString(4));
			} else {
				JOptionPane.showMessageDialog(null, "Horario não encontrado");
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return objHorario;
	}
	
	public boolean ValidarHorario(int turma) {
		boolean resultado = false;
		String SQL = "SELECT * from tb_Horario where id_Turma = ?";
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, turma);
			rs = st.executeQuery();
			if(rs.next()) {
				resultado = true;
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultado;
	}

	public void AlterarHorario(Horario objHorario) {
		String SQL = "UPDATE TB_HORARIO SET id_Turma = ?, caminho_Horario = ? where id_Horario = ?";
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, objHorario.getId_Turma());
			st.setString(2, objHorario.getCaminhoHorario());
			st.setInt(3, objHorario.getId_Horario());
			
			int resultado = 0;
			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Horario alterado com sucesso!");
			}
			conexao.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ExcluirHorario(int codigo) {
		String SQL = "UPDATE TB_HORARIO SET status_Horario = 0 where id_Horario = ?";
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);
			
			int resultado = 0;
			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Horario excluido com sucesso!");
			}
			conexao.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void RecuperarHorario(int codigo) {
		String SQL = "UPDATE TB_HORARIO SET status_Horario = 1 where id_Horario = ?";
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);
			
			int resultado = 0;
			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Horario excluido com sucesso!");
			}
			conexao.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

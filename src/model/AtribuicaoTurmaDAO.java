package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class AtribuicaoTurmaDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	AtribuicaoTurma objAtribuicaoTurma;
	// representa a tabela

	public int CadastrarAtribuicaoTurma(AtribuicaoTurma objAtribuicaoTurma) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_AtribTurma (id_Atrib, id_Turma) VALUES (?,?)";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, objAtribuicaoTurma.getId_Atrib());
			st.setInt(2, objAtribuicaoTurma.getId_Turma());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Atribuição e turma cadastrada com sucesso!");
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

	public boolean AtribuicaoValidacao(int idatri, int idturma) {
		String SQL = "SELECT * FROM tb_AtribTurma where id_Atrib = ? AND id_Turma = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, idatri);
			st.setInt(2, idturma);

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

	public int BuscarAtribuicacoTurma(int atrib, int turma) {
		int codigo = 0;
		String SQL = "Select * from tb_AtribTurma where id_atrib = ? and id_turma = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, atrib);
			st.setInt(2, turma);
			rs = st.executeQuery();
			if (rs.next()) {
				codigo = rs.getInt(1);
			}
			conexao.close();
			st.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codigo;
	}

	public List<AtribuicaoTurma> ConsultarAtribuicaoTurma() {
		List<AtribuicaoTurma> listAtribuicaoTurma = new ArrayList<>();

		try {
			String SQL = "select * from TabelaAtribTurma";
			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();

			while (rs.next()) {
				objAtribuicaoTurma = new AtribuicaoTurma();

				objAtribuicaoTurma.setId_AtribTurma(rs.getInt(1));
				objAtribuicaoTurma.setNome(rs.getString(2));
				objAtribuicaoTurma.setTurma(rs.getString(3));

				listAtribuicaoTurma.add(objAtribuicaoTurma);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listAtribuicaoTurma;
	}

}

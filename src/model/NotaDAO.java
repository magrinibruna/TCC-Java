package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import util.ConnectionFactory;

public class NotaDAO {

	Connection conexao = new ConnectionFactory().getConnection();
	PreparedStatement st;
	ResultSet rs;
	Nota objNota;

	public int InserirNota(Nota objNota) throws SQLException {
		int resultado = 0;
		try {
			st = conexao.prepareStatement(
					"INSERT INTO tb_nota (id_Aluno,id_AtribT, id_Aval, Trim, Nota)" + "VALUES (?, ?, ?, ?, ?)");

			st.setInt(1, objNota.getId_Aluno());
			st.setInt(2, objNota.getId_Atrib());
			st.setInt(3, objNota.getId_Aval());
			st.setInt(4, objNota.getTrim());
			st.setDouble(5, objNota.getNota());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				// JOptionPane.showMessageDialog(null, "Nota cadastrada com sucesso!");
			}

		} catch (SQLException e) {
			try {
				if (conexao != null) {
					conexao.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		if (resultado == 1) {
			conexao.close();
			st.close();
			return resultado;
		}
		return resultado;
	}

	public int AlterarNota(Nota objNota) throws SQLException {
		int resultado = 0;
		try {
			st = conexao.prepareStatement(
					"update tb_Nota set Nota = ? WHERE id_Aluno = ? and id_AtribT = ? AND id_Aval = ? AND trim = ?");

			st.setDouble(1, objNota.getNota());
			st.setInt(2, objNota.getId_Aluno());
			st.setInt(3, objNota.getId_Atrib());
			st.setInt(4, objNota.getId_Aval());
			st.setInt(5, objNota.getTrim());

			resultado = st.executeUpdate();
			if (resultado == 1) {
				// JOptionPane.showMessageDialog(null, "Nota alterada com sucesso!");
			}

		} catch (SQLException e) {
			/*
			 * try { if (conexao != null) { conexao.rollback(); } } catch (SQLException e1)
			 * { e1.printStackTrace(); }
			 */
			e.printStackTrace();
		}

		if (resultado == 1) {

			conexao.close();
			st.close();
			return resultado;

		}

		return resultado;
	}

	public Vector<vwProfessor> carregarComboDisciplinaNota(int codigoProfessor) {

		// CRIA UM VETOR DE REGISTROS(classe Vector) E OS ALOCA E UM OBJETO.
		Vector<vwProfessor> vwprofessor = new Vector<vwProfessor>();

		// CRIA UMA STRING COM O COMANDO SQL PARA CONSULTAR DADOS.
		try {

			String SQL = "select distinct Disciplina from vw_Professores where codigo = ?";
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigoProfessor);
			rs = st.executeQuery();

			while (rs.next()) {

				vwProfessor objVwProfessor = new vwProfessor();
				objVwProfessor.setNomeDisciplina(rs.getString(1));
				vwprofessor.add(objVwProfessor);

				// System.out.println(objVwProfessor.getNomeDisciplina());

			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vwprofessor;

	}

	public Vector<vwAtribuicao> carregarComboTurmaNota(int codigoAtribuicao) {

		// CRIA UM VETOR DE REGISTROS(classe Vector) E OS ALOCA E UM OBJETO.
		Vector<vwAtribuicao> atribuicao = new Vector<vwAtribuicao>();

		// CRIA UMA STRING COM O COMANDO SQL PARA CONSULTAR DADOS.
		try {

			String SQL = "SELECT * FROM vw_Atribuicao WHERE codigoAtribuicao = ?";
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigoAtribuicao);
			rs = st.executeQuery();

			while (rs.next()) {

				vwAtribuicao objAtribuicao = new vwAtribuicao();
				objAtribuicao.setNomeTurma(rs.getString(6));
				atribuicao.add(objAtribuicao);

				// System.out.println(objAtribuicao.getNomeTurma());

			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return atribuicao;

	}

	public List<Nota> listarNotas(int rm, int atrib, int aval, int trim) {

		List<Nota> listNota = new ArrayList<Nota>();

		try {

			st = conexao.prepareStatement(
					"SELECT * FROM tb_Nota WHERE id_Aluno = ? AND id_AtribT = ? AND id_Aval = ? AND Trim = ?");

			st.setInt(1, rm);
			st.setInt(2, atrib);
			st.setInt(3, aval);
			st.setInt(4, trim);
			rs = st.executeQuery();

			while (rs.next()) {

				objNota = new Nota();
				objNota.setId_Nota(rs.getInt("id_Nota"));
				objNota.setNota(rs.getDouble("Nota"));
				listNota.add(objNota);

			}
			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listNota;
	}

	public boolean ValidarAvaliacao(int idatribt, int aval, int trim, int rm) {

		String SQL = "SELECT * FROM tb_Nota Where id_AtribT = ? AND id_Aval = ? AND Trim = ? AND id_Aluno = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, idatribt);
			st.setInt(2, aval);
			st.setInt(3, trim);
			st.setInt(4, rm);
			rs = st.executeQuery();

			if (rs.next()) {
				return true;
			}

			conexao.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}



}

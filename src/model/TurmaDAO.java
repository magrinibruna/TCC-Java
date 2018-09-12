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

public class TurmaDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Turma objTurma;
	// representa a tabela

	public int CadastrarTurma(Turma objTurma) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Turma( id_Curso, ano_Turma, nome_Turma, periodo_Turma)" + "VALUES( ?, ?, ? , ?)";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setInt(1, objTurma.getIdCurso());
			st.setString(2, objTurma.getAnoTurma());
			st.setString(3, objTurma.getNomeTurma());
			st.setString(4, objTurma.getPeriodoTurma());
			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
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

	public Turma BuscarTurmaNome(String nome) {
		String SQL = "select * from tb_turma where completo_turma = ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			rs = st.executeQuery();

			if (rs.next()) {
				objTurma = new Turma();
				objTurma.setIdTurma(rs.getInt(1));
				objTurma.setIdCurso(rs.getInt(2));
				objTurma.setAnoTurma(rs.getString(3));
				objTurma.setNomeTurma(rs.getString(4));
				objTurma.setPeriodoTurma(rs.getString(5));
				objTurma.setAnoLetivoTurma(rs.getString(6));
				objTurma.setCompletoTurma(rs.getString(7));

			} else {
				JOptionPane.showMessageDialog(null, "Turma não encontrada");
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objTurma;

	}

	public int BuscarTurmaNomeValidacao(String nome) {
		int resultado = 0;
		String SQL = "select * from tb_turma where completo_turma = ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			rs = st.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Turma já existe");
				resultado = 1;

			} else {
				resultado = 0;
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultado;

	}

	public Turma BuscarTurmaID(int id) {
		String SQL = "select * from tb_turma where id_turma = ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				objTurma = new Turma();
				objTurma.setIdTurma(rs.getInt(1));
				objTurma.setIdCurso(rs.getInt(2));
				objTurma.setAnoTurma(rs.getString(3));
				objTurma.setNomeTurma(rs.getString(4));
				objTurma.setPeriodoTurma(rs.getString(5));
				objTurma.setAnoLetivoTurma(rs.getString(6));
				objTurma.setCompletoTurma(rs.getString(7));

			} else {
				JOptionPane.showMessageDialog(null, "Turma não encontrada");
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objTurma;
	}

	public Vector<Turma> carregarComboTurma() {

		Vector<Turma> turma = new Vector<Turma>();
		// CRIA UMA STRING COM O COMANDO SQL PARA CONSULTAR DADOS.
		try {

			st = conexao.prepareStatement("SELECT * FROM tb_Turma ORDER BY completo_Turma");
			rs = st.executeQuery();

			while (rs.next()) {
				Turma objTurma = new Turma();
				objTurma.setIdTurma(rs.getInt(1));
				objTurma.setCompletoTurma(rs.getString(7));
				turma.add(objTurma);

			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return turma;

	}

	public Vector<Turma> carregarComboTurmaPorAno(String ano) {

		Vector<Turma> turma = new Vector<Turma>();
		// CRIA UMA STRING COM O COMANDO SQL PARA CONSULTAR DADOS.
		try {

			st = conexao.prepareStatement("SELECT * FROM tb_Turma WHERE ano_turma = ? ORDER BY completo_Turma");
			st.setString(1, ano);
			rs = st.executeQuery();

			while (rs.next()) {
				Turma objTurma = new Turma();
				objTurma.setIdTurma(rs.getInt(1));
				objTurma.setCompletoTurma(rs.getString(7));
				turma.add(objTurma);

			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return turma;

	}

	public List<Turma> ConsultarTurma() {
		List<Turma> listTurma = new ArrayList<>();

		String SQL = "select * from tabelaTurma where status = 'Ativo'";
		try {

			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();

			while (rs.next()) {
				objTurma = new Turma();

				objTurma.setIdTurma(rs.getInt(1));
				objTurma.setNomeCurso(rs.getString(2));
				objTurma.setAnoTurma(rs.getString(3));
				objTurma.setPeriodoTurma(rs.getString(4));
				objTurma.setAnoLetivoTurma(rs.getString(5));
				objTurma.setCompletoTurma(rs.getString(6));

				listTurma.add(objTurma);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return listTurma;

	}
	
	public List<Turma> ConsultarTurmaExcluido() {
		List<Turma> listTurma = new ArrayList<>();

		String SQL = "select * from tabelaTurma where status = 'Inativo'";
		try {

			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();

			while (rs.next()) {
				objTurma = new Turma();

				objTurma.setIdTurma(rs.getInt(1));
				objTurma.setNomeCurso(rs.getString(2));
				objTurma.setAnoTurma(rs.getString(3));
				objTurma.setPeriodoTurma(rs.getString(4));
				objTurma.setAnoLetivoTurma(rs.getString(5));
				objTurma.setCompletoTurma(rs.getString(6));

				listTurma.add(objTurma);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return listTurma;

	}

	public void AlterarTurma(Turma objTurma) {
		String SQL = "UPDATE tb_turma set id_curso = ?, ano_turma = ?, nome_Turma = ?, periodo_Turma = ?, completo_Turma = ? WHERE id_Turma = ?";

		try {
			st = conexao.prepareStatement(SQL);

			st.setInt(1, objTurma.getIdCurso());
			st.setString(2, objTurma.getAnoTurma());
			st.setString(3, objTurma.getNomeTurma());
			st.setString(4, objTurma.getPeriodoTurma());
			st.setString(5, objTurma.getCompletoTurma());
			st.setInt(6, objTurma.getIdTurma());

			int resultado = 0;
			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Turma alterada com sucesso");
			}

			conexao.close();
			st.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void ExcluirTurma(int codigo) {
		String SQL = "UPDATE tb_turma set Status_Turma = 0 WHERE id_Turma = ?";

		try {
			st = conexao.prepareStatement(SQL);

			st.setInt(1, codigo);


			int resultado = 0;
			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Turma excluida com sucesso");
			}

			conexao.close();
			st.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public void RecuperarTurma(int codigo) {
		String SQL = "UPDATE tb_turma set Status_Turma = 1 WHERE id_Turma = ?";

		try {
			st = conexao.prepareStatement(SQL);

			st.setInt(1, codigo);


			int resultado = 0;
			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Turma recuperada com sucesso");
			}

			conexao.close();
			st.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}

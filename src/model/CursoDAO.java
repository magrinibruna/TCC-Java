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

public class CursoDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Curso objCurso;
	// representa a tabela

	public int CadastrarCurso(Curso objCurso)
	// privacidade
	// static ou não
	// tipo (Funcionario, int, void - se for void, não precisa do return- )
	// nome do método
	{
		int resultado = 0;
		String SQL = "INSERT INTO tb_Curso( NomeCurso, AbrevCurso)" + "VALUES (?, ?)";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setString(1, objCurso.getNomeCurso());
			st.setString(2, objCurso.getAbreviaturaCurso());
			// st.setDate(4, objCurso.getExclusaoCurso());

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

		return 0;

	}

	public Curso BuscarCursoNome(String nome) {
		String SQL = "SELECT * FROM tb_Curso WHERE NomeCurso = ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			rs = st.executeQuery();

			if (rs.next()) {
				objCurso = new Curso();
				objCurso.setIdCurso(rs.getInt(1));
				objCurso.setNomeCurso(rs.getString(2));
				objCurso.setAbreviaturaCurso(rs.getString(3));
				objCurso.setAICurso(rs.getInt(4));

			} else {
				JOptionPane.showMessageDialog(null, "Curso não encontrado");
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objCurso;
	}

	public Curso BuscarCursoCodigo(int codigo) {
		String SQL = "SELECT * FROM tb_Curso WHERE id_Curso = ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {
				objCurso = new Curso();
				objCurso.setIdCurso(rs.getInt(1));
				objCurso.setNomeCurso(rs.getString(2));
				objCurso.setAbreviaturaCurso(rs.getString(3));
				objCurso.setAICurso(rs.getInt(4));

			} else {
				JOptionPane.showMessageDialog(null, "Curso não encontrado");
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objCurso;
	}

	public int BuscarCursoNomeValidacao(String nome) {
		int resultado = 0;
		String SQL = "SELECT * FROM tb_Curso WHERE NomeCurso = ?";
		try {

			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			rs = st.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Curso já existe");
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

	public Vector<Curso> carregarComboCargo() {

		// CRIA UM VETOR DE REGISTROS(classe Vector) E OS ALOCA E UM OBJETO.
		Vector<Curso> curso = new Vector<Curso>();

		// CRIA UMA STRING COM O COMANDO SQL PARA CONSULTAR DADOS.
		try {

			st = conexao.prepareStatement("SELECT * FROM tb_Curso ORDER BY NomeCurso");
			rs = st.executeQuery();

			while (rs.next()) {
				Curso objCurso = new Curso();
				objCurso.setIdCurso(rs.getInt(1));
				objCurso.setNomeCurso(rs.getString(2));
				curso.add(objCurso);

			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return curso;

	}

	public List<Curso> ConsultarCurso() {

		List<Curso> listCurso = new ArrayList<>();

		try {

			st = conexao.prepareStatement("SELECT * FROM tb_Curso where AICurso = 1 order by NomeCurso");
			rs = st.executeQuery();

			while (rs.next()) {
				objCurso = new Curso();
				objCurso.setIdCurso(rs.getInt(1));
				objCurso.setNomeCurso(rs.getString(2));
				objCurso.setAbreviaturaCurso(rs.getString(3));
				listCurso.add(objCurso);
			}

			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listCurso;

	}

	public List<Curso> ConsultarCursoExcluido() {

		List<Curso> listCurso = new ArrayList<>();

		try {

			st = conexao.prepareStatement("SELECT * FROM tb_Curso where AICurso = 0 order by NomeCurso");
			rs = st.executeQuery();

			while (rs.next()) {
				objCurso = new Curso();
				objCurso.setIdCurso(rs.getInt(1));
				objCurso.setNomeCurso(rs.getString(2));
				objCurso.setAbreviaturaCurso(rs.getString(3));
				listCurso.add(objCurso);
			}

			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return listCurso;

	}

	public void AlterarCurso(Curso objCurso) {

		String SQL = "UPDATE tb_Curso set nomeCurso = ?, abrevCurso = ? WHERE id_Curso = ?";

		try {
			st = conexao.prepareStatement(SQL);

			st.setString(1, objCurso.getNomeCurso());
			st.setString(2, objCurso.getAbreviaturaCurso());
			st.setInt(3, objCurso.getIdCurso());

			int resultado = 0;
			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Curso alterado com sucesso");
			}

			conexao.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void ExcluirCurso(int codigo) {

		String SQL = "UPDATE tb_Curso set AICurso = 0 WHERE id_Curso = ?";

		try {
			st = conexao.prepareStatement(SQL);

			st.setInt(1, codigo);

			int resultado = 0;
			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Curso excluido com sucesso");
			}

			conexao.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void RecuperarCurso(int codigo) {

		String SQL = "UPDATE tb_Curso set AICurso = 1 WHERE id_Curso = ?";

		try {
			st = conexao.prepareStatement(SQL);

			st.setInt(1, codigo);

			int resultado = 0;
			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Curso recuperado com sucesso");
			}

			conexao.close();
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

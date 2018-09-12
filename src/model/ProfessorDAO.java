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

public class ProfessorDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Professor objProfessor;
	// representa a tabela

	public int CadastrarProfessor(Professor objProfessor)
	// privacidade
	// static ou não
	// tipo (Funcionario, int, void - se for void, não precisa do return- )
	// nome do método
	{
		int resultado = 0;
		String SQL = "INSERT INTO tb_Professor(id_Prof, Nome_Prof, SobreNProf, CpfProf, EmailProf)"
				+ "VALUES (?, ?, ?, ?, ?)";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setInt(1, objProfessor.getIdProfessor());
			st.setString(2, objProfessor.getNomeProfessor());
			st.setString(3, objProfessor.getSobrenomeProfessor());
			st.setString(4, objProfessor.getCpfProfessor());
			st.setString(5, objProfessor.getEmailProfessor());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Professorx cadastradx com sucesso!");
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

	public Professor BuscarProfessorCodigo(int codigo) {
		String SQL = "SELECT * FROM tb_Professor WHERE id_Prof = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);

			rs = st.executeQuery();
			if (rs.next()) {
				// se o rs vir vazio, ele recebe 0, logo, vai pro else, se encotnrar recebe 1,
				// executando o if

				objProfessor = new Professor();

				objProfessor.setIdProfessor(rs.getInt(1));
				objProfessor.setNomeProfessor(rs.getString(2));
				objProfessor.setSobrenomeProfessor(rs.getString(3));
				objProfessor.setCpfProfessor(rs.getString(4));
				objProfessor.setEmailProfessor(rs.getString(5));
				// objProfessor.setStatusProfessor(rs.getInt(5));
				// objProfessor.setCadastroProfessor(rs.getDate(6));

			} else {

				JOptionPane.showMessageDialog(null, "Código não encontrado");
				return null;
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objProfessor;
	}

	public Professor BuscarProfessorNome(String nome, String sobrenome) {
		String SQL = "SELECT * FROM tb_Professor WHERE Nome_Prof = ? AND SobreNProf = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setString(1, nome);
			st.setString(2, sobrenome);

			rs = st.executeQuery();
			if (rs.next()) {
				// se o rs vir vazio, ele recebe 0, logo, vai pro else, se encotnrar recebe 1,
				// executando o if

				objProfessor = new Professor();

				objProfessor.setIdProfessor(rs.getInt(1));
				objProfessor.setNomeProfessor(rs.getString(2));
				objProfessor.setSobrenomeProfessor(rs.getString(3));
				objProfessor.setCpfProfessor(rs.getString(4));
				objProfessor.setEmailProfessor(rs.getString(5));
				objProfessor.setStatusProfessor(rs.getInt(6));
				objProfessor.setCadastroProfessor(rs.getDate(7));

			} else {

				JOptionPane.showMessageDialog(null, "Código não encontrado");
				return null;
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objProfessor;
	}

	public int AlterarProfessor(Professor objProfessor) {
		int resultado = 0;
		String SQL = "UPDATE tb_Professor SET Nome_Prof = ?,  SobreNProf = ?, CPFProf = ?, EmailProf = ? WHERE id_Prof = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setString(1, objProfessor.getNomeProfessor());
			st.setString(2, objProfessor.getSobrenomeProfessor());
			st.setString(3, objProfessor.getCpfProfessor());
			st.setString(4, objProfessor.getEmailProfessor());
			st.setInt(5, objProfessor.getIdProfessor());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Professorx alteradx com sucesso!");
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

	public void AlterarEstadoProfessor(Professor objProfessor) {
		int resultado = 0;
		String SQL = "UPDATE tb_Professor SET StatusProf = ? WHERE id_Prof = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, objProfessor.getStatusProfessor());
			st.setInt(2, objProfessor.getIdProfessor());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Professorx alteradx com sucesso!");
			}

			conexao.close();
			st.close();
			// return resultado;

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

	}

	public Vector<Professor> carregarComboProfessor() {

		// CRIA UM VETOR DE REGISTROS(classe Vector) E OS ALOCA E UM OBJETO.
		Vector<Professor> professor = new Vector<Professor>();

		// CRIA UMA STRING COM O COMANDO SQL PARA CONSULTAR DADOS.
		try {

			String SQL = "SELECT * FROM tb_Professor ORDER BY Nome_Prof";
			st = conexao.prepareStatement(SQL);
			rs = st.executeQuery();

			while (rs.next()) {

				Professor objProfessor = new Professor();
				objProfessor.setNomeProfessor(rs.getString(2));
				objProfessor.setSobrenomeProfessor(rs.getString(3));
				professor.add(objProfessor);

			}
			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return professor;

	}

	public List<Professor> ConsultarProfessor() {

		List<Professor> listProfessor = new ArrayList<Professor>();

		try {

			st = conexao.prepareStatement("SELECT * FROM tb_Professor where  StatusProf = 1 ORDER BY Nome_Prof");
			rs = st.executeQuery();

			while (rs.next()) {
				objProfessor = new Professor();
				objProfessor.setIdProfessor(rs.getInt(1));
				objProfessor.setNomeProfessor(rs.getString(2));
				objProfessor.setSobrenomeProfessor(rs.getString(3));
				objProfessor.setCpfProfessor(rs.getString(4));
				objProfessor.setEmailProfessor(rs.getString(5));
				objProfessor.setStatusProfessor(rs.getInt(6));
				listProfessor.add(objProfessor);
			}

			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listProfessor;

	}

	public List<Professor> ConsultarProfessorExcluido() {

		List<Professor> listProfessor = new ArrayList<Professor>();

		try {

			st = conexao.prepareStatement("SELECT * FROM tb_Professor where  StatusProf = 0 ORDER BY Nome_Prof");
			rs = st.executeQuery();

			while (rs.next()) {
				objProfessor = new Professor();
				objProfessor.setIdProfessor(rs.getInt(1));
				objProfessor.setNomeProfessor(rs.getString(2));
				objProfessor.setSobrenomeProfessor(rs.getString(3));
				objProfessor.setCpfProfessor(rs.getString(4));
				objProfessor.setEmailProfessor(rs.getString(5));
				objProfessor.setStatusProfessor(rs.getInt(6));
				listProfessor.add(objProfessor);
			}

			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listProfessor;

	}

	public boolean ProfessorCodigoValidacao(int codigo) {

		String SQL = "SELECT * from tb_Professor where id_prof = ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {
				return true;
			}

			conexao.close();
			st.close();

		} catch (Exception e) {
			System.out.println("erro na validação professor: " + e);
		}

		return false;
	}

}

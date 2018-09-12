package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.ConnectionFactory;

public class AlunoDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Aluno objAluno;
	// representa a tabela

	/**
	 * @wbp.parser.entryPoint
	 */
	public int CadastrarAluno(Aluno objAluno)
	// privacidade
	// static ou não
	// tipo (Funcionario, int, void - se for void, não precisa do return- )
	// nome do método
	{

		int resultado = 0;
		String SQL = "INSERT INTO tb_Aluno(RM_Aluno, NomeAluno, SobreNAluno, CpfAluno, NascAluno, EmailAluno,  id_Turma, CaminhoFoto)"
				+ "VALUES (?, ?, ?, ?, ? , ?, ?, ?)";
		try {
			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL
			st.setInt(1, objAluno.getRmAluno());
			st.setString(2, objAluno.getNomeAluno());
			st.setString(3, objAluno.getSobrenomeAluno());
			st.setString(4, objAluno.cpfAluno);
			st.setDate(5, objAluno.getNascimentoAluno());
			st.setString(6, objAluno.emailAluno);
			st.setInt(7, objAluno.getTurmaAluno());
			st.setString(8, objAluno.getCaminhoFoto());
			// st.setString(7, objAluno.getAnoAluno());
			// st.setInt(8, objAluno.getStatusAluno());
			// st.setDate(9, objAluno.getExclusaoAluno());

			resultado = st.executeUpdate();
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Alunx cadastradx com sucesso!");
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

	public Aluno BuscarAlunoRM(int rm) {
		String SQL = "Select * from tb_Aluno where rm_Aluno = ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, rm);

			rs = st.executeQuery();
			if (rs.next()) {
				// se o rs vir vazio, ele recebe 0, logo, vai pro else, se encotnrar recebe 1,
				// executando o if

				objAluno = new Aluno();

				objAluno.setRmAluno(rs.getInt(1));
				objAluno.setNomeAluno(rs.getString(2));
				objAluno.setSobrenomeAluno(rs.getString(3));
				objAluno.setCpfAluno(rs.getString(4));
				objAluno.setNascimentoAluno(rs.getDate(5));
				objAluno.setEmailAluno(rs.getString(6));
				objAluno.setTurmaAluno(rs.getInt(7));
				objAluno.setAnoAluno(rs.getString(8));
				objAluno.setStatusAluno(rs.getInt(9));

			} else {

				JOptionPane.showMessageDialog(null, "RM não encontrado");
				return null;
			}

			rs.close();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return objAluno;
	}

	public int AlterarAluno(Aluno objAluno) {
		int resultado = 0;
		String SQL = "UPDATE tb_Aluno SET NomeAluno = ?, SobreNAluno = ?, CpfAluno = ?, NascAluno = ?,"
				+ "EmailAluno = ?, id_Turma = ?, caminhoFoto = ? WHERE RM_Aluno = ? ";

		try {
			st = conexao.prepareStatement(SQL);
			st.setString(1, objAluno.getNomeAluno());
			st.setString(2, objAluno.getSobrenomeAluno());
			st.setString(3, objAluno.getCpfAluno());
			st.setDate(4, objAluno.getNascimentoAluno());
			st.setString(5, objAluno.getEmailAluno());
			st.setInt(6, objAluno.getTurmaAluno());
			st.setString(7, objAluno.getCaminhoFoto());
			st.setInt(8, objAluno.getRmAluno());
			

			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Alunx alteradx com sucesso!");
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

	public int AlterarEstadoAluno(Aluno objAluno) {
		int resultado = 0;
		String SQL = "UPDATE tb_Aluno SET StatusAluno = ? WHERE RM_Aluno = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, objAluno.getStatusAluno());
			st.setInt(2, objAluno.getRmAluno());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Alunx alteradx com sucesso!");
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

	// Validações
	public boolean BuscarAlunoRMValidacao(int rm) {
		String SQL = "SELECT * FROM tb_Aluno WHERE RM_Aluno = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, rm);

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

	
	public String CaminhoFoto(int rm) {
		String SQL = "SELECT * FROM tb_Aluno WHERE RM_Aluno = ?";
		String caminho = "";
		
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, rm);

			rs = st.executeQuery();

			if (rs.next()) {
				objAluno = new Aluno();
				caminho = rs.getString(11);
				return caminho;
			} else {
				objAluno.setCaminhoFoto("");
				
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

		return caminho;
	}

	public List<Aluno> listarTodosAlunos(int turma) {

		List<Aluno> alunos = new ArrayList<Aluno>();

		try {

			st = conexao.prepareStatement("SELECT * FROM tb_ALUNO  where id_turma = ? ORDER BY NomeAluno");
			st.setInt(1, turma);
			rs = st.executeQuery();

			while (rs.next()) {
				objAluno = new Aluno();
				objAluno.setRmAluno(rs.getInt("RM_Aluno"));
				objAluno.setNomeAluno(rs.getString("NomeAluno"));
				objAluno.setSobrenomeAluno(rs.getString("SobreNAluno"));
				alunos.add(objAluno);

			}
			rs.close();
			st.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

	public List<Aluno> ConsultaAluno() {

		List<Aluno> alunos = new ArrayList<Aluno>();

		try {

			st = conexao.prepareStatement("SELECT * FROM TabelaAluno where Status = 'Ativo' ORDER BY Nome");
			rs = st.executeQuery();

			while (rs.next()) {

				objAluno = new Aluno();

				objAluno.setRmAluno(rs.getInt(1));
				objAluno.setNomeAluno(rs.getString(2));
				objAluno.setSobrenomeAluno(rs.getString(3));
				objAluno.setCpfAluno(rs.getString(4));
				objAluno.setNascimentoAluno(rs.getDate(5));
				objAluno.setEmailAluno(rs.getString(6));
				objAluno.setTurmaString(rs.getString(7));
				objAluno.setStatusString(rs.getString(8));
				alunos.add(objAluno);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}

	public List<Aluno> ConsultaAlunoExcluido() {

		List<Aluno> alunos = new ArrayList<Aluno>();

		try {

			st = conexao.prepareStatement("SELECT * FROM TabelaAluno  where Status = 'Inativo' ORDER BY Nome");
			rs = st.executeQuery();

			while (rs.next()) {

				objAluno = new Aluno();

				objAluno.setRmAluno(rs.getInt(1));
				objAluno.setNomeAluno(rs.getString(2));
				objAluno.setSobrenomeAluno(rs.getString(3));
				objAluno.setCpfAluno(rs.getString(4));
				objAluno.setNascimentoAluno(rs.getDate(5));
				objAluno.setEmailAluno(rs.getString(6));
				objAluno.setTurmaString(rs.getString(7));
				objAluno.setStatusString(rs.getString(8));
				alunos.add(objAluno);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}



}

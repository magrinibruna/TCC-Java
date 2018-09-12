package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.ConnectionFactory;

public class ProcNotaDAO {

	Connection conexao = new ConnectionFactory().getConnection();
	PreparedStatement st;
	ResultSet rs;
	ProcNota objNota;

	public List<ProcNota> ConsultarNota(int rm, int trimestre) {

		List<ProcNota> listNota = new ArrayList<ProcNota>();

		String SQL = "execute RetornaAvaliacoesMateria ?, ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, rm);
			st.setInt(2, trimestre);
			rs = st.executeQuery();

			while (rs.next()) {
				objNota = new ProcNota();
				objNota.setAno(rs.getInt(1));
				objNota.setTrimestre(rs.getString(2));
				objNota.setMateria(rs.getString(3));
				objNota.setAvaliacao(rs.getString(4));
				objNota.setNota(rs.getDouble(5));
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

	public List<ProcNota> ConsultarNota2(int rm, int trimestre) {

		List<ProcNota> listNota = new ArrayList<ProcNota>();

		String SQL = "execute RetornaMediaporMateria ?, ?";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, rm);
			st.setInt(2, trimestre);
			rs = st.executeQuery();

			while (rs.next()) {
				objNota = new ProcNota();
				objNota.setAno(rs.getInt(1));
				objNota.setTrimestre(rs.getString(2));
				objNota.setMateria(rs.getString(3));
				objNota.setNota(rs.getDouble(6));
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

	public void ConsultaJasper(int rm, int trimestre) {

		try {

			st = conexao.prepareStatement("execute RetornaMediaporMateria ?,?");
			st.setInt(1, rm);
			st.setInt(2, trimestre);

			rs = st.executeQuery();

			JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
			JasperPrint jasper = JasperFillManager.fillReport("src/relatorio/report4.jasper", new HashMap(), jrRS);
			JasperViewer.viewReport(jasper);

		} catch (Exception e) {
			System.out.println("erro" + e);
		}
	}

	// Consultar nota pelo perfil do professor
	public List<ProcNota> ConsultarNotaProfessor(int codigo, String trimestre) {
		List<ProcNota> listNota = new ArrayList<ProcNota>();

		try {

			st = conexao.prepareStatement("select * from TabelaNotasProfessor where codigo = ? AND Trimestre = ? order by aluno");

			st.setInt(1, codigo);
			st.setString(2, trimestre);
			rs = st.executeQuery();

			while (rs.next()) {

				objNota = new ProcNota();
				objNota.setRm(rs.getString(5));
				objNota.setNomeAluno(rs.getString(6));
				objNota.setAvaliacao(rs.getString(7));
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
	
	public List<ProcNota> ConsultarNotaProfessorAvaliacao(int codigo, String trimestre, String avaliacao) {
		List<ProcNota> listNota = new ArrayList<ProcNota>();

		try {

			st = conexao.prepareStatement("select * from TabelaNotasProfessor where codigo = ? AND Trimestre = ? AND Avaliacao = ? order by aluno");

			st.setInt(1, codigo);
			st.setString(2, trimestre);
			st.setString(3, avaliacao);
			rs = st.executeQuery();

			while (rs.next()) {

				objNota = new ProcNota();
				objNota.setRm(rs.getString(5));
				objNota.setNomeAluno(rs.getString(6));
				objNota.setAvaliacao(rs.getString(7));
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


}

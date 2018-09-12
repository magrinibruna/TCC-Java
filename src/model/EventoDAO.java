package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class EventoDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Evento objEvento;
	// representa a tabela

	public int CadastrarEvento(Evento objEvento) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Evento(titulo_Evento, descricao_Evento, data_Evento, anoLetivo_Evento)"
				+ "values(?, ?, ?, ?)";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setString(1, objEvento.getTituloEvento());
			st.setString(2, objEvento.getDescricaoEvento());
			st.setDate(3, objEvento.getDataEvento());
			st.setString(4, objEvento.getAnoLetivoEvento());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Evento cadastrada com sucesso!");
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

	public List<Evento> ConsultaEvento() {

		List<Evento> listEvento = new ArrayList<Evento>();

		try {

			st = conexao.prepareStatement("select * from tb_evento where Status_Evento = 1 order by data_Evento desc");
			rs = st.executeQuery();

			while (rs.next()) {

				objEvento = new Evento();
				objEvento.setIdEvento(rs.getInt(1));
				objEvento.setTituloEvento(rs.getString(2));
				objEvento.setDescricaoEvento(rs.getString(3));
				objEvento.setDataEvento(rs.getDate(4));
				listEvento.add(objEvento);
			}

			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listEvento;

	}

	public List<Evento> ConsultaEventoExcluido() {

		List<Evento> listEvento = new ArrayList<Evento>();

		try {

			st = conexao.prepareStatement("select * from tb_evento where Status_Evento = 0 order by data_Evento desc");
			rs = st.executeQuery();

			while (rs.next()) {

				objEvento = new Evento();
				objEvento.setIdEvento(rs.getInt(1));
				objEvento.setTituloEvento(rs.getString(2));
				objEvento.setDescricaoEvento(rs.getString(3));
				objEvento.setDataEvento(rs.getDate(4));
				listEvento.add(objEvento);
			}

			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listEvento;

	}

	public Evento BuscarEventoCodigo(int codigo) {

		String SQL = "SELECT * FROM TB_EVENTO WHERE id_Evento = ? ";

		try {

			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);
			rs = st.executeQuery();

			if (rs.next()) {

				objEvento = new Evento();

				objEvento.setIdEvento(rs.getInt(1));
				objEvento.setTituloEvento(rs.getString(2));
				objEvento.setDescricaoEvento(rs.getString(3));
				objEvento.setDataEvento(rs.getDate(4));

			} else {
				JOptionPane.showMessageDialog(null, "Código não encontrado");
				return null;
			}
			rs.close();
			st.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return objEvento;
	}

	public void AlterarEvento(Evento objEvento) {
		String SQL = "UPDATE tb_Evento set titulo_Evento = ?, descricao_Evento = ?, data_Evento = ? WHERE id_Evento = ?";

		try {
			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setString(1, objEvento.getTituloEvento());
			st.setString(2, objEvento.getDescricaoEvento());
			st.setDate(3, objEvento.getDataEvento());
			st.setInt(4, objEvento.getIdEvento());

			int resultado = 0;
			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Evento alterado com sucesso!");
			}

			conexao.close();
			st.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void ExcluirEvento(int codigo) {
		String SQL = "UPDATE tb_Evento set Status_Evento = 0 WHERE id_Evento = ?";

		try {
			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setInt(1, codigo);

			int resultado = 0;
			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Evento excluido com sucesso!");
			}

			conexao.close();
			st.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void RecuperarEvento(int codigo) {
		String SQL = "UPDATE tb_Evento set Status_Evento = 1 WHERE id_Evento = ?";

		try {
			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setInt(1, codigo);

			int resultado = 0;
			resultado = st.executeUpdate();

			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Evento recuperado com sucesso!");
			}

			conexao.close();
			st.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}

package control;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFormattedTextField;

import model.Evento;
import tabela.EventoTableModel;

public class EventoControl {

	private static List<Evento> listEvento;

	public static Date converteData(JFormattedTextField campoComData) {
		SimpleDateFormat formatoDaData = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dataUsuario = new java.util.Date();
		try {
			dataUsuario = formatoDaData.parse(campoComData.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date dataSQL = new java.sql.Date(dataUsuario.getTime());
		return dataSQL;
	}

	public static void CadastrarEvento(String titulo, String descricao, Date data, String anoLetivo) {

		model.Evento objEvento = new model.Evento();

		objEvento.setTituloEvento(titulo);
		objEvento.setDescricaoEvento(descricao);
		objEvento.setDataEvento(data);
		objEvento.setAnoLetivoEvento(anoLetivo);

		model.EventoDAO objEventoDAO = new model.EventoDAO();
		objEventoDAO.CadastrarEvento(objEvento);

	}

	public static void ConsultarEvento(String tipo) {
		model.EventoDAO objEventoDAO = new model.EventoDAO();
		listEvento = objEventoDAO.ConsultaEvento();
		if (listEvento != null) {

			switch (tipo) {
			case "aluno":
				view.Aluno.pnlEvento.tblEvento.setModel(new EventoTableModel(listEvento));
				//view.Aluno.pnlEvento.tblEvento.getColumnModel().getColumn(0).setMaxWidth(300); // titulo
				//view.Aluno.pnlEvento.tblEvento.getColumnModel().getColumn(1).setMaxWidth(750); // descricao
				//view.Aluno.pnlEvento.tblEvento.getColumnModel().getColumn(2).setMaxWidth(150); // data
				break;
			case "professor":
				view.Professor.pnlEvento.tblEvento.setModel(new EventoTableModel(listEvento));
				//view.Professor.pnlEvento.tblEvento.getColumnModel().getColumn(0).setMaxWidth(300); // titulo
				//view.Professor.pnlEvento.tblEvento.getColumnModel().getColumn(1).setMaxWidth(750); // descricao
				//view.Professor.pnlEvento.tblEvento.getColumnModel().getColumn(2).setMaxWidth(150); // data
				break;
			case "administrador":
				view.Administracao.pnlEventoConsulta.tblEvento.setModel(new EventoTableModel(listEvento));
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(0).setMaxWidth(70);
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(1).setMaxWidth(300); // titulo
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(2).setMaxWidth(750); // descricao
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(3).setMaxWidth(150); // data
				break;

			}

		}
	}

	public static void ConsultarEventoExcluido(String tipo) {
		model.EventoDAO objEventoDAO = new model.EventoDAO();
		listEvento = objEventoDAO.ConsultaEventoExcluido();
		if (listEvento != null) {

			switch (tipo) {
			case "aluno":
				view.Aluno.pnlEvento.tblEvento.setModel(new EventoTableModel(listEvento));
				//view.Aluno.pnlEvento.tblEvento.getColumnModel().getColumn(0).setMaxWidth(300); // titulo
				//view.Aluno.pnlEvento.tblEvento.getColumnModel().getColumn(1).setMaxWidth(750); // descricao
				//view.Aluno.pnlEvento.tblEvento.getColumnModel().getColumn(2).setMaxWidth(150); // data
				break;
			case "professor":
				view.Professor.pnlEvento.tblEvento.setModel(new EventoTableModel(listEvento));
				//view.Professor.pnlEvento.tblEvento.getColumnModel().getColumn(0).setMaxWidth(300); // titulo
				//view.Professor.pnlEvento.tblEvento.getColumnModel().getColumn(1).setMaxWidth(750); // descricao
				//view.Professor.pnlEvento.tblEvento.getColumnModel().getColumn(2).setMaxWidth(150); // data
				break;
			case "administrador":
				view.Administracao.pnlEventoConsulta.tblEvento.setModel(new EventoTableModel(listEvento));
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(0).setMaxWidth(70);
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(1).setMaxWidth(300); // titulo
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(2).setMaxWidth(750); // descricao
				view.Administracao.pnlEventoConsulta.tblEvento.getColumnModel().getColumn(3).setMaxWidth(150); // data
				break;

			}

		}
	}

	
	public static void BuscarEventoCodigo(int codigo, String tipo) {

		model.EventoDAO objEventoDAO = new model.EventoDAO();
		model.Evento objEvento = objEventoDAO.BuscarEventoCodigo(codigo);

		if (objEvento != null) {

			switch (tipo) {

			case "administrador":
				view.Administracao.pnlEventoCadastro.txtTituloEvento.setText(objEvento.getTituloEvento());
				view.Administracao.pnlEventoCadastro.txtData.setText(String.valueOf(objEvento.getDataEvento()));
				view.Administracao.pnlEventoCadastro.txtDescricaoEvento.setText(objEvento.getDescricaoEvento());
				break;
			case "aluno":
				break;

			}

		}

	}
	
	public static void AlterarEvento(int codigo, String titulo, String descricao, Date data) {
		
		model.Evento objEvento = new model.Evento();

		objEvento.setIdEvento(codigo);
		objEvento.setTituloEvento(titulo);
		objEvento.setDescricaoEvento(descricao);
		objEvento.setDataEvento(data);

		model.EventoDAO objEventoDAO = new model.EventoDAO();
		objEventoDAO.AlterarEvento(objEvento);
		
	}
	
	public static void ExcluirEvento(int codigo) {
		
		model.Evento objEvento = new model.Evento();

		objEvento.setIdEvento(codigo);

		model.EventoDAO objEventoDAO = new model.EventoDAO();
		objEventoDAO.ExcluirEvento(codigo);
	}
	
	public static void RecuperarEvento(int codigo) {
		
		model.Evento objEvento = new model.Evento();

		objEvento.setIdEvento(codigo);

		model.EventoDAO objEventoDAO = new model.EventoDAO();
		objEventoDAO.RecuperarEvento(codigo);
	}
}

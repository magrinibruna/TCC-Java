package control;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import model.Curso;
import tabela.CursoTableModel;

public class CursoControl {

	private static List<Curso> listCurso;

	// Convertendo a data
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

	public static void CadastrarCurso(String nome, String abreviatura) {

		model.Curso objCurso = new model.Curso();

		objCurso.setNomeCurso(nome);
		objCurso.setAbreviaturaCurso(abreviatura);
		// objCurso.setExclusaoCurso(exclusao);

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		objCursoDAO.CadastrarCurso(objCurso);

	}

	public static void BuscarCursoNome(String nome, String tipo) {

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		model.Curso objCurso = objCursoDAO.BuscarCursoNome(nome);

		switch (tipo) {

		case "curso":
			view.Administracao.pnlCursoCadastro.txtAbreviaturaCurso.setText(objCurso.getAbreviaturaCurso());

			break;
		case "turma":
			view.Administracao.pnlTurmaCadastro.abreviaturaCurso = objCurso.getAbreviaturaCurso();
			view.Administracao.pnlTurmaCadastro.idCurso = objCurso.getIdCurso();
			break;
		case "disciplina":
			view.Administracao.pnlMateriaCadastro.idCurso = objCurso.getIdCurso();
			break;
		}

	}

	public static void BuscarCursoCodigo(int codigo) {

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		model.Curso objCurso = objCursoDAO.BuscarCursoCodigo(codigo);

	}

	public static int BuscarCursoNomeValidacao(String nome) {

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		int resultado = objCursoDAO.BuscarCursoNomeValidacao(nome);

		return resultado;
	}

	public static void carregarComboCurso(JComboBox<Curso> combo) {

		model.CursoDAO objCursoDAO = new model.CursoDAO();

		try {

			Vector<Curso> curso = objCursoDAO.carregarComboCargo();
			combo.setModel(new DefaultComboBoxModel<Curso>(curso));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static void ConsultarCurso() {

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		listCurso = objCursoDAO.ConsultarCurso();
		if (listCurso != null) {

			view.Administracao.pnlCursoConsulta.tblCurso.setModel(new CursoTableModel(listCurso));
			view.Administracao.pnlCursoConsulta.tblCurso.getColumnModel().getColumn(0).setMaxWidth(70); // codigo
			view.Administracao.pnlCursoConsulta.tblCurso.getColumnModel().getColumn(1).setMaxWidth(355); // nome
			view.Administracao.pnlCursoConsulta.tblCurso.getColumnModel().getColumn(2).setMaxWidth(100); // abreviatura
		}

	}
	
	public static void ConsultarCursoExcluido() {

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		listCurso = objCursoDAO.ConsultarCursoExcluido();
		if (listCurso != null) {

			view.Administracao.pnlCursoConsulta.tblCurso.setModel(new CursoTableModel(listCurso));
			view.Administracao.pnlCursoConsulta.tblCurso.getColumnModel().getColumn(0).setMaxWidth(70); // codigo
			view.Administracao.pnlCursoConsulta.tblCurso.getColumnModel().getColumn(1).setMaxWidth(355); // nome
			view.Administracao.pnlCursoConsulta.tblCurso.getColumnModel().getColumn(2).setMaxWidth(100); // abreviatura
		}

	}

	public static void AlterarCurso(int id, String nome, String abreviatura) {

		model.Curso objCurso = new model.Curso();

		objCurso.setIdCurso(id);
		objCurso.setNomeCurso(nome);
		objCurso.setAbreviaturaCurso(abreviatura);
		// objCurso.setExclusaoCurso(exclusao);

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		objCursoDAO.AlterarCurso(objCurso);

	}
	

	public static void ExcluirCurso(int codigo) {

		model.Curso objCurso = new model.Curso();

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		objCursoDAO.ExcluirCurso(codigo);

	}
	

	public static void RecuperarCurso(int codigo) {

		model.Curso objCurso = new model.Curso();

		model.CursoDAO objCursoDAO = new model.CursoDAO();
		objCursoDAO.RecuperarCurso(codigo);

	}

}

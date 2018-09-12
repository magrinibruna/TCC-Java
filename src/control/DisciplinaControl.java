package control;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Disciplina;
import tabela.DisciplinaTableModel;

public class DisciplinaControl {

	private static List<Disciplina> listDisciplina;

	public static void CadastrarDisciplina(String nome, int serie, int curso) {

		model.Disciplina objDisciplina = new model.Disciplina();

		objDisciplina.setNomeDisciplina(nome);
		objDisciplina.setSerieDisciplina(serie);
		objDisciplina.setCursoDisciplina(curso);

		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		objDisciplinaDAO.CadastrarDisciplina(objDisciplina);

	}

	public static boolean BuscarDisciplinaNomeValidacao(String nome, int serie, int curso) {

		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		if (objDisciplinaDAO.BuscarDisciplinaNomeValidacao(nome, serie, curso)) {
			return true;
		} else {
			return false;
		}
	}

	public static void BuscarDisciplinaNome(String nome, int serie) {

		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		model.Disciplina objDisciplina = objDisciplinaDAO.BuscarDisciplinaNome(nome, serie);

		view.Administracao.pnlRelacionamento.codigoDisciplina = objDisciplina.getIdDisciplina();
	}

	public static void carregarComboDisciplina(JComboBox<Disciplina> combo) {

		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();

		try {

			Vector<Disciplina> disciplina = objDisciplinaDAO.carregarComboDisciplina();
			combo.setModel(new DefaultComboBoxModel<Disciplina>(disciplina));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static void ConsultarDisciplina() {
		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		listDisciplina = objDisciplinaDAO.ConsultarDisciplina();
		if (listDisciplina != null) {
			view.Administracao.pnlDisciplinaConsulta.tblDisciplina.setModel(new DisciplinaTableModel(listDisciplina));
		}
	}
	
	public static void ConsultarDisciplinaExcluido() {
		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		listDisciplina = objDisciplinaDAO.ConsultarDisciplinaExcluido();
		if (listDisciplina != null) {
			view.Administracao.pnlDisciplinaConsulta.tblDisciplina.setModel(new DisciplinaTableModel(listDisciplina));
		}
	}

	public static void AlterarDisciplina(int codigo, String nome, int serie, int curso) {

		model.Disciplina objDisciplina = new model.Disciplina();

		objDisciplina.setIdDisciplina(codigo);
		objDisciplina.setNomeDisciplina(nome);
		objDisciplina.setSerieDisciplina(serie);
		objDisciplina.setCursoDisciplina(curso);

		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		objDisciplinaDAO.AlterarDisciplina(objDisciplina);

	}
	
	public static void ExcluirDisciplina(int codigo) {

		model.Disciplina objDisciplina = new model.Disciplina();

		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		objDisciplinaDAO.ExcluirDisciplina(codigo);
	}
	
	public static void RecuperarDisciplina(int codigo) {

		model.Disciplina objDisciplina = new model.Disciplina();

		model.DisciplinaDAO objDisciplinaDAO = new model.DisciplinaDAO();
		objDisciplinaDAO.RecuperarDisciplina(codigo);
	}

}

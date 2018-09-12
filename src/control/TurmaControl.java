package control;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Turma;
import tabela.TurmaTableModel;

public class TurmaControl {

	private static List<Turma> listTurma;

	public static void CadastrarTurma(int curso, String ano, String nome, String periodo) {

		model.Turma objTurma = new model.Turma();

		objTurma.setIdCurso(curso);
		objTurma.setAnoTurma(ano);
		objTurma.setNomeTurma(nome);
		objTurma.setPeriodoTurma(periodo);

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		objTurmaDAO.CadastrarTurma(objTurma);

	}

	public static void carregarComboTurma(JComboBox<Turma> combo) {

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();

		try {

			Vector<Turma> turma = objTurmaDAO.carregarComboTurma();
			combo.setModel(new DefaultComboBoxModel<Turma>(turma));

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void carregarComboTurmaPorAno(JComboBox<Turma> combo, String ano) {

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();

		try {

			Vector<Turma> turma = objTurmaDAO.carregarComboTurmaPorAno(ano);
			combo.setModel(new DefaultComboBoxModel<Turma>(turma));

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void BuscarTurmaNome(String nome, String tipo) {

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		model.Turma objTurma = objTurmaDAO.BuscarTurmaNome(nome);
		model.Curso objCurso = new model.Curso();

		CursoControl.BuscarCursoCodigo(objTurma.getIdCurso());

		switch (tipo) {

		case "consultar":
			view.Administracao.pnlTurmaCadastro.cbCursoTurma.setSelectedItem(objCurso.getNomeCurso());
			view.Administracao.pnlTurmaCadastro.cbSerieTurma.setSelectedItem(objTurma.getAnoTurma());
			view.Administracao.pnlTurmaCadastro.cbSiglaTurma.setSelectedItem(objTurma.getNomeTurma());
			view.Administracao.pnlTurmaCadastro.cbPeriodoTurma.setSelectedItem(objTurma.getPeriodoTurma());
			break;

		case "nota":
			view.Professor.pnlNota.codigoTurma = objTurma.getIdTurma();
			break;

		case "nota2":
			view.Professor.pnlNotaConsulta.codigoTurma = objTurma.getIdTurma();
			break;
			
		case "mensagemprofessor":
			view.Professor.pnlMensagem.codigoTurma = objTurma.getIdTurma();
			break;
		case "mensagemaluno":
			view.Aluno.pnlMensagem.codigoTurma = objTurma.getIdTurma();
			break;
		case "horario":
			view.Administracao.pnlHorario.codigoTurma = objTurma.getIdTurma();
			break;
		case "horarioaluno":
			view.Aluno.pnlHorario.codigoTurma = objTurma.getIdTurma();
			break;
		case "horarioprofessor":
			view.Professor.pnlHorario.codigoTurma = objTurma.getIdTurma();
			break;
		}

	}

	public static void BuscarTurmaNomeCadastros(String nome, String tipo) {

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		model.Turma objTurma = objTurmaDAO.BuscarTurmaNome(nome);

		switch (tipo) {

		case "aluno":
			view.Administracao.pnlAlunoCadastro.idTurma = objTurma.getIdTurma();
			break;
		case "relacionamento":
			view.Administracao.pnlRelacionamento.idTurma = objTurma.getIdTurma();
			break;

		}

	}

	public static int BuscarTurmaNomeValidacao(String nome) {

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		int resultado = objTurmaDAO.BuscarTurmaNomeValidacao(nome);

		return resultado;

	}

	public static void ConsultarTurma() {

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		listTurma = objTurmaDAO.ConsultarTurma();
		if (listTurma != null) {
			view.Administracao.pnlTurmaConsulta.tblTurma.setModel(new TurmaTableModel(listTurma));
			view.Administracao.pnlTurmaConsulta.tblTurma.getColumnModel().getColumn(0).setMaxWidth(70); // codigo

		}

	}
	
	public static void ConsultarTurmaExcluido() {

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		listTurma = objTurmaDAO.ConsultarTurmaExcluido();
		if (listTurma != null) {
			view.Administracao.pnlTurmaConsulta.tblTurma.setModel(new TurmaTableModel(listTurma));
			view.Administracao.pnlTurmaConsulta.tblTurma.getColumnModel().getColumn(0).setMaxWidth(70); // codigo

		}

	}

	public static void AlterarTurma(int codigo, int curso, String ano, String nome, String periodo, String completo) {
		model.Turma objTurma = new model.Turma();

		objTurma.setIdTurma(codigo);
		objTurma.setIdCurso(curso);
		objTurma.setAnoTurma(ano);
		objTurma.setNomeTurma(nome);
		objTurma.setPeriodoTurma(periodo);
		objTurma.setCompletoTurma(completo);

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		objTurmaDAO.AlterarTurma(objTurma);
	}

	
	public static void ExcluirTurma(int codigo) {
		model.Turma objTurma = new model.Turma();

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		objTurmaDAO.ExcluirTurma(codigo);
	}
	
	public static void RecuperarTurma(int codigo) {
		model.Turma objTurma = new model.Turma();

		model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
		objTurmaDAO.RecuperarTurma(codigo);
	}
}

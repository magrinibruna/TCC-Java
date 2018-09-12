package control;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Professor;
import tabela.ProfessorTableModel;

public class ProfessorControl {

	private static List<Professor> listProfessor;

	public static void CadastrarProfessor(int id, String nome, String sobrenome, String cpf, String email) {

		model.Professor objProfessor = new model.Professor();

		objProfessor.setIdProfessor(id);
		objProfessor.setNomeProfessor(nome);
		objProfessor.setSobrenomeProfessor(sobrenome);
		objProfessor.setCpfProfessor(cpf);
		objProfessor.setEmailProfessor(email);

		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		objProfessorDAO.CadastrarProfessor(objProfessor);

	}

	public static void BuscarProfessorCodigo(int codigo, String tipo) {
		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		model.Professor objProfessor = objProfessorDAO.BuscarProfessorCodigo(codigo);

		switch (tipo) {

		case "administracao":

			view.Administracao.pnlProfessorCadastro.txtNomeProfessor.setText(objProfessor.getNomeProfessor());
			view.Administracao.pnlProfessorCadastro.txtSobrenomeProfessor.setText(objProfessor.getSobrenomeProfessor());
			view.Administracao.pnlProfessorCadastro.txtCPFProfessor.setText(objProfessor.getCpfProfessor());
			view.Administracao.pnlProfessorCadastro.txtEmailProfessor.setText(objProfessor.getEmailProfessor());

			break;

		case "nota":
			view.Professor.pnlNota.nomeProfessor = objProfessor.getNomeProfessor() + " "
					+ objProfessor.getSobrenomeProfessor();
			break;
		case "nota2":
			view.Professor.pnlNotaConsulta.nomeProfessor = objProfessor.getNomeProfessor() + " "
					+ objProfessor.getSobrenomeProfessor();
			break;
		
		case "mensagemAluno":
			view.Aluno.pnlMensagem.emailProfessor =objProfessor.getEmailProfessor(); 
			break;
		
		case "mensagemProfessor":
			view.Professor.pnlMensagem.emailProfessor =objProfessor.getEmailProfessor(); 
			break;

		}

	}

	public static void BuscarProfessorNome(String nome) {

		String pNome = nome.substring(0, nome.indexOf(" "));
		String sNome = nome.substring(nome.indexOf(" ") + 1);
		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		model.Professor objProfessor = objProfessorDAO.BuscarProfessorNome(pNome, sNome);

		view.Administracao.pnlRelacionamento.codigoProfessor = objProfessor.getIdProfessor();

	}

	public static void AlterarProfessor(int id, String nome, String sobrenome, String cpf, String email) {

		model.Professor objProfessor = new model.Professor();

		objProfessor.setIdProfessor(id);
		objProfessor.setNomeProfessor(nome);
		objProfessor.setSobrenomeProfessor(sobrenome);
		objProfessor.setCpfProfessor(cpf);
		objProfessor.setEmailProfessor(email);

		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		objProfessorDAO.AlterarProfessor(objProfessor);
	}

	public static void AlterarEstadoProfessor(int id, int status) {

		model.Professor objProfessor = new model.Professor();

		objProfessor.setIdProfessor(id);
		objProfessor.setStatusProfessor(status);

		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		objProfessorDAO.AlterarEstadoProfessor(objProfessor);

	}

	public static void carregarComboProfessor(JComboBox<Professor> combo) {

		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();

		try {

			Vector<Professor> professor = objProfessorDAO.carregarComboProfessor();
			combo.setModel(new DefaultComboBoxModel<Professor>(professor));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static void ConsultaProfessor() {

		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		listProfessor = objProfessorDAO.ConsultarProfessor();
		if (listProfessor != null) {
			view.Administracao.pnlProfessorConsulta.tblProfessor.setModel(new ProfessorTableModel(listProfessor));
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(0).setMaxWidth(70); // codigo
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(1).setMaxWidth(300); // nome
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(2).setMaxWidth(300); // sobrenome
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(3).setMaxWidth(200); // cpf
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(4).setMaxWidth(350); // email
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(5).setMaxWidth(60); // status
		}

	}

	public static void ConsultaProfessorExcluido() {

		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		listProfessor = objProfessorDAO.ConsultarProfessorExcluido();
		if (listProfessor != null) {
			view.Administracao.pnlProfessorConsulta.tblProfessor.setModel(new ProfessorTableModel(listProfessor));
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(0).setMaxWidth(70); // codigo
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(1).setMaxWidth(300); // nome
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(2).setMaxWidth(300); // sobrenome
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(3).setMaxWidth(200); // cpf
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(4).setMaxWidth(350); // email
			view.Administracao.pnlProfessorConsulta.tblProfessor.getColumnModel().getColumn(5).setMaxWidth(60); // status
		}

	}

	public static boolean ProfessorCodigoValidacao(int codigo) {
		model.ProfessorDAO objProfessorDAO = new model.ProfessorDAO();
		if (objProfessorDAO.ProfessorCodigoValidacao(codigo)) {
			return true;
		} else {
			return false;
		}
	}

}

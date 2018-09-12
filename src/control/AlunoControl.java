package control;

import java.awt.Image;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;

import model.Aluno;
import tabela.AlunoTableModel;
import tabela.ModeloTabela;

public class AlunoControl {

	static List<Aluno> listaAluno;

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

	public static void CadastrarAluno(int rm, String nome, String sobrenome, String cpf, Date nascimento, String email,
			int turma, String caminhoFoto) {

		model.Aluno objAluno = new model.Aluno();

		objAluno.setRmAluno(rm);
		objAluno.setNomeAluno(nome);
		objAluno.setSobrenomeAluno(sobrenome);
		objAluno.setCpfAluno(cpf);
		objAluno.setNascimentoAluno(nascimento);
		objAluno.setEmailAluno(email);
		objAluno.setTurmaAluno(turma);
		objAluno.setCaminhoFoto(caminhoFoto);
		// objAluno.setAnoAluno(ano);
		// objAluno.setExclusaoAluno(exclusao);

		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		objAlunoDAO.CadastrarAluno(objAluno);

	}

	public static void BuscarAlunoRM(int rm, String tipo) {

		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		model.Aluno objAluno = objAlunoDAO.BuscarAlunoRM(rm);

		if (objAluno != null) {
			model.TurmaDAO objTurmaDAO = new model.TurmaDAO();
			model.Turma objTurma = objTurmaDAO.BuscarTurmaID(objAluno.getTurmaAluno());
			String nomeTurma = objTurma.getCompletoTurma();

			switch (tipo) {
			case "administrador":
				view.Administracao.pnlAlunoCadastro.txtNomeAluno.setText(objAluno.getNomeAluno());
				view.Administracao.pnlAlunoCadastro.txtSobrenomeAluno.setText(objAluno.getSobrenomeAluno());
				view.Administracao.pnlAlunoCadastro.txtCPFAluno.setText(objAluno.getCpfAluno());
				view.Administracao.pnlAlunoCadastro.cbTurmaAluno.setSelectedItem(nomeTurma);
				view.Administracao.pnlAlunoCadastro.txtNascimentoAluno
						.setText(new SimpleDateFormat("dd/MM/yyyy").format(objAluno.getNascimentoAluno()));
				view.Administracao.pnlAlunoCadastro.txtEmailAluno.setText(objAluno.getEmailAluno());
				break;
			case "mensagemAluno":
				view.Aluno.pnlMensagem.emailAluno = objAluno.getEmailAluno();
				break;
			case "mensagemProfessor":
				view.Professor.pnlMensagem.emailAluno = objAluno.getEmailAluno();
				break;
				
			}

		}
	}

	public static void AlterarAluno(int rm, String nome, String sobrenome, String cpf, Date nascimento, String email,
			int turma, String caminhoFoto) {
		model.Aluno objAluno = new model.Aluno();

		objAluno.setRmAluno(rm);
		objAluno.setNomeAluno(nome);
		objAluno.setSobrenomeAluno(sobrenome);
		objAluno.setCpfAluno(cpf);
		objAluno.setNascimentoAluno(nascimento);
		objAluno.setEmailAluno(email);
		objAluno.setTurmaAluno(turma);
		objAluno.setCaminhoFoto(caminhoFoto);

		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		objAlunoDAO.AlterarAluno(objAluno);
	}

	public static void AlterarEstadoAluno(int rm, int status) {
		model.Aluno objAluno = new model.Aluno();

		objAluno.setRmAluno(rm);
		objAluno.setStatusAluno(status);

		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		objAlunoDAO.AlterarEstadoAluno(objAluno);

	}

	public static boolean BuscarAlunoRMValidacao(int rm) {
		model.AlunoDAO objAluno = new model.AlunoDAO();
		if (objAluno.BuscarAlunoRMValidacao(rm)) {
			return true;
		}

		return false;
	}

	public static boolean CaminhoFoto(int rm) {
		model.Aluno objAluno = new model.Aluno();
		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		String caminhoFoto = objAlunoDAO.CaminhoFoto(rm);
		if (caminhoFoto != null) {
			ImageIcon image = new ImageIcon(caminhoFoto);
			view.Administracao.pnlAlunoCadastro.lblFoto.setIcon(new ImageIcon(
					image.getImage().getScaledInstance(view.Administracao.pnlAlunoCadastro.lblFoto.getWidth(),
							view.Administracao.pnlAlunoCadastro.lblFoto.getHeight(), Image.SCALE_DEFAULT)));
			return true;
		} else {

		}

		return false;
	}

	public static List carregaAlunos(int idTurma) {
		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		List<Aluno> objNota = objAlunoDAO.listarTodosAlunos(idTurma);

		return objNota;
	}

	public static void ConsultaAlunos() {

		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		listaAluno = objAlunoDAO.ConsultaAluno();
		if (listaAluno != null) {
			view.Administracao.pnlAlunoConsulta.tableAluno.setModel(new AlunoTableModel(listaAluno));
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(0).setMaxWidth(90); // rm
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(1).setMaxWidth(200); // nome
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(2).setMaxWidth(200); // sobrenome
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(3).setMaxWidth(200); // cpf
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(4).setMaxWidth(150); // nascimento
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(5).setMaxWidth(350); // email
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(6).setMaxWidth(150); // turma
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(7).setMaxWidth(60); // status

		}

	}

	public static void ConsultaAlunosExcluido() {

		model.AlunoDAO objAlunoDAO = new model.AlunoDAO();
		listaAluno = objAlunoDAO.ConsultaAlunoExcluido();
		if (listaAluno != null) {
			view.Administracao.pnlAlunoConsulta.tableAluno.setModel(new AlunoTableModel(listaAluno));
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(0).setMaxWidth(90); // rm
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(1).setMaxWidth(200); // nome
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(2).setMaxWidth(200); // sobrenome
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(3).setMaxWidth(200); // cpf
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(4).setMaxWidth(150); // nascimento
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(5).setMaxWidth(350); // email
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(6).setMaxWidth(150); // turma
			view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(7).setMaxWidth(60); // status

		}

	}

	/*
	 * public static void carregaTodosCargos() {
	 * 
	 * model.AlunoDAO objAlunoDAO = new model.AlunoDAO(); listaAluno = new
	 * model.AlunoDAO().listarTodosAlunos();
	 * 
	 * if(listaAluno != null) {
	 * view.Administracao.pnlAlunoConsulta.tableAluno.setModel(new
	 * ModeloTabela(listaAluno)); // DEFINE A LARGURA DA COLUNA NA TABELA.
	 * view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(0)
	 * .setMaxWidth(55);
	 * view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(1)
	 * .setMaxWidth(290);
	 * view.Administracao.pnlAlunoConsulta.tableAluno.getColumnModel().getColumn(2)
	 * .setMaxWidth(50); }
	 * 
	 * 
	 * }
	 */

}

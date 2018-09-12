package control;

import javax.swing.ImageIcon;
import java.awt.Image;

public class HorarioControl {

	public static void CadastrarHorario(int turma, String caminho) {
		model.Horario objHorario = new model.Horario();

		objHorario.setId_Turma(turma);
		objHorario.setCaminhoHorario(caminho);

		model.HorarioDAO objHorarioDAO = new model.HorarioDAO();
		objHorarioDAO.CadastrarHorario(objHorario);
	}

	public static void BuscarHorarioTurma(int codigo, String tipo) {
		model.HorarioDAO objHorarioDAO = new model.HorarioDAO();
		model.Horario objHorario = objHorarioDAO.BuscarHorarioTurma(codigo);

		if (objHorario != null) {

			ImageIcon image;
			if (objHorario.getCaminhoHorario() != null) {
				image = new ImageIcon(objHorario.getCaminhoHorario());
			} else {
				image = new ImageIcon("/horarios.jpg");
			}

			switch (tipo) {
			case "administrador":
				view.Administracao.pnlHorario.lblFoto.setIcon(new ImageIcon(image.getImage()));
				view.Administracao.pnlHorario.txtCodigo.setText(String.valueOf(objHorario.getId_Horario()));
				break;
			case "professor":
				view.Professor.pnlHorario.lblFoto.setIcon(new ImageIcon(image.getImage()));
				break;
			case "aluno":
				view.Aluno.pnlHorario.lblFoto.setIcon(new ImageIcon(image.getImage()));
				break;
			}
		}

	}

	public static boolean ValidarHorario(int turma) {
		model.HorarioDAO objHorarioDAO = new model.HorarioDAO();
		if (objHorarioDAO.ValidarHorario(turma)) {
			return true;

		} else {
			return false;
		}
	}

	private static String getResource(String caminhoHorario) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void AlterarHorario(int codigo, int turma, String caminho) {
		model.Horario objHorario = new model.Horario();

		objHorario.setId_Horario(codigo);
		objHorario.setId_Turma(turma);
		objHorario.setCaminhoHorario(caminho);

		model.HorarioDAO objHorarioDAO = new model.HorarioDAO();
		objHorarioDAO.AlterarHorario(objHorario);
	}

	public static void ExcluirHorario(int codigo) {
		model.HorarioDAO objHorarioDAO = new model.HorarioDAO();
		objHorarioDAO.ExcluirHorario(codigo);
	}

	public static void RecuperarHorario(int codigo) {
		model.HorarioDAO objHorarioDAO = new model.HorarioDAO();
		objHorarioDAO.RecuperarHorario(codigo);
	}

}

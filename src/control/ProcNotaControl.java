package control;

import java.util.List;

import model.ProcNota;
import tabela.Nota2TableModel;
import tabela.NotaProfessorTableModel;
import tabela.NotaTableModel;

public class ProcNotaControl {
	
	private static List<ProcNota> listNota;
	
	public static void ConsultarNota(int rm, int trimestre) {
		model.ProcNotaDAO objNotaDAO = new model.ProcNotaDAO();
		listNota = objNotaDAO.ConsultarNota(rm, trimestre);
		if(listNota != null) {
			view.Aluno.pnlNota.tblNota.setModel(new NotaTableModel(listNota));
		}
	}
	
	public static void ConsultarNota2(int rm, int trimestre) {
		model.ProcNotaDAO objNotaDAO = new model.ProcNotaDAO();
		listNota = objNotaDAO.ConsultarNota2(rm, trimestre);
		if(listNota != null) {
			view.Aluno.pnlNota.tblNota.setModel(new Nota2TableModel(listNota));
		}
	}
	
	public static void ConsultarNotaADM(int rm, int trimestre) {
		model.ProcNotaDAO objNotaDAO = new model.ProcNotaDAO();
		listNota = objNotaDAO.ConsultarNota(rm, trimestre);
		if(listNota != null) {
			view.Administracao.pnlNota.tblNota.setModel(new NotaTableModel(listNota));
		}
	}
	
	public static void ConsultarNotaADM2(int rm, int trimestre) {
		model.ProcNotaDAO objNotaDAO = new model.ProcNotaDAO();
		listNota = objNotaDAO.ConsultarNota2(rm, trimestre);
		if(listNota != null) {
			view.Administracao.pnlNota.tblNota.setModel(new Nota2TableModel(listNota));
		}
	}
	
	public static void ConsultarJasper(int rm, int trimestre) {
		model.ProcNotaDAO objNotaDAO = new model.ProcNotaDAO();
		objNotaDAO.ConsultaJasper(rm, trimestre);
	}
	
	public static void ConsultarNotaProfessor(int codigo, String trimestre) {
		model.ProcNotaDAO objNotaDAO = new model.ProcNotaDAO();
		listNota = objNotaDAO.ConsultarNotaProfessor(codigo, trimestre);
		if(listNota != null) {
			view.Professor.pnlNotaConsulta.tblNota.setModel(new NotaProfessorTableModel(listNota));
		}
	}
	
	public static void ConsultarNotaProfessorAvaliacao(int codigo, String trimestre, String avaliacao) {
		model.ProcNotaDAO objNotaDAO = new model.ProcNotaDAO();
		listNota = objNotaDAO.ConsultarNotaProfessorAvaliacao(codigo, trimestre, avaliacao);
		if(listNota != null) {
			view.Professor.pnlNotaConsulta.tblNota.setModel(new NotaProfessorTableModel(listNota));
		}
	}

}

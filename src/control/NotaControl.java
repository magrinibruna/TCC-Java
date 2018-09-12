package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Nota;
import model.vwAtribuicao;
import model.vwProfessor;

public class NotaControl {
	
	public static List<Nota> listNota;
	
	public static void InserirNota(int rm, int atrib, int avaliacao, int trim, double nota) throws SQLException {
		
		model.Nota objNota = new model.Nota();
		
		objNota.setId_Aluno(rm);
		objNota.setId_Atrib(atrib);
		objNota.setId_Aval(avaliacao);
		objNota.setTrim(trim);
		objNota.setNota(nota);
			
		model.NotaDAO objNotaDAO = new model.NotaDAO();
		objNotaDAO.InserirNota(objNota);
		
	}
	
	public static void AlterarNota(int rm, int atrib, int avaliacao, int trim, double nota) throws SQLException {
		
		model.Nota objNota = new model.Nota();
		
		objNota.setId_Aluno(rm);
		objNota.setId_Atrib(atrib);
		objNota.setId_Aval(avaliacao);
		objNota.setTrim(trim);
		objNota.setNota(nota);
			
		model.NotaDAO objNotaDAO = new model.NotaDAO();
		objNotaDAO.AlterarNota(objNota);
		
	}
	
	 public static void carregarComboDisciplinaNota(JComboBox<vwProfessor> combo, int codigoProfessor) {
		 
		 model.NotaDAO objNotaDAO = new model.NotaDAO();
		 
		 try {
			
			 Vector<vwProfessor> vwprofessor = objNotaDAO.carregarComboDisciplinaNota(codigoProfessor);
			 combo.setModel(new DefaultComboBoxModel<vwProfessor>(vwprofessor));
			 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 
		 
	 }
	 
	 public static void carregarComboTurmaNota(JComboBox<vwAtribuicao> combo, int codigoAtribuicao) {
		 
		 model.NotaDAO objNotaDAO = new model.NotaDAO();
		 
		 try {
			
			 Vector<vwAtribuicao> atribuicao = objNotaDAO.carregarComboTurmaNota(codigoAtribuicao);
			 combo.setModel(new DefaultComboBoxModel<vwAtribuicao>(atribuicao));
			 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		 
		 
	 }

	 
	 public static List<Nota> listarNotas(int rm, int atrib, int aval, int trim) {
		 
		 model.NotaDAO objNotaDAO = new model.NotaDAO();
		 List<Nota> listNota = objNotaDAO.listarNotas(rm, atrib, aval, trim);
		 
		 List<Nota> listVazia = new ArrayList<Nota>();
		 
		if(listNota != listVazia) {
		 return listNota;
		 } else {
		  
		return null;
		
		 }
		 
	 } 
	 
	 public static boolean ValidarAvaliacao(int idatribt, int aval, int trim, int rm) {
		 
		 model.NotaDAO objNotaDAO = new model.NotaDAO();
		 if(objNotaDAO.ValidarAvaliacao(idatribt, aval, trim, rm)) {
			 return true;
		 } else {
			 return false;
		 }
		 
	 }
}

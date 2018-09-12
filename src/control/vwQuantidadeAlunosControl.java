package control;

import java.text.SimpleDateFormat;

public class vwQuantidadeAlunosControl {
	
	
	public static void QuantidadeAlunos(int idturma) {
		
		model.vwQuantidadeAlunosDAO objvwQuantidadeAlunosDAO = new model.vwQuantidadeAlunosDAO();
		model.vwQuantidadeAlunos objvwQuantidadeAlunos  = objvwQuantidadeAlunosDAO.QuantidadeAlunos(idturma);
		
		try {
			view.Professor.pnlNota.quantidadeAlunos = objvwQuantidadeAlunos.getQuantidadeAlunos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//System.out.println(objvwQuantidadeAlunos.getQuantidadeAlunos());
		
	}

}

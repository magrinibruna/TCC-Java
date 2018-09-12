package control;

public class AnoLetivoControl {
	
	public static void CadastrarAnoLetivo(String nome) {
		
		model.AnoLetivo objAnoLetivo = new model.AnoLetivo();
		objAnoLetivo.setAno(nome);
		model.AnoLetivoDAO objAnoLetivoDAO = new model.AnoLetivoDAO();
		objAnoLetivoDAO.CadastrarAnoLetivo(objAnoLetivo);
		
	}

}

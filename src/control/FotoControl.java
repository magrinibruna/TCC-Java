package control;

public class FotoControl {

	public void CadastrarFoto(int rm, String caminho) {
		
		model.Foto objFoto = new model.Foto();
		
		objFoto.setRmAluno(rm);
		objFoto.setCaminhoFoto(caminho);
		
		model.FotoDAO objDAOFoto = new model.FotoDAO();
		objDAOFoto.CadastrarFoto(objFoto);
		
		
	} 
	
}

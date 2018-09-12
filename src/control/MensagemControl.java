package control;

public class MensagemControl {
	
	public static void CadastrarMensagem(int envAluno, int envProfessor, int recebeAluno, int recebeTurma, int recebeProfessor, String assunto, String mensagem) {
		
		model.Mensagem objMensagem = new model.Mensagem();
		
		objMensagem.setEnviaMensagem_Aluno(envAluno);
		objMensagem.setEnviaMensagem_Professor(envProfessor);
		objMensagem.setRecebeMensagem_Aluno(recebeAluno);
		objMensagem.setRecebeMensagem_Professor(recebeProfessor);
		objMensagem.setRecebeMensagem_Turma(recebeTurma);
		objMensagem.setAssuntoMensagem(assunto);
		objMensagem.setDescricaoMensagem(mensagem);

		
		model.MensagemDAO objMensagemDAO = new model.MensagemDAO();
		objMensagemDAO.CadastrarMensagem(objMensagem);
		
		
	}
	

}

package control;

import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import model.Atribuicao;
import tabela.AtribuicaoTableModel;

public class AtribuicaoControl {
	
	private static List<Atribuicao> listAtribuicao;

	public static void CadastrarAtribuicao(int idprof, int iddisc, String nome) {

		model.Atribuicao objAtribuicao = new model.Atribuicao();

		objAtribuicao.setId_Prof(idprof);
		objAtribuicao.setId_disc(iddisc);
		objAtribuicao.setNome(nome);

		model.AtribuicaoDAO objAtribuicaoDAO = new model.AtribuicaoDAO();
		objAtribuicaoDAO.CadastrarAtribuicao(objAtribuicao);

	}

	public static void BuscarAtribuicaoNome(String nome, String tipo) {

		model.AtribuicaoDAO objAtribuicaoDAO = new model.AtribuicaoDAO();
		model.Atribuicao objAtribuicao = objAtribuicaoDAO.BuscarAtribuicaoNome(nome);

		switch (tipo) {
		case "relacionamento":
			view.Administracao.pnlRelacionamento.idAtribuicao = objAtribuicao.getId_Atrib();
			break;

		case "nota":
			view.Professor.pnlNota.codigoAtribuicao = objAtribuicao.getId_Atrib();
			break;
			
		case "nota2":
			view.Professor.pnlNotaConsulta.codigoAtribuicao = objAtribuicao.getId_Atrib();
			break;

		}

	}

	public static void carregarComboAtribuicao(JComboBox<Atribuicao> combo) {

		model.AtribuicaoDAO objAtribuicaoDAO = new model.AtribuicaoDAO();

		try {

			Vector<Atribuicao> vAtribuicao = objAtribuicaoDAO.carregarComboAtribuicao();
			combo.setModel(new DefaultComboBoxModel<Atribuicao>(vAtribuicao));

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static boolean AtribuicaoValidacao(String nome) {

		model.AtribuicaoDAO objAtribuicaoDAO = new model.AtribuicaoDAO();
		if (objAtribuicaoDAO.AtribuicaoValidacao(nome)) {
			return false;
		} else {
			return true;
		}
	}

	public static void ConsultarAtribuicao() {
		model.AtribuicaoDAO objAtribuicaoDAO = new model.AtribuicaoDAO();
		listAtribuicao = objAtribuicaoDAO.ConsultarAtribuicao();
		if(listAtribuicao != null) {
			view.Administracao.pnlAtribuicaoConsulta.tblAtribuicao.setModel(new AtribuicaoTableModel(listAtribuicao));
		}

	}

}

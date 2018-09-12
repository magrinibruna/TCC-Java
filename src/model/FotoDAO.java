package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class FotoDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Foto objFoto;
	
	public int CadastrarFoto(Foto objFoto)
	// privacidade
	// static ou não
	// tipo (Funcionario, int, void - se for void, não precisa do return- )
	// nome do método
	{
		int resultado = 0;
		String SQL = "INSERT INTO tb_Foto(id_Aluno, caminhoFoto)" + "VALUES (?, ?)";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setInt(1, objFoto.getRmAluno());
			st.setString(2, objFoto.getCaminhoFoto());
			// st.setDate(4, objCurso.getExclusaoCurso());

			resultado = st.executeUpdate();

			if (resultado == 1) {
				//JOptionPane.showMessageDialog(null, "Foto cadastrada com sucesso!");
			}

			conexao.close();
			st.close();
			return resultado;

		} catch (Exception e) {

			try {

				if (conexao != null) {
					conexao.rollback();
				}

			} catch (Exception e1) {

				e1.printStackTrace();

			}

			e.printStackTrace();
		}

		return 0;

	}
	

}

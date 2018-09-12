package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import util.ConnectionFactory;

public class LoginDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Login objLogin;
	// representa a tabela

	
	public Login Logar(String usuario) {

		String SQL = "SELECT * FROM vw_ListaUsuaios WHERE Usuario = ? ";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL
			st.setString(1, usuario);
			// 1 representa o primeiro simbolo de interrogação que aparece na linha de
			// código
			rs = st.executeQuery();
			if (rs.next()) {
				// se o rs vir vazio, ele recebe 0, logo, vai pro else, se encotnrar recebe 1,
				// executando o if
				objLogin = new Login();
				objLogin.setUsuarioLogin(rs.getString(1));
				objLogin.setSenhaLogin(rs.getString(2));
				objLogin.setCodigoLogin(rs.getInt(3));
				objLogin.setNhLogin(rs.getInt(4));
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objLogin;
	}
	
	/*public Login Logar(String usuario) {

		String SQL = "SELECT * FROM tb_Login WHERE UserLogin = ? ";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL
			st.setString(1, usuario);
			// 1 representa o primeiro simbolo de interrogação que aparece na linha de
			// código
			rs = st.executeQuery();
			if (rs.next()) {
				// se o rs vir vazio, ele recebe 0, logo, vai pro else, se encotnrar recebe 1,
				// executando o if
				objLogin = new Login();
				objLogin.setCodigoLogin(rs.getInt(1));
				objLogin.setUsuarioLogin(rs.getString(2));
				objLogin.setSenhaLogin(rs.getString(3));
				objLogin.setNhLogin(rs.getInt(4));
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objLogin;
	}*/

	/*public int CadastrarLogin(Login objLogin) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Login(UserLogin, SenhaLogin, id_NH)" + "VALUES (?, ?, ?)";

		try {

			st = conexao.prepareStatement(SQL);
			// o st vai enviar por meio da conexão o valor do SQL

			st.setString(1, objLogin.getUsuarioLogin());
			st.setString(2, objLogin.getSenhaLogin());
			st.setInt(3, objLogin.getNhLogin());

			resultado = st.executeUpdate();
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
	}*/

	public int AlterarSenha(Login objLogin) {
		int resultado = 0;
		String SQL = "UPDATE tb_Login SET SenhaLogin = ? WHERE UserLogin = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setString(1, objLogin.getSenhaLogin());
			st.setString(2, objLogin.getUsuarioLogin());

			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
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
		return resultado;

	}

}

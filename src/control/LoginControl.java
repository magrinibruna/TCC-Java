package control;

import javax.swing.JOptionPane;

public class LoginControl {

	public static void Logar(String usuario) {

		model.LoginDAO objLoginDAO = new model.LoginDAO();
		model.Login objLogin = objLoginDAO.Logar(usuario);

		// model.LoginDAO objLoginDAO = new model.LoginDAO();
		// objLoginDAO.Logar(usuario);
		try {
			String usuarioBanco = objLogin.getUsuarioLogin();
			String senhaBanco = objLogin.getSenhaLogin();
			int codigo = objLogin.getCodigoLogin();
			int nhBanco = objLogin.getNhLogin();

			String usuarioForm = view.Login.frmLogin.txtUsuario.getText();
			String senhaForm = view.Login.frmLogin.txtSenha.getText();

			if ((usuarioBanco.equals(usuarioForm)) && (senhaBanco.equals(senhaForm))) {

				view.Administracao.frmAdministracao frmAdministracao = new view.Administracao.frmAdministracao();
				view.Login.frmLogin frmLogin = new view.Login.frmLogin();
				view.Login.frmLoginAlterar frmLoginAlterar = new view.Login.frmLoginAlterar();

				int resultado = 0;

				switch (nhBanco) {
				case 1: /* administrador */
					frmAdministracao.abreForm();
					frmLogin.Administrador();
					break;
				case 2: /* professor */
					if (senhaBanco.equals("123")) {
						// método alterar deternmina se a tela de Login será fechada
						frmLogin.Alterar();
						// abrir o formularío de alterar senha
						frmLoginAlterar.abreForm();
						// enviar valores necessários para o formulário de alterar senha
						frmLoginAlterar.usuario = usuarioForm;
						frmLoginAlterar.nhBanco = nhBanco;

					} else {
						view.Professor.frmProfessor frmProfessor = new view.Professor.frmProfessor();
						frmProfessor.abreForm();
						frmLogin.Professor();

						view.Professor.pnlNota.codigoProfesor = codigo;
						view.Professor.pnlMensagem.codigoProfessor = codigo;
						view.Professor.frmProfessor.codigoProfessor = codigo;

					}
					break;
				case 3: /* aluno */
					if (senhaBanco.equals("123")) {

						// método alterar deternmina se a tela de Login será fechada
						frmLogin.Alterar();
						// abrir o formularío de alterar senha
						frmLoginAlterar.abreForm();
						// enviar valores necessários para o formulário de alterar senha
						frmLoginAlterar.usuario = usuarioForm;
						frmLoginAlterar.nhBanco = nhBanco;

					} else {

						frmLogin.Aluno();
						view.Aluno.frmAluno frmAluno = new view.Aluno.frmAluno();
						frmAluno.abrirForm();

						view.Aluno.pnlNota.rm = codigo;
						view.Aluno.frmAluno.rm = codigo;
						view.Aluno.pnlMensagem.codigoAluno = codigo;
						view.Aluno.pnlSugestao.IDUsuario = codigo;
					}

					break;

				}

			} else {

				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");

			}
		} catch (Exception e) {

		}

	}

	/*
	 * public static void CadastrarLogin(String usuario, String senha, int nh) {
	 * 
	 * model.Login objLogin = new model.Login();
	 * 
	 * objLogin.setUsuarioLogin(usuario); objLogin.setSenhaLogin(senha);
	 * objLogin.setNhLogin(nh);
	 * 
	 * model.LoginDAO objLoginDAO = new model.LoginDAO();
	 * objLoginDAO.CadastrarLogin(objLogin);
	 * 
	 * }
	 */

	public static void AlterarSenha(String senhaForm, String usuarioForm) {

		// String usuarioForm = view.Administracao.frmLogin.txtUsuario.getText();
		// String senhaForm = view.Administracao.frmLogin.txtSenha.getText();
		model.Login objLogin = new model.Login();

		objLogin.setSenhaLogin(senhaForm);
		objLogin.setUsuarioLogin(usuarioForm);

		model.LoginDAO objLoginDAO = new model.LoginDAO();
		objLoginDAO.AlterarSenha(objLogin);

	}

}

package view.Login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class frmLoginAlterar extends JFrame {

	private JPanel contentPane;
	public static JPasswordField txtSenha;
	public static JTextField txtUsuario;
	public static String usuario = "";
	public static int nhBanco = 0;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { frmLoginAlterar frame = new
	 * frmLoginAlterar(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public static void abreForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginAlterar frame = new frmLoginAlterar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLoginAlterar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAlterarSenha = new JButton("Alterar");
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtSenha.getText().trim().length() != 0) {
					switch (nhBanco) {
					/*
					 * case the password still abcdef(textbook/pattern), it will not be permited to
					 * change, else, the password will be changed
					 */
					case 2:
						if (txtSenha.getText().equals("abcdef")) {
							JOptionPane.showMessageDialog(null, "Por questões de segurança, a senha deve ser alterada");
							txtSenha.setText("");
							txtSenha.requestFocus();
						} else {
							control.LoginControl objLoginControl = new control.LoginControl();
							objLoginControl.AlterarSenha(txtSenha.getText(), txtUsuario.getText());

							new view.Login.frmLogin().txtSenha.setText("");
							new view.Login.frmLogin().txtSenha.requestFocus();
							new view.Login.frmLogin().txtUsuario.setText(usuario);
							dispose();
						}
						break;
					/*
					 * case the password still 123456(textbook/pattern), it will not be permited to
					 * change, else, the password will be changed
					 */
					case 3:
						if (txtSenha.getText().equals("123456")) {
							JOptionPane.showMessageDialog(null, "Por questões de segurança, a senha deve ser alterada");
							txtSenha.setText("");
							txtSenha.requestFocus();
						} else {
							control.LoginControl objLoginControl = new control.LoginControl();
							objLoginControl.AlterarSenha(txtSenha.getText(), txtUsuario.getText());
							
							new view.Login.frmLogin().txtSenha.setText("");
							new view.Login.frmLogin().txtSenha.requestFocus();
							new view.Login.frmLogin().txtUsuario.setText(usuario);
							dispose();
						}

					}
				} else {
					JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");
				}

			}
		});
		btnAlterarSenha.setFont(new Font("Microsoft MHei", Font.PLAIN, 20));
		btnAlterarSenha.setBounds(126, 185, 106, 35);
		contentPane.add(btnAlterarSenha);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Microsoft MHei", Font.PLAIN, 18));
		txtSenha.setColumns(10);
		txtSenha.setBounds(50, 126, 156, 31);
		txtSenha.grabFocus();
		contentPane.add(txtSenha);

		JLabel lblNovaSenha = new JLabel("Nova senha:");
		lblNovaSenha.setFont(new Font("Microsoft MHei", Font.PLAIN, 18));
		lblNovaSenha.setBounds(50, 100, 148, 31);
		contentPane.add(lblNovaSenha);

		txtUsuario = new JTextField(usuario);
		txtUsuario.setFont(new Font("Microsoft MHei", Font.PLAIN, 18));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(50, 71, 156, 31);
		txtUsuario.setEditable(false);
		contentPane.add(txtUsuario);

		JLabel label_1 = new JLabel("Usu\u00E1rio:");
		label_1.setFont(new Font("Microsoft MHei", Font.PLAIN, 18));
		label_1.setBounds(50, 43, 70, 31);
		contentPane.add(label_1);

		JLabel lblAltereSuaSenha = new JLabel("Altere sua senha");
		lblAltereSuaSenha.setFont(new Font("Microsoft MHei", Font.PLAIN, 20));
		lblAltereSuaSenha.setBounds(50, 11, 156, 31);
		contentPane.add(lblAltereSuaSenha);
	}
}

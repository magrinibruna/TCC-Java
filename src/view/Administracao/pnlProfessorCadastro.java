package view.Administracao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import java.awt.Color;

public class pnlProfessorCadastro extends JPanel {
	public static JTextField txtCodigoProfessor;
	public static JTextField txtNomeProfessor;
	public static JTextField txtEmailProfessor;
	public static JFormattedTextField txtCPFProfessor;
	MaskFormatter cpf;
	public static JTextField txtSobrenomeProfessor;

	public static JLabel vCodigo;
	public static JLabel vNome;
	public static JLabel vSobrenome;
	public static JLabel vCPF;
	public static JLabel vEmail;

	/**
	 * Create the panel.
	 */

	public pnlProfessorCadastro() {
		setBackground(Color.WHITE);
		setLayout(null);

		try {

			cpf = new MaskFormatter("###.###.###-##");
			cpf.setValidCharacters("0123456789");

		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCdigo.setBounds(430, 62, 121, 35);
		add(lblCdigo);

		txtCodigoProfessor = new JTextField();
		txtCodigoProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCodigoProfessor.setColumns(10);
		txtCodigoProfessor.setBounds(430, 96, 149, 36);
		add(txtCodigoProfessor);

		txtNomeProfessor = new JTextField();
		txtNomeProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNomeProfessor.setColumns(10);
		txtNomeProfessor.setBounds(430, 180, 212, 36);
		add(txtNomeProfessor);

		JLabel label_2 = new JLabel("Nome");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_2.setBounds(430, 143, 121, 35);
		add(label_2);

		JLabel label_3 = new JLabel("CPF");
		label_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_3.setBounds(430, 227, 91, 29);
		add(label_3);

		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_4.setBounds(431, 296, 120, 33);
		add(label_4);

		txtEmailProfessor = new JTextField();
		txtEmailProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtEmailProfessor.setColumns(10);
		txtEmailProfessor.setBounds(430, 331, 505, 36);
		add(txtEmailProfessor);

		JButton btnLimparProfessor = new JButton("Limpar");
		btnLimparProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparProfessor();
			}
		});
		btnLimparProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimparProfessor.setBounds(895, 406, 160, 55);
		add(btnLimparProfessor);

		JButton btnExcluirProfessor = new JButton("Excluir");
		btnExcluirProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarProfessor() == 1) {

					if (control.ProfessorControl
							.ProfessorCodigoValidacao(Integer.parseInt(txtCodigoProfessor.getText().trim()))) {
						control.ProfessorControl.AlterarEstadoProfessor(Integer.parseInt(txtCodigoProfessor.getText()),
								0);
						LimparProfessor();
					} else {
						JOptionPane.showMessageDialog(null, "Professxrx não existe");
					}
				}
				
				
			}
		});
		btnExcluirProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnExcluirProfessor.setBounds(708, 406, 160, 55);
		add(btnExcluirProfessor);

		JButton btnAlterarProfessor = new JButton("Alterar");
		btnAlterarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarProfessor() == 1) {

					if (control.ProfessorControl
							.ProfessorCodigoValidacao(Integer.parseInt(txtCodigoProfessor.getText().trim()))) {
						control.ProfessorControl.AlterarProfessor(Integer.parseInt(txtCodigoProfessor.getText().trim()),
								txtNomeProfessor.getText().trim(), txtSobrenomeProfessor.getText().trim(),
								txtCPFProfessor.getText().replace(".", "").replace("-", ""),
								txtEmailProfessor.getText().trim());

						LimparProfessor();
					} else {
						JOptionPane.showMessageDialog(null, "Professxrx não existe");
					}
				}

			}
		});
		btnAlterarProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnAlterarProfessor.setBounds(518, 406, 160, 55);
		add(btnAlterarProfessor);

		JButton btnGravarProfessor = new JButton("Gravar");
		btnGravarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarProfessor() == 1) {

					if (txtCodigoProfessor.getText().length() == 3) {

						if (control.ProfessorControl
								.ProfessorCodigoValidacao(Integer.parseInt(txtCodigoProfessor.getText().trim()))) {

							JOptionPane.showMessageDialog(null, "Professxrx já existe");

						} else {
							control.ProfessorControl.CadastrarProfessor(
									Integer.parseInt(txtCodigoProfessor.getText().trim()),
									txtNomeProfessor.getText().trim(), txtSobrenomeProfessor.getText().trim(),
									txtCPFProfessor.getText().replace(".", "").replace("-", ""),
									txtEmailProfessor.getText().trim());

							/*
							 * control.LoginControl.CadastrarLogin( txtCodigoProfessor.getText(), "abcdef",
							 * 2);
							 */

							LimparProfessor();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Codigo inválido");
						txtCodigoProfessor.requestFocus();
					}
				}

			}
		});
		btnGravarProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarProfessor.setBounds(331, 406, 160, 55);
		add(btnGravarProfessor);

		txtCPFProfessor = new JFormattedTextField(cpf);
		txtCPFProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCPFProfessor.setColumns(10);
		txtCPFProfessor.setBounds(430, 257, 212, 36);
		add(txtCPFProfessor);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtCodigoProfessor.getText().trim().length() != 0) {

					if (control.ProfessorControl
							.ProfessorCodigoValidacao(Integer.parseInt(txtCodigoProfessor.getText().trim()))) {
						control.ProfessorControl.BuscarProfessorCodigo(Integer.parseInt(txtCodigoProfessor.getText()),
								"administracao");
					} else {
						JOptionPane.showMessageDialog(null, "Professxrx não existe");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");
				}
			}
		});
		btnPesquisar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnPesquisar.setBounds(601, 96, 131, 36);
		add(btnPesquisar);

		txtSobrenomeProfessor = new JTextField();
		txtSobrenomeProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtSobrenomeProfessor.setColumns(10);
		txtSobrenomeProfessor.setBounds(685, 180, 196, 36);
		add(txtSobrenomeProfessor);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblSobrenome.setBounds(685, 146, 184, 28);
		add(lblSobrenome);

		JLabel lblCadastroDeProfessor = new JLabel("Cadastro de Professor");
		lblCadastroDeProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeProfessor.setBounds(549, 11, 319, 40);
		add(lblCadastroDeProfessor);

		vCodigo = new JLabel("*");
		vCodigo.setForeground(Color.RED);
		vCodigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vCodigo.setBounds(402, 96, 28, 35);
		add(vCodigo);

		vNome = new JLabel("*");
		vNome.setForeground(Color.RED);
		vNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vNome.setBounds(402, 181, 28, 35);
		add(vNome);

		vSobrenome = new JLabel("*");
		vSobrenome.setForeground(Color.RED);
		vSobrenome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vSobrenome.setBounds(662, 180, 28, 35);
		add(vSobrenome);

		vCPF = new JLabel("*");
		vCPF.setForeground(Color.RED);
		vCPF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vCPF.setBounds(402, 257, 28, 35);
		add(vCPF);

		vEmail = new JLabel("*");
		vEmail.setForeground(Color.RED);
		vEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vEmail.setBounds(402, 331, 28, 35);
		add(vEmail);

	}

	public int ValidarProfessor() {
		int validar = 0;

		if ((txtCodigoProfessor.getText().trim().length() == 3) && (txtNomeProfessor.getText().trim().length() != 0)
				&& (txtSobrenomeProfessor.getText().trim().length() != 0)
				&& (txtCPFProfessor.getText().trim().length() != 0)
				&& (txtEmailProfessor.getText().trim().length() != 0))

		{
			validar = 1;
		} else {
			
			JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");

			if (txtCodigoProfessor.getText().trim().length() != 3) {
				vCodigo.setVisible(true);
			} else {
				vCodigo.setVisible(false);
			}

			if (txtNomeProfessor.getText().trim().length() == 0) {
				vNome.setVisible(true);
			} else {
				vNome.setVisible(false);
			}
			
			if(txtSobrenomeProfessor.getText().trim().length() == 0) {
				vSobrenome.setVisible(true);
			} else {
				vSobrenome.setVisible(false);
			}

			if (txtCPFProfessor.getText().trim().length() < 10) {
				vCPF.setVisible(true);
			} else {
				vCPF.setVisible(false);
			}

			if (txtEmailProfessor.getText().trim().length() == 0) {
				vEmail.setVisible(true);
			} else {
				vEmail.setVisible(false);
			}
		}

		return validar;
	}

	public static void LimparProfessor() {
		
		txtCodigoProfessor.setText("");
		vCodigo.setVisible(false);
		
		txtNomeProfessor.setText("");
		vNome.setVisible(false);
		
		txtSobrenomeProfessor.setText("");
		vSobrenome.setVisible(false);
		
		txtCPFProfessor.setText("");
		vCPF.setVisible(false);
		
		txtEmailProfessor.setText("");
		vEmail.setVisible(false);
	}
}

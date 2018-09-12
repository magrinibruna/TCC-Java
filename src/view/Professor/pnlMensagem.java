package view.Professor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.mail.EmailException;

import model.Turma;

public class pnlMensagem extends JPanel {

	public static JTable tblMensagem;

	public static int Destinario = 0;
	public static int codigoTurma = 0;
	public static int codigoProfessor = 0;
	String Assunto = "";
	public static String emailAluno = "";
	public static String emailProfessor = "";

	public static JRadioButton rdbtnAluno;
	private JRadioButton rdbtnTurma;
	private JRadioButton rdbtnProfessor;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtDestinario;
	public static JComboBox<Turma> cbDestinario;
	private JTextField txtAssunto;
	private JTextArea txtMensagem;

	/**
	 * Create the panel.
	 */
	public pnlMensagem() {

		cbDestinario = new JComboBox<Turma>();

		setBackground(Color.WHITE);
		setLayout(null);

		txtMensagem = new JTextArea();
		txtMensagem.setBackground(Color.LIGHT_GRAY);
		txtMensagem.setRows(10);
		txtMensagem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtMensagem.setBounds(151, 313, 384, 237);
		txtMensagem.setLineWrap(true);
		add(txtMensagem);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Validacao = Validacao();

				if (Validacao == 0) {
				} else {

					Destinario = Destinario();
					if (Destinario == 1) {
						// Aluno

						if (control.AlunoControl.BuscarAlunoRMValidacao(Integer.parseInt(txtDestinario.getText()))) {
							control.MensagemControl.CadastrarMensagem(0, codigoProfessor,

									Integer.parseInt(txtDestinario.getText()), 0, 0, Assunto, txtMensagem.getText());
							control.AlunoControl.BuscarAlunoRM(Integer.parseInt(txtDestinario.getText()),
									"mensagemProfessor");
							try {
								util.MensagemEmail.EmailMensagem(emailAluno);
							} catch (EmailException e1) {
							}

						} else {
							JOptionPane.showMessageDialog(null, "Aluno não existe :[");
						}

					} else if (Destinario == 2) {
						// Turma

						control.TurmaControl.BuscarTurmaNome(cbDestinario.getSelectedItem().toString(),
								"mensagemprofessor");
						control.MensagemControl.CadastrarMensagem(0, codigoProfessor, 0, codigoTurma, 0, Assunto,
								txtMensagem.getText());

					} else {

						boolean validacao = control.ProfessorControl
								.ProfessorCodigoValidacao(Integer.parseInt(txtDestinario.getText()));
						if (validacao == true) {
							control.MensagemControl.CadastrarMensagem(0, codigoProfessor, 0, 0,
									Integer.parseInt(txtDestinario.getText()), Assunto, txtMensagem.getText());
							
							control.ProfessorControl.BuscarProfessorCodigo(Integer.parseInt(txtDestinario.getText()),
									"mensagemProfessor");
							try {
								util.MensagemEmail.EmailMensagem(emailProfessor);
							} catch (EmailException e1) {
							}
							
							
						} else {
							JOptionPane.showMessageDialog(null, "Professor não existe");
						}

					}

					Limpar();

				}

				control.ProcMensagemControl.ConsultarMensagemProfessor(codigoProfessor);

			}
		});
		btnEnviar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnEnviar.setBounds(168, 571, 163, 55);
		add(btnEnviar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(357, 571, 161, 55);
		add(btnLimpar);

		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDestinario.setVisible(true);
				cbDestinario.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnAluno);
		rdbtnAluno.setBackground(Color.WHITE);
		rdbtnAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnAluno.setBounds(168, 125, 116, 23);
		add(rdbtnAluno);

		rdbtnTurma = new JRadioButton("Turma");
		rdbtnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDestinario.setVisible(false);
				cbDestinario.setVisible(true);

				control.TurmaControl.carregarComboTurma(cbDestinario);
			}
		});
		buttonGroup.add(rdbtnTurma);
		rdbtnTurma.setBackground(Color.WHITE);
		rdbtnTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnTurma.setBounds(285, 125, 116, 23);
		add(rdbtnTurma);

		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDestinario.setVisible(true);
				cbDestinario.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnProfessor);
		rdbtnProfessor.setBackground(Color.WHITE);
		rdbtnProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnProfessor.setBounds(403, 125, 115, 23);
		add(rdbtnProfessor);

		JLabel lblMensagens = new JLabel("Mensagens");
		lblMensagens.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblMensagens.setBounds(552, 13, 319, 40);
		add(lblMensagens);

		JLabel lblMinhasMensagens = new JLabel("Minhas mensagens:");
		lblMinhasMensagens.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblMinhasMensagens.setBounds(620, 90, 656, 28);
		add(lblMinhasMensagens);

		JLabel lblNovaMensagem = new JLabel("Nova mensagem:");
		lblNovaMensagem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblNovaMensagem.setBounds(231, 90, 228, 28);
		add(lblNovaMensagem);

		txtDestinario = new JTextField();
		txtDestinario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtDestinario.setColumns(10);
		txtDestinario.setBounds(262, 165, 155, 36);
		add(txtDestinario);

		// cbDestinario = new JComboBox();
		cbDestinario.setToolTipText("");
		cbDestinario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbDestinario.setBounds(262, 166, 155, 35);
		add(cbDestinario);

		txtAssunto = new JTextField();
		txtAssunto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtAssunto.setColumns(10);
		txtAssunto.setBounds(151, 238, 384, 36);
		add(txtAssunto);

		JLabel lblAssunto = new JLabel("Assunto:");
		lblAssunto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblAssunto.setBounds(151, 209, 228, 28);
		add(lblAssunto);

		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblMensagem.setBounds(151, 285, 228, 28);
		add(lblMensagem);

		tblMensagem = new JTable();
		tblMensagem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane_1 = new JScrollPane(tblMensagem);
		scrollPane_1.setBounds(620, 127, 656, 422);
		add(scrollPane_1);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int row = tblMensagem.getSelectedRow();
					txtDestinario.setText(String.valueOf(tblMensagem.getValueAt(row, 0)));
					txtAssunto.setText((String) tblMensagem.getValueAt(row, 3));
					txtMensagem.setText((String) tblMensagem.getValueAt(row, 4));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma mensagem");
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1115, 571, 161, 55);
		add(btnConsultar);

	}

	public int Destinario() {

		if (rdbtnAluno.isSelected()) {
			return 1;
		} else if (rdbtnTurma.isSelected()) {
			return 2;
		} else {
			return 3;
		}

	}

	public void Limpar() {

		txtDestinario.setText("");
		txtAssunto.setText("");
		txtMensagem.setText("");

	}

	int Validacao = 0;

	public int Validacao() {

		if (txtAssunto.getText().trim().length() != 0) {
			Assunto = txtAssunto.getText();
		} else {
			Assunto = "Sem assunto";
		}

		if (txtMensagem.getText().trim().length() != 0) {
			if (rdbtnAluno.isSelected() || rdbtnProfessor.isSelected()) {
				if (txtDestinario.getText().trim().length() != 0) {
					return 1;
				} else {
					JOptionPane.showMessageDialog(null, "É necessário digitar um destinário");
					return 0;
				}

			} else {
				return 1;
			}

		} else {
			JOptionPane.showMessageDialog(null, "É necessário digitar uma mensagem");
			return 0;
		}

	}
}

package view.Aluno;

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
	String Assunto = "";
	public static int codigoTurma = 0;
	public static int codigoAluno = 0;
	public static String emailAluno = "";
	public static String emailProfessor = "";

	private JTextField txtAssunto;
	private JTextArea txtMensagem;
	private JRadioButton rdbtnAluno;
	private JTextField txtDestinario;

	/**
	 * Create the panel.
	 */
	public pnlMensagem() {
		setBackground(Color.WHITE);
		setLayout(null);

		rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDestinario.setVisible(true);
				cbDestinario.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnProfessor);
		rdbtnProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnProfessor.setBackground(Color.WHITE);
		rdbtnProfessor.setBounds(353, 123, 115, 23);
		add(rdbtnProfessor);

		JLabel label = new JLabel("Nova mensagem:");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(206, 88, 228, 28);
		add(label);

		rdbtnAluno = new JRadioButton("Aluno");
		rdbtnAluno.setSelected(true);
		rdbtnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDestinario.setVisible(true);
				cbDestinario.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnAluno);
		rdbtnAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnAluno.setBackground(Color.WHITE);
		rdbtnAluno.setBounds(143, 123, 98, 23);
		add(rdbtnAluno);

		txtDestinario = new JTextField();
		txtDestinario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtDestinario.setColumns(10);
		txtDestinario.setBounds(222, 160, 155, 36);
		add(txtDestinario);

		cbDestinario = new JComboBox<Turma>();
		cbDestinario.setToolTipText("");
		cbDestinario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbDestinario.setBounds(222, 161, 155, 35);
		add(cbDestinario);

		JLabel label_1 = new JLabel("Assunto:");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		label_1.setBounds(126, 207, 228, 28);
		add(label_1);

		txtAssunto = new JTextField();
		txtAssunto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtAssunto.setColumns(10);
		txtAssunto.setBounds(126, 236, 384, 36);
		add(txtAssunto);

		JLabel label_2 = new JLabel("Mensagem:");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		label_2.setBounds(126, 283, 228, 28);
		add(label_2);

		txtMensagem = new JTextArea();
		txtMensagem.setBackground(Color.LIGHT_GRAY);
		txtMensagem.setRows(10);
		txtMensagem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtMensagem.setBounds(126, 311, 384, 237);
		txtMensagem.setLineWrap(true);
		add(txtMensagem);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Validacao = Validacao();

				if (Validacao == 0) {
				} else {

					
					Destinario = Destinario();
					
					System.out.println(Destinario);
					if (Destinario == 1) {
						// Aluno

						if (control.AlunoControl.BuscarAlunoRMValidacao(Integer.parseInt(txtDestinario.getText()))) {
							control.MensagemControl.CadastrarMensagem(codigoAluno, 0,
									Integer.parseInt(txtDestinario.getText()), 0, 0, Assunto, txtMensagem.getText());
							control.AlunoControl.BuscarAlunoRM(Integer.parseInt(txtDestinario.getText()),
									"mensagemAluno");
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
								"mensagemaluno");
						control.MensagemControl.CadastrarMensagem(codigoAluno, 0, 0, codigoTurma, 0, Assunto,
								txtMensagem.getText());

					} else {

						boolean validacao = control.ProfessorControl
								.ProfessorCodigoValidacao(Integer.parseInt(txtDestinario.getText()));
						if (validacao == true) {
							control.MensagemControl.CadastrarMensagem(codigoAluno, 0, 0, 0,
									Integer.parseInt(txtDestinario.getText()), Assunto, txtMensagem.getText());
							control.ProfessorControl.BuscarProfessorCodigo(Integer.parseInt(txtDestinario.getText()),
									"mensagemAluno");
							try {
								util.MensagemEmail.EmailMensagem(emailProfessor);
							} catch (EmailException e1) {
							}

						} else {
							JOptionPane.showMessageDialog(null, "Professor não existe");
						}

					}

				}

				Limpar();

			}
		});
		btnEnviar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnEnviar.setBounds(143, 569, 163, 55);
		add(btnEnviar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(332, 569, 161, 55);
		add(btnLimpar);

		JLabel label_3 = new JLabel("Minhas mensagens:");
		label_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_3.setBounds(613, 88, 273, 28);
		add(label_3);

		JLabel label_4 = new JLabel("Mensagens");
		label_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label_4.setBounds(549, 11, 319, 40);
		add(label_4);

		rdbtnTurma = new JRadioButton("Turma");
		rdbtnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDestinario.setVisible(false);
				cbDestinario.setVisible(true);
				control.TurmaControl.carregarComboTurma(cbDestinario);
			}
		});
		buttonGroup.add(rdbtnTurma);
		rdbtnTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnTurma.setBackground(Color.WHITE);
		rdbtnTurma.setBounds(243, 123, 98, 23);
		add(rdbtnTurma);

		tblMensagem = new JTable();
		tblMensagem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblMensagem);
		scrollPane.setBounds(613, 125, 656, 422);
		add(scrollPane);

		JButton button = new JButton("Consultar");
		button.addActionListener(new ActionListener() {
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
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		button.setBounds(1108, 569, 161, 55);
		add(button);

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
	private JRadioButton rdbtnProfessor;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnTurma;
	private JComboBox<Turma> cbDestinario;

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

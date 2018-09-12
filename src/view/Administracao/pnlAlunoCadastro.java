package view.Administracao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Turma;
import util.ConnectionFactory;

public class pnlAlunoCadastro extends JPanel {

	public static JComboBox<Turma> cbTurmaAluno;
	public static JTextField txtRMAluno;
	public static JTextField txtNomeAluno;
	public static JFormattedTextField txtCPFAluno;
	public static JFormattedTextField txtNascimentoAluno;
	public static JTextField txtEmailAluno;

	public static int idTurma = 0;

	
	String foto = "";
	
	MaskFormatter cpf, nascimento;
	public static JTextField txtSobrenomeAluno;
	public static JLabel lblFoto;
	
	private static JLabel vEmail;
	private static JLabel vCPF;
	private static JLabel vNome;
	private static JLabel vRM;
	private static JLabel vNascimento;
	private static JLabel vTurma;
	private static JLabel vSobrenome;

	/**
	 * Create the panel.
	 */
	public pnlAlunoCadastro() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		cbTurmaAluno = new JComboBox<Turma>();
		control.TurmaControl.carregarComboTurma(cbTurmaAluno);

		try {

			cpf = new MaskFormatter("###.###.###-##");
			cpf.setValidCharacters("0123456789");
			nascimento = new MaskFormatter("##/##/####");
			nascimento.setValidCharacters("0123456789");

		} catch (ParseException e) {
			e.printStackTrace();
		}

		JLabel lblCadastroDeAlunos = new JLabel("Cadastro de Alunos");
		lblCadastroDeAlunos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeAlunos.setBounds(494, 11, 319, 40);
		add(lblCadastroDeAlunos);

		txtRMAluno = new JTextField();
		txtRMAluno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				/*
				 * if(control.AlunoControl.BuscarAlunoRMValidacao(
				 * Integer.parseInt(txtRMAluno.getText()))) {
				 * JOptionPane.showMessageDialog(null, "Alunx já cadastrado"); }
				 */
			}
		});
		txtRMAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtRMAluno.setBounds(212, 116, 165, 35);
		add(txtRMAluno);
		txtRMAluno.setColumns(10);

		JLabel lblRm = new JLabel("RM");
		lblRm.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblRm.setBounds(212, 81, 61, 24);
		add(lblRm);

		txtNomeAluno = new JTextField();
		txtNomeAluno.setBackground(Color.WHITE);
		txtNomeAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(212, 205, 249, 35);
		add(txtNomeAluno);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblNome.setBounds(212, 175, 83, 24);
		add(lblNome);

		txtCPFAluno = new JFormattedTextField(cpf);
		txtCPFAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCPFAluno.setColumns(10);
		txtCPFAluno.setBounds(212, 289, 160, 35);
		add(txtCPFAluno);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCpf.setBounds(212, 261, 63, 27);
		add(lblCpf);

		txtNascimentoAluno = new JFormattedTextField(nascimento);
		txtNascimentoAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNascimentoAluno.setColumns(10);
		txtNascimentoAluno.setBounds(413, 289, 139, 35);
		add(txtNascimentoAluno);

		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblNascimento.setBounds(413, 263, 165, 23);
		add(lblNascimento);

		// cbTurmaAluno = new JComboBox();
		cbTurmaAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbTurmaAluno.setBounds(592, 289, 187, 35);
		add(cbTurmaAluno);

		JLabel lblTurma = new JLabel("Turma");
		lblTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblTurma.setBounds(588, 263, 131, 23);
		add(lblTurma);

		txtEmailAluno = new JTextField();
		txtEmailAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtEmailAluno.setColumns(10);
		txtEmailAluno.setBounds(212, 381, 567, 35);
		add(txtEmailAluno);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblEmail.setBounds(212, 351, 131, 27);
		add(lblEmail);

		JButton btnGravarAluno = new JButton("Gravar");
		btnGravarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarAluno() == 1) {

					boolean resultadoValidacao = control.AlunoControl
							.BuscarAlunoRMValidacao(Integer.parseInt(txtRMAluno.getText()));

					if (resultadoValidacao == false) {
						control.TurmaControl.BuscarTurmaNomeCadastros(cbTurmaAluno.getSelectedItem().toString(),
								"aluno");

						Calendar ano = Calendar.getInstance();

						if (txtRMAluno.getText().length() == 5) {
							control.AlunoControl.CadastrarAluno(Integer.parseInt(txtRMAluno.getText()),
									txtNomeAluno.getText().trim(), txtSobrenomeAluno.getText().trim(),
									txtCPFAluno.getText().replace(".", "").replace("-", ""),
									util.ConnectionFactory.converteData(txtNascimentoAluno), txtEmailAluno.getText(),
									idTurma, foto
							// Integer.toString(ano.get(Calendar.YEAR)),
							);

							control.FotoControl objFotoControl = new control.FotoControl();
							//objFotoControl.CadastrarFoto(Integer.parseInt(txtRMAluno.getText()), c);

							/*
							 * control.LoginControl.CadastrarLogin( txtRMAluno.getText(), "123456", 3);
							 */

							LimparAluno();
						} else {
							JOptionPane.showMessageDialog(null, "RM inválido");
							txtRMAluno.requestFocus();
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Alunx já cadastrado");
					}
				} else {

					JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");

				}

			}
		});

		btnGravarAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarAluno.setBounds(166, 446, 147, 55);
		add(btnGravarAluno);

		JButton btnExcluirAluno = new JButton("Excluir");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtRMAluno.getText().trim().length() != 0) {
					control.AlunoControl.AlterarEstadoAluno(Integer.parseInt(txtRMAluno.getText()), 0);

					LimparAluno();

				} else {
					JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");
					txtRMAluno.requestFocus();
				}

			}
		});
		btnExcluirAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnExcluirAluno.setBounds(522, 446, 147, 55);
		add(btnExcluirAluno);

		JButton btnAlterarAluno = new JButton("Alterar");
		btnAlterarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarAluno() == 1) {

					if (control.AlunoControl.BuscarAlunoRMValidacao(Integer.parseInt(txtRMAluno.getText()))) {

						control.TurmaControl.BuscarTurmaNomeCadastros(cbTurmaAluno.getSelectedItem().toString(),
								"aluno");

						control.AlunoControl.AlterarAluno(Integer.parseInt(txtRMAluno.getText()),
								txtNomeAluno.getText(), txtSobrenomeAluno.getText(),
								txtCPFAluno.getText().replace(".", "").replace("-", ""),
								control.AlunoControl.converteData(txtNascimentoAluno), txtEmailAluno.getText(),
								idTurma, foto);

						LimparAluno();

					} else {
						JOptionPane.showMessageDialog(null, "Alunx não existe");
						txtRMAluno.requestFocus();
					}

				} else {

					JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");
				}
			}

		});
		btnAlterarAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnAlterarAluno.setBounds(342, 446, 147, 55);
		add(btnAlterarAluno);

		JButton btnLimparAluno = new JButton("Limpar");
		btnLimparAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LimparAluno();

			}
		});

		btnLimparAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimparAluno.setBounds(690, 446, 147, 55);
		add(btnLimparAluno);

		
		JButton btnInserirFotoAluno = new JButton("Foto");
		btnInserirFotoAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foto = util.Outros.Imagem(lblFoto);
			}
		});
		btnInserirFotoAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnInserirFotoAluno.setBounds(1000, 440, 160, 61);
		add(btnInserirFotoAluno);

		JButton btnPesquisarAluno = new JButton("Pesquisar");
		btnPesquisarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtRMAluno.getText().trim().length() != 0) {
					control.AlunoControl.BuscarAlunoRM(Integer.parseInt(txtRMAluno.getText()), "administrador");
					
				} else {
					JOptionPane.showMessageDialog(null, "Digte um RM");
					txtRMAluno.requestFocus();
				}

			}
		});
		btnPesquisarAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnPesquisarAluno.setBounds(400, 116, 139, 35);
		add(btnPesquisarAluno);

		JLabel label8 = new JLabel("Foto");
		label8.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label8.setBounds(858, 62, 83, 43);
		add(label8);

		txtSobrenomeAluno = new JTextField();
		txtSobrenomeAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtSobrenomeAluno.setColumns(10);
		txtSobrenomeAluno.setBounds(501, 205, 278, 35);
		add(txtSobrenomeAluno);

		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblSobrenome.setBounds(501, 170, 202, 35);
		add(lblSobrenome);

		lblFoto = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/alunopadrao.png")).getImage();
		lblFoto.setIcon(new ImageIcon(img1));
		lblFoto.setBounds(858, 103, 302, 313);
		add(lblFoto);
		
		vRM = new JLabel("*");
		vRM.setForeground(Color.RED);
		vRM.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vRM.setBounds(183, 116, 28, 35);
		add(vRM);
		
		vNome = new JLabel("*");
		vNome.setForeground(Color.RED);
		vNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vNome.setBounds(183, 205, 28, 35);
		add(vNome);
		
		vSobrenome = new JLabel("*");
		vSobrenome.setForeground(Color.RED);
		vSobrenome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vSobrenome.setBounds(471, 205, 28, 35);
		add(vSobrenome);
		
		vCPF = new JLabel("*");
		vCPF.setForeground(Color.RED);
		vCPF.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vCPF.setBounds(183, 289, 28, 35);
		add(vCPF);
		
		vNascimento = new JLabel("*");
		vNascimento.setForeground(Color.RED);
		vNascimento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vNascimento.setBounds(382, 289, 28, 35);
		add(vNascimento);
		
		vTurma = new JLabel("*");
		vTurma.setForeground(Color.RED);
		vTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vTurma.setBounds(562, 289, 28, 35);
		add(vTurma);
		
		vEmail = new JLabel("*");
		vEmail.setForeground(Color.RED);
		vEmail.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vEmail.setBounds(183, 381, 28, 35);
		add(vEmail);

	}

	public int ValidarAluno() {

		int validar = 0;

		if ((txtRMAluno.getText().trim().length() != 0) && (txtNomeAluno.getText().trim().length() != 0)
				&& (txtSobrenomeAluno.getText().trim().length() != 0) && (txtCPFAluno.getText().trim().length() != 0)
				&& (txtNascimentoAluno.getText().trim().length() != 0) && (txtEmailAluno.getText().trim().length() != 0)
				&& (cbTurmaAluno.getSelectedItem().toString().trim().length() != 0))

		{
			validar = 1;
			
		} else {
			
			validar = 0;
			
			if(txtRMAluno.getText().trim().length() != 5) {
				vRM.setVisible(true);
			} else {
				vRM.setVisible(false);
			}
			
			if(txtNomeAluno.getText().trim().length() == 0) {
				vNome.setVisible(true);
			} else {
				vNome.setVisible(false);
			}
			
			if(txtSobrenomeAluno.getText().trim().length() == 0) {
				vSobrenome.setVisible(true);
			} else {
				vSobrenome.setVisible(false);
			}
			
			if(txtCPFAluno.getText().trim().length() < 10) {
				vCPF.setVisible(true);
			} else {
				vCPF.setVisible(false);
			}
			
			if(txtNascimentoAluno.getText().trim().length() < 5) {
				vNascimento.setVisible(true);
			} else {
				vNascimento.setVisible(false);
			}
			
			if(txtEmailAluno.getText().trim().length() == 0) {
				vEmail.setVisible(true);
			} else {
				vEmail.setVisible(false);
				
			}
			
			/*if(cbTurmaAluno.getSelectedItem().toString() == null) {
				vTurma.setVisible(true);
			}*/
			
		}

		return validar;
	}

	public void LimparAluno() {

		txtRMAluno.setText("");
		vRM.setVisible(false);
		
		txtNomeAluno.setText("");
		vNome.setVisible(false);
		
		txtSobrenomeAluno.setText("");
		vSobrenome.setVisible(false);
		
		txtCPFAluno.setText("");
		vCPF.setVisible(false);
		
		txtNascimentoAluno.setText("");
		vNascimento.setVisible(false);
		
		txtEmailAluno.setText("");
		vEmail.setVisible(false);
		
		cbTurmaAluno.setSelectedIndex(-1);
		vTurma.setVisible(false);
		
		lblFoto.setText("");
		Image img1 = new ImageIcon(this.getClass().getResource("/alunopadrao.png")).getImage();
		lblFoto.setIcon(new ImageIcon(img1));
	}

	public static void ConsultarAluno(int rm) {
		control.AlunoControl.BuscarAlunoRM(rm, "administrador");
		control.AlunoControl.CaminhoFoto(rm);
	}

}

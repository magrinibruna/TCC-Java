package view.Professor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import jxl.read.biff.BiffException;
import model.vwAtribuicao;
import model.vwProfessor;

public class pnlNota extends JPanel {

	public static int quantidadeAlunos = 49;
	public static int validacao = 0;

	public static JTextField txtNota[] = new JTextField[quantidadeAlunos];
	public static JLabel lblRM[] = new JLabel[quantidadeAlunos];
	public static JLabel lblNome[] = new JLabel[quantidadeAlunos];
	public static int codigoNota[] = new int[quantidadeAlunos];

	public static int codigoProfesor = 0;
	public static String nomeProfessor = "";
	public static int codigoAtribuicao = 0;
	public static int codigoAtribuicaoTurma = 0;
	public static int codigoTurma = 0;

	int avaliacao = 0;
	int maiorNota = 0;
	String nAvaliacao = "";
	int trimestre = 0;
	String nTrimestre = "";

	public static JComboBox<vwProfessor> cbDisciplina;
	public static JComboBox<vwAtribuicao> cbTurma;
	private JPanel panel_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPAT;
	public static JRadioButton rdbtnPEM;
	private JRadioButton rdbtnTrabalho;
	private JRadioButton rdbtnAtitudinal;
	private JRadioButton rdbtn1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public static JRadioButton rdbtn3;
	private JRadioButton rdbtn2;
	private JLabel lblCadastroDeNotas;

	/*
	 * private JLabel label_3; private JLabel label_4; private JLabel label_5;
	 * private JLabel label_6; private JLabel label_7; private JLabel label_8;
	 * private JLabel label_9; private JLabel label_10; private JLabel label_11;
	 * private JLabel label_12; private JLabel label_13; private JLabel label_14;
	 * private JLabel label_15; private JLabel label_16; private JLabel label_17;
	 * private JLabel label_18; private JLabel label_19; private JLabel label_20;
	 * private JLabel label_21; private JLabel label_2; private JLabel label_22;
	 * private JLabel label_23;
	 */
	private JPanel painelNome;
	/*
	 * PainelNome
	 * 
	 * private JLabel lblBrunaMagriniDa; private JLabel label_25; private JLabel
	 * label_26; private JLabel label_27; private JLabel label_28; private JLabel
	 * label_29; private JLabel label_30; private JLabel label_31; private JLabel
	 * label_32; private JLabel label_33; private JLabel label_34; private JLabel
	 * label_35; private JLabel label_36; private JLabel label_37; private JLabel
	 * label_38; private JLabel label_39; private JLabel label_40; private JLabel
	 * label_41; private JLabel label_42; private JLabel label_43; private JLabel
	 * label_44; private JLabel label_45; private JLabel label_46; private JLabel
	 * label_47; private JLabel label_48;
	 */

	private JPanel painelNota;
	/*
	 * painelNota
	 * 
	 * private JTextField textField; private JTextField textField_1; private
	 * JTextField textField_2; private JTextField textField_3; private JTextField
	 * textField_4; private JTextField textField_5; private JTextField textField_6;
	 * private JTextField textField_7; private JTextField textField_8; private
	 * JTextField textField_9; private JTextField textField_10; private JTextField
	 * textField_11; private JTextField textField_12; private JTextField
	 * textField_13; private JTextField textField_14; private JTextField
	 * textField_15; private JTextField textField_16; private JTextField
	 * textField_17; private JTextField textField_18; private JTextField
	 * textField_19; private JTextField textField_20; private JTextField
	 * textField_21; private JTextField textField_22; private JTextField
	 * textField_23; private JTextField textField_24;
	 */

	private JPanel painelNome2;
	/*
	 * painelNome2
	 * 
	 * private JLabel label; private JLabel label_1; private JLabel label_2; private
	 * JLabel label_3; private JLabel label_4; private JLabel label_5; private
	 * JLabel label_6; private JLabel label_7; private JLabel label_8; private
	 * JLabel label_9; private JLabel label_10; private JLabel label_11; private
	 * JLabel label_12; private JLabel label_13; private JLabel label_14; private
	 * JLabel label_15; private JLabel label_16; private JLabel label_17; private
	 * JLabel label_18; private JLabel label_19; private JLabel label_20; private
	 * JLabel label_21; private JLabel label_22; private JLabel label_23; private
	 * JLabel label_24;
	 */

	private JPanel painelNota2;
	/*
	 * painelNota2
	 * 
	 * private JTextField textField_25; private JTextField textField_26; private
	 * JTextField textField_27; private JTextField textField_28; private JTextField
	 * textField_29; private JTextField textField_30; private JTextField
	 * textField_31; private JTextField textField_32; private JTextField
	 * textField_33; private JTextField textField_34; private JTextField
	 * textField_35; private JTextField textField_36; private JTextField
	 * textField_37; private JTextField textField_38; private JTextField
	 * textField_39; private JTextField textField_40; private JTextField
	 * textField_41; private JTextField textField_42; private JTextField
	 * textField_43; private JTextField textField_44; private JTextField
	 * textField_45; private JTextField textField_46; private JTextField
	 * textField_47; private JTextField textField_48; private JTextField
	 * textField_49;
	 */
	private JPanel painelRM;
	private JPanel painelRM2;
	private JButton btnLimpar;
	private static JButton btnNota;
	private JButton btnExcel;
	/*
	 * Painel RM 2
	 * 
	 * private JLabel label_49; private JLabel label_50; private JLabel label_51;
	 * private JLabel label_52; private JLabel label_53; private JLabel label_54;
	 * private JLabel label_55; private JLabel label_56; private JLabel label_57;
	 * private JLabel label_58; private JLabel label_59; private JLabel label_60;
	 * private JLabel label_61; private JLabel label_62; private JLabel label_63;
	 * private JLabel label_64; private JLabel label_65; private JLabel label_66;
	 * private JLabel label_67; private JLabel label_68; private JLabel label_69;
	 * private JLabel label_70; private JLabel label_71; private JLabel label_72;
	 * private JLabel label_73;
	 */

	/*
	 * private JTextField textField; private JTextField textField_1; private
	 * JTextField textField_2; private JTextField textField_3; private JTextField
	 * textField_4;
	 */

	/**
	 * Create the panel.
	 */
	public pnlNota() {
		setBackground(Color.WHITE);
		setLayout(null);

		btnNota = new JButton("Gravar");
		btnNota.setEnabled(false);
		btnNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Checar se todos os campos foram preenchidos corretamente
				if (validacao != 0) {

					int contador = 1;

					int contador1 = 1;

					// Descobrir o tipo de avaliação

					if (rdbtnPAT.isSelected()) {
						avaliacao = 1;
						nAvaliacao = "PAT";
						maiorNota = 9;
					} else if (rdbtnPEM.isSelected()) {
						avaliacao = 2;
						nAvaliacao = "PEM";
						maiorNota = 7;
					} else if (rdbtnTrabalho.isSelected()) {
						avaliacao = 3;
						nAvaliacao = "Trabalho";
						maiorNota = 7;
					} else {
						avaliacao = 4;
						nAvaliacao = "Atitudinal";
						maiorNota = 2;
					}

					// Descobrir o trimestre
					int trimestre = 0;
					String nTrimestre = "";
					if (rdbtn1.isSelected()) {
						trimestre = 1;
						nTrimestre = "1º trimestre";
					} else if (rdbtn2.isSelected()) {
						trimestre = 2;
						nTrimestre = "2º trimestre";
					} else {
						trimestre = 3;
						nTrimestre = "3º trimestre";
					}

					try {
						// Criar caixa de confirmação
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null,
								"Você tem certeza que deseja gravar as notas da turma "
										+ cbTurma.getSelectedItem().toString().trim() + ", " + nAvaliacao + ", "
										+ nTrimestre + "?",
								"Confirmação", dialogButton);

						// Se o resultado da caixa for SIM, gravar notas
						if (dialogResult == JOptionPane.YES_OPTION) {

							// Se o botão tiver texto GRAVAR, gravar os alunos
							if (btnNota.getText().equals("Gravar")) {

								for (int i = 0; i < quantidadeAlunos; i++) {

									try {

										// Caso o valor do textbox esteja preenchido
										if (txtNota[i].getText().trim().length() != 0) {
											// Validação para nota não passar o valor máximo
											switch (avaliacao) {
											// Caso PAT
											case 1:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													if (txtNota[i].isEditable()) {
														JOptionPane.showMessageDialog(null,
																"Valores negativos não são permitidos, a nota que será atribuida para x alunx "
																		+ lblNome[i].getText() + " será: 0");
														control.NotaControl.InserirNota(
																Integer.parseInt(lblRM[i].getText()),
																codigoAtribuicaoTurma, avaliacao, trimestre, 0);
													}

													// Caso seja maior que a noa máxima será enviada a nota
													// máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													if (txtNota[i].isEditable()) {
														JOptionPane.showMessageDialog(null,
																"O valor excedo a nota máxima, a nota que será atribuida para x alunx "
																		+ lblNome[i].getText() + " será: " + maiorNota);
														control.NotaControl.InserirNota(
																Integer.parseInt(lblRM[i].getText()),
																codigoAtribuicaoTurma, avaliacao, trimestre, maiorNota);
													}

													// Caso esteja nos padrões
												} else {
													if (txtNota[i].isEditable()) {
														control.NotaControl.InserirNota(
																Integer.parseInt(lblRM[i].getText()),
																codigoAtribuicaoTurma, avaliacao, trimestre,
																Double.parseDouble(txtNota[i].getText()));
													}
												}
												break;
											// Caso PEM
											case 2:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													JOptionPane.showMessageDialog(null,
															"Valores negativos não são permitidos, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: 0");
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);

													// Caso seja maior que a noa máxima será enviada a nota
													// máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													JOptionPane.showMessageDialog(null,
															"O valor excedo a nota máxima, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: " + maiorNota);
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, maiorNota);

													// Caso esteja nos padrões
												} else {
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre,
															Double.parseDouble(txtNota[i].getText()));
												}
												break;
											// Caso Trabalho
											case 3:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													JOptionPane.showMessageDialog(null,
															"Valores negativos não são permitidos, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: 0");
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);

													// Caso seja maior que a noa máxima será enviada a nota
													// máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													JOptionPane.showMessageDialog(null,
															"O valor excedo a nota máxima, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: " + maiorNota);
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, maiorNota);

													// Caso esteja nos padrões
												} else {
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre,
															Double.parseDouble(txtNota[i].getText()));
												}
												break;
											// Caso Atitudinal
											case 4:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													if (txtNota[i].isEditable()) {
														JOptionPane.showMessageDialog(null,
																"Valores negativos não são permitidos, a nota que será atribuida para x alunx "
																		+ lblNome[i].getText() + " será: 0");
														control.NotaControl.InserirNota(
																Integer.parseInt(lblRM[i].getText()),
																codigoAtribuicaoTurma, avaliacao, trimestre, 0);
													}

													// Caso seja maior que a noa máxima será enviada a nota
													// máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													if (txtNota[i].isEditable()) {
														JOptionPane.showMessageDialog(null,
																"O valor excedo a nota máxima, a nota que será atribuida para x alunx "
																		+ lblNome[i].getText() + " será: " + maiorNota);
														control.NotaControl.InserirNota(
																Integer.parseInt(lblRM[i].getText()),
																codigoAtribuicaoTurma, avaliacao, trimestre, maiorNota);
													}

													// Caso esteja nos padrões
												} else {
													if (txtNota[i].isEditable()) {
														control.NotaControl.InserirNota(
																Integer.parseInt(lblRM[i].getText()),
																codigoAtribuicaoTurma, avaliacao, trimestre,
																Double.parseDouble(txtNota[i].getText()));
													}
												}
												break;
											}

											// Caso o valor do textbox esteja vazio
										} else {

											switch (avaliacao) {
											case 1:
												if (txtNota[i].isEditable()) {
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);
												}
												// envia 0 como nota
												break;
											case 2:
												control.NotaControl.InserirNota(Integer.parseInt(lblRM[i].getText()),
														codigoAtribuicaoTurma, avaliacao, trimestre, 0);
												// envia 0 como nota
												break;
											case 3:
												control.NotaControl.InserirNota(Integer.parseInt(lblRM[i].getText()),
														codigoAtribuicaoTurma, avaliacao, trimestre, 0);
												// envia 0 como nota
												break;
											case 4:
												if (txtNota[i].isEditable()) {
													control.NotaControl.InserirNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);
												}
												// envia 0 como nota
												break;

											}

										}

									} catch (NumberFormatException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								}

								JOptionPane.showMessageDialog(null, "Notas cadastradas com sucesso");
								FinalizarCadastro();

								// Caso o botão tenha o texto ALTERAR
							} else {

								for (int i = 0; i < quantidadeAlunos; i++) {

									try {

										// Caso o valor do textbox esteja preenchido
										if (txtNota[i].getText().trim().length() != 0) {
											// Validação para nota não passar o valor máximo
											switch (avaliacao) {
											// Caso PAT
											case 1:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													JOptionPane.showMessageDialog(null,
															"Valores negativos não são permitidos, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: 0");
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);

													// Caso seja maior que a noa máxima será enviada a nota máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													JOptionPane.showMessageDialog(null,
															"O valor excedo a nota máxima, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: " + maiorNota);
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, maiorNota);

													// Caso esteja nos padrões
												} else {
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre,
															Double.parseDouble(txtNota[i].getText()));
												}
												break;
											// Caso PEM
											case 2:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													JOptionPane.showMessageDialog(null,
															"Valores negativos não são permitidos, a nota que atribuida para x alunx "
																	+ lblNome[i].getText() + " será: 0");
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);

													// Caso seja maior que a noa máxima será enviada a nota máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													JOptionPane.showMessageDialog(null,
															"O valor excedo a nota máxima, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: " + maiorNota);
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, maiorNota);

													// Caso esteja nos padrões
												} else {
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre,
															Double.parseDouble(txtNota[i].getText()));
												}
												break;
											// Caso Trabalho
											case 3:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													JOptionPane.showMessageDialog(null,
															"Valores negativos não são permitidos, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: 0");
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);

													// Caso seja maior que a noa máxima será enviada a nota máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													JOptionPane.showMessageDialog(null,
															"O valor excedo a nota máxima, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será: " + maiorNota);
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, maiorNota);

													// Caso esteja nos padrões
												} else {
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre,
															Double.parseDouble(txtNota[i].getText()));
												}
												break;
											// Caso Atitudinal
											case 4:
												// Caso nota seja menor que 0 envia 0
												if (Double.parseDouble(txtNota[i].getText()) < 0) {
													JOptionPane.showMessageDialog(null,
															"Valores negativos não são permitidos, a nota que será atribuida para x alunx "
																	+ lblNome[i].getText() + " será 0");
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, 0);

													// Caso seja maior que a noa máxima será enviada a nota máxima
												} else if (Double.parseDouble(txtNota[i].getText()) > maiorNota) {
													JOptionPane.showMessageDialog(null,
															"O valor excedo a nota máxima, a nota que será atribuida ao alunx "
																	+ lblNome[i].getText() + " será: " + maiorNota);
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre, maiorNota);

													// Caso esteja nos padrões
												} else {
													control.NotaControl.AlterarNota(
															Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma,
															avaliacao, trimestre,
															Double.parseDouble(txtNota[i].getText()));
												}
												break;
											}

											// Caso o valor do textbox esteja vazio
										} else {

											control.NotaControl.AlterarNota(Integer.parseInt(lblRM[i].getText()),
													codigoAtribuicaoTurma, avaliacao, trimestre, 0);
											// envia 0 como nota
										}

									} catch (NumberFormatException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

								}

								JOptionPane.showMessageDialog(null, "Notas alteradas com sucesso");
								FinalizarCadastro();

							}

						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Selecione uma turma");
					}
				}
				// Caso todos os campos não tiverem sido preenchidos corretamente, aparecer
				// mensagem
				else {

					JOptionPane.showMessageDialog(null, "É necessário escolher uma turma");
				}
			}

		}

		);
		btnNota.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnNota.setBounds(1173, 528, 161, 55);
		add(btnNota);

		JLabel lblMatria = new JLabel("Mat\u00E9ria");
		lblMatria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblMatria.setBounds(33, 56, 109, 28);
		add(lblMatria);

		JLabel lblTurma = new JLabel("Turma");
		lblTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblTurma.setBounds(257, 56, 109, 28);
		add(lblTurma);

		cbDisciplina = new JComboBox();
		cbDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				control.AtribuicaoControl.BuscarAtribuicaoNome(nomeProfessor + ", " + cbDisciplina.getSelectedItem(),
						"nota");
				control.NotaControl.carregarComboTurmaNota(cbTurma, codigoAtribuicao);

			}
		});

		cbDisciplina.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

			}
		});

		cbDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbDisciplina.setBounds(33, 82, 212, 35);
		add(cbDisciplina);

		cbTurma = new JComboBox();
		cbTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (validacao == 1) {
					LimparCombo();
				}

				control.TurmaControl.BuscarTurmaNome(cbTurma.getSelectedItem().toString(), "nota");
				control.AtribuicaoTurmaControl.BuscarAtribuicacoTurma(codigoAtribuicao, codigoTurma);
				try {
					validacao = 1;
					control.vwQuantidadeAlunosControl.QuantidadeAlunos(codigoTurma);
					carregaRM(painelRM, painelRM2);
					carregaNome(painelNome, painelNome2);
					carregaCaixas(painelNota, painelNota2);
				} catch (Exception e) {
					validacao = 0;
				}

			}
		});
		cbTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbTurma.setBounds(257, 82, 212, 35);
		add(cbTurma);

		lblNome[0] = new JLabel();
		lblNome[0].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[0].setBounds(10, 11, 61, 18);

		lblNome[1] = new JLabel();
		lblNome[1].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[1].setBounds(10, 40, 61, 18);

		lblNome[2] = new JLabel();
		lblNome[2].setFont(new Font("Microsoft MHei", Font.PLAIN, 20));
		lblNome[2].setBounds(10, 92, 61, 18);

		lblNome[3] = new JLabel();
		lblNome[3].setFont(new Font("Microsoft MHei", Font.PLAIN, 20));
		lblNome[3].setBounds(10, 135, 61, 18);

		lblNome[4] = new JLabel();
		lblNome[4].setFont(new Font("Microsoft MHei", Font.PLAIN, 20));
		lblNome[4].setBounds(10, 170, 61, 18);

		rdbtnPAT = new JRadioButton("PAT");
		rdbtnPAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableCaixas();
				LimparCaixas();
				btnNota.setEnabled(false);
			}
		});
		rdbtnPAT.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnPAT);
		rdbtnPAT.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnPAT.setBounds(875, 65, 109, 23);
		add(rdbtnPAT);

		rdbtnPEM = new JRadioButton("PEM");
		rdbtnPEM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableCaixas();
				LimparCaixas();
				btnNota.setEnabled(false);
			}
		});
		rdbtnPEM.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnPEM);
		rdbtnPEM.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnPEM.setBounds(875, 94, 109, 23);
		add(rdbtnPEM);

		rdbtnTrabalho = new JRadioButton("Trabalho");
		rdbtnTrabalho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableCaixas();
				LimparCaixas();
				btnNota.setEnabled(false);
			}
		});
		rdbtnTrabalho.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnTrabalho);
		rdbtnTrabalho.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnTrabalho.setBounds(991, 65, 139, 23);
		add(rdbtnTrabalho);

		rdbtnAtitudinal = new JRadioButton("Atitudinal");
		rdbtnAtitudinal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableCaixas();
				LimparCaixas();
				btnNota.setEnabled(false);
			}
		});
		rdbtnAtitudinal.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnAtitudinal);
		rdbtnAtitudinal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnAtitudinal.setBounds(991, 94, 139, 23);
		add(rdbtnAtitudinal);

		rdbtn2 = new JRadioButton("2");
		rdbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableCaixas();
				btnNota.setEnabled(false);
				LimparCaixas();
			}
		});
		rdbtn2.setBackground(Color.WHITE);
		buttonGroup_1.add(rdbtn2);
		rdbtn2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn2.setBounds(1162, 94, 109, 23);
		add(rdbtn2);

		rdbtn1 = new JRadioButton("1");
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableCaixas();
				LimparCaixas();
				btnNota.setEnabled(false);
			}
		});
		rdbtn1.setBackground(Color.WHITE);
		buttonGroup_1.add(rdbtn1);
		rdbtn1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn1.setBounds(1162, 65, 52, 23);
		add(rdbtn1);

		rdbtn3 = new JRadioButton("3");
		rdbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnableCaixas();
				LimparCaixas();
				btnNota.setEnabled(false);
			}
		});
		rdbtn3.setBackground(Color.WHITE);
		buttonGroup_1.add(rdbtn3);
		rdbtn3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn3.setBounds(1216, 65, 67, 23);
		add(rdbtn3);

		lblCadastroDeNotas = new JLabel("Cadastro de Notas");
		lblCadastroDeNotas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeNotas.setBounds(535, 11, 319, 40);
		add(lblCadastroDeNotas);

		JLabel lblTrimestre = new JLabel("Trimestre");
		lblTrimestre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblTrimestre.setBounds(1160, 30, 109, 28);
		add(lblTrimestre);

		JLabel lblAvaliao = new JLabel("Avalia\u00E7\u00E3o");
		lblAvaliao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAvaliao.setBounds(875, 30, 109, 28);
		add(lblAvaliao);

		painelRM = new JPanel();
		painelRM.setBackground(Color.WHITE);
		painelRM.setBounds(33, 128, 89, 517);
		add(painelRM);
		painelRM.setLayout(null);

		lblRM[0] = new JLabel("");
		lblRM[0].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[0].setBounds(10, 10, 71, 18);
		painelRM.add(lblRM[0]);

		lblRM[1] = new JLabel("");
		lblRM[1].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[1].setBounds(10, 30, 71, 18);
		painelRM.add(lblRM[1]);

		lblRM[2] = new JLabel("");
		lblRM[2].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[2].setBounds(10, 50, 71, 18);
		painelRM.add(lblRM[2]);

		lblRM[3] = new JLabel("");
		lblRM[3].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[3].setBounds(10, 70, 71, 18);
		painelRM.add(lblRM[3]);

		lblRM[4] = new JLabel("");
		lblRM[4].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[4].setBounds(10, 90, 71, 18);
		painelRM.add(lblRM[4]);

		lblRM[5] = new JLabel("");
		lblRM[5].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[5].setBounds(10, 110, 71, 18);
		painelRM.add(lblRM[5]);

		lblRM[6] = new JLabel("");
		lblRM[6].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[6].setBounds(10, 130, 71, 18);
		painelRM.add(lblRM[6]);

		lblRM[7] = new JLabel("");
		lblRM[7].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[7].setBounds(10, 150, 71, 18);
		painelRM.add(lblRM[7]);

		lblRM[8] = new JLabel("");
		lblRM[8].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[8].setBounds(10, 170, 71, 18);
		painelRM.add(lblRM[8]);

		lblRM[9] = new JLabel("");
		lblRM[9].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[9].setBounds(10, 190, 71, 18);
		painelRM.add(lblRM[9]);

		lblRM[10] = new JLabel("");
		lblRM[10].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[10].setBounds(10, 210, 71, 18);
		painelRM.add(lblRM[10]);

		lblRM[11] = new JLabel("");
		lblRM[11].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[11].setBounds(10, 230, 71, 18);
		painelRM.add(lblRM[11]);

		lblRM[12] = new JLabel("");
		lblRM[12].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[12].setBounds(10, 250, 71, 18);
		painelRM.add(lblRM[12]);

		lblRM[13] = new JLabel("");
		lblRM[13].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[13].setBounds(10, 270, 71, 18);
		painelRM.add(lblRM[13]);

		lblRM[14] = new JLabel("");
		lblRM[14].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[14].setBounds(10, 290, 71, 18);
		painelRM.add(lblRM[14]);

		lblRM[15] = new JLabel("");
		lblRM[15].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[15].setBounds(10, 310, 71, 18);
		painelRM.add(lblRM[15]);

		lblRM[16] = new JLabel("");
		lblRM[16].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[16].setBounds(10, 330, 71, 18);
		painelRM.add(lblRM[16]);

		lblRM[17] = new JLabel("");
		lblRM[17].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[17].setBounds(10, 350, 71, 18);
		painelRM.add(lblRM[17]);

		lblRM[18] = new JLabel("");
		lblRM[18].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[18].setBounds(10, 390, 71, 18);
		painelRM.add(lblRM[18]);

		lblRM[19] = new JLabel("");
		lblRM[19].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[19].setBounds(10, 410, 71, 18);
		painelRM.add(lblRM[19]);

		lblRM[20] = new JLabel("");
		lblRM[20].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[20].setBounds(10, 430, 71, 18);
		painelRM.add(lblRM[20]);

		lblRM[21] = new JLabel("");
		lblRM[21].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[21].setBounds(10, 450, 71, 18);
		painelRM.add(lblRM[21]);

		lblRM[23] = new JLabel("");
		lblRM[23].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[23].setBounds(10, 470, 71, 18);
		painelRM.add(lblRM[23]);

		lblRM[24] = new JLabel("");
		lblRM[24].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[24].setBounds(10, 490, 71, 18);
		painelRM.add(lblRM[24]);

		painelNome = new JPanel();
		painelNome.setBackground(Color.WHITE);
		painelNome.setLayout(null);
		painelNome.setBounds(125, 128, 360, 517);
		add(painelNome);

		lblNome[0] = new JLabel("");
		lblNome[0].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[0].setBounds(10, 10, 340, 18);
		painelNome.add(lblNome[0]);

		lblNome[1] = new JLabel("");
		lblNome[1].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[1].setBounds(10, 30, 340, 18);
		painelNome.add(lblNome[1]);

		lblNome[2] = new JLabel("");
		lblNome[2].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[2].setBounds(10, 50, 340, 18);
		painelNome.add(lblNome[2]);

		lblNome[3] = new JLabel("");
		lblNome[3].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[3].setBounds(10, 70, 340, 18);
		painelNome.add(lblNome[3]);

		lblNome[4] = new JLabel("");
		lblNome[4].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[4].setBounds(10, 90, 340, 18);
		painelNome.add(lblNome[4]);

		lblNome[5] = new JLabel("");
		lblNome[5].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[5].setBounds(10, 110, 340, 18);
		painelNome.add(lblNome[5]);

		lblNome[6] = new JLabel("");
		lblNome[6].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[6].setBounds(10, 130, 340, 18);
		painelNome.add(lblNome[6]);

		lblNome[7] = new JLabel("");
		lblNome[7].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[7].setBounds(10, 150, 340, 18);
		painelNome.add(lblNome[7]);

		lblNome[8] = new JLabel("");
		lblNome[8].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[8].setBounds(10, 170, 340, 18);
		painelNome.add(lblNome[8]);

		lblNome[9] = new JLabel("");
		lblNome[9].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[9].setBounds(10, 190, 340, 18);
		painelNome.add(lblNome[9]);

		lblNome[10] = new JLabel("");
		lblNome[10].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[10].setBounds(10, 210, 340, 18);
		painelNome.add(lblNome[10]);

		lblNome[11] = new JLabel("");
		lblNome[11].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[11].setBounds(10, 230, 340, 18);
		painelNome.add(lblNome[11]);

		lblNome[12] = new JLabel("");
		lblNome[12].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[12].setBounds(10, 250, 340, 18);
		painelNome.add(lblNome[12]);

		lblNome[13] = new JLabel("");
		lblNome[13].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[13].setBounds(10, 270, 340, 18);
		painelNome.add(lblNome[13]);

		lblNome[14] = new JLabel("");
		lblNome[14].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[14].setBounds(10, 290, 340, 18);
		painelNome.add(lblNome[14]);

		lblNome[16] = new JLabel("");
		lblNome[16].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[16].setBounds(10, 310, 340, 18);
		painelNome.add(lblNome[16]);

		lblNome[17] = new JLabel("");
		lblNome[17].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[17].setBounds(10, 330, 340, 18);
		painelNome.add(lblNome[17]);

		lblNome[18] = new JLabel("");
		lblNome[18].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[18].setBounds(10, 350, 340, 18);
		painelNome.add(lblNome[18]);

		lblNome[19] = new JLabel("");
		lblNome[19].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[19].setBounds(10, 390, 340, 18);
		painelNome.add(lblNome[19]);

		lblNome[20] = new JLabel("");
		lblNome[20].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[20].setBounds(10, 410, 340, 18);
		painelNome.add(lblNome[20]);

		lblNome[21] = new JLabel("");
		lblNome[21].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[21].setBounds(10, 430, 340, 18);
		painelNome.add(lblNome[21]);

		lblNome[22] = new JLabel("");
		lblNome[22].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[22].setBounds(10, 450, 340, 18);
		painelNome.add(lblNome[22]);

		lblNome[23] = new JLabel("");
		lblNome[23].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[23].setBounds(10, 470, 340, 18);
		painelNome.add(lblNome[23]);

		lblNome[24] = new JLabel("");
		lblNome[24].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[24].setBounds(10, 490, 340, 18);
		painelNome.add(lblNome[24]);

		painelNota = new JPanel();
		painelNota.setBackground(Color.WHITE);
		painelNota.setLayout(null);
		painelNota.setBounds(489, 128, 89, 517);
		add(painelNota);

		txtNota[0] = new JTextField();
		txtNota[0].setEditable(false);
		txtNota[0].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[0].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[0].setBounds(10, 10, 69, 20);
		painelNota.add(txtNota[0]);
		txtNota[0].setColumns(10);

		txtNota[1] = new JTextField();
		txtNota[1].setEditable(false);
		txtNota[1].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[1].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[1].setColumns(10);
		txtNota[1].setBounds(10, 30, 69, 20);
		painelNota.add(txtNota[1]);

		txtNota[2] = new JTextField();
		txtNota[2].setEditable(false);
		txtNota[2].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[2].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[2].setColumns(10);
		txtNota[2].setBounds(10, 50, 69, 20);
		painelNota.add(txtNota[2]);

		txtNota[3] = new JTextField();
		txtNota[3].setEditable(false);
		txtNota[3].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[3].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[3].setColumns(10);
		txtNota[3].setBounds(10, 70, 69, 20);
		painelNota.add(txtNota[3]);

		txtNota[4] = new JTextField();
		txtNota[4].setEditable(false);
		txtNota[4].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[4].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[4].setColumns(10);
		txtNota[4].setBounds(10, 90, 69, 20);
		painelNota.add(txtNota[4]);

		txtNota[5] = new JTextField();
		txtNota[5].setEditable(false);
		txtNota[5].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[5].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[5].setColumns(10);
		txtNota[5].setBounds(10, 110, 69, 20);
		painelNota.add(txtNota[5]);

		txtNota[6] = new JTextField();
		txtNota[6].setEditable(false);
		txtNota[6].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[6].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[6].setColumns(10);
		txtNota[6].setBounds(10, 130, 69, 20);
		painelNota.add(txtNota[6]);

		txtNota[7] = new JTextField();
		txtNota[7].setEditable(false);
		txtNota[7].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[7].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[7].setColumns(10);
		txtNota[7].setBounds(10, 150, 69, 20);
		painelNota.add(txtNota[7]);

		txtNota[8] = new JTextField();
		txtNota[8].setEditable(false);
		txtNota[8].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[8].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[8].setColumns(10);
		txtNota[8].setBounds(10, 170, 69, 20);
		painelNota.add(txtNota[8]);

		txtNota[9] = new JTextField();
		txtNota[9].setEditable(false);
		txtNota[9].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[9].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[9].setColumns(10);
		txtNota[9].setBounds(10, 190, 69, 20);
		painelNota.add(txtNota[9]);

		txtNota[10] = new JTextField();
		txtNota[10].setEditable(false);
		txtNota[10].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[10].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[10].setColumns(10);
		txtNota[10].setBounds(10, 210, 69, 20);
		painelNota.add(txtNota[10]);

		txtNota[11] = new JTextField();
		txtNota[11].setEditable(false);
		txtNota[11].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[11].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[11].setColumns(10);
		txtNota[11].setBounds(10, 230, 69, 20);
		painelNota.add(txtNota[11]);

		txtNota[12] = new JTextField();
		txtNota[12].setEditable(false);
		txtNota[12].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[12].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[12].setColumns(10);
		txtNota[12].setBounds(10, 250, 69, 20);
		painelNota.add(txtNota[12]);

		txtNota[13] = new JTextField();
		txtNota[13].setEditable(false);
		txtNota[13].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[13].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[13].setColumns(10);
		txtNota[13].setBounds(10, 270, 69, 20);
		painelNota.add(txtNota[13]);

		txtNota[14] = new JTextField();
		txtNota[14].setEditable(false);
		txtNota[14].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[14].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[14].setColumns(10);
		txtNota[14].setBounds(10, 290, 69, 20);
		painelNota.add(txtNota[14]);

		txtNota[15] = new JTextField();
		txtNota[15].setEditable(false);
		txtNota[15].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[15].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[15].setColumns(10);
		txtNota[15].setBounds(10, 310, 69, 20);
		painelNota.add(txtNota[15]);

		txtNota[16] = new JTextField();
		txtNota[16].setEditable(false);
		txtNota[16].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[16].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[16].setColumns(10);
		txtNota[16].setBounds(10, 330, 69, 20);
		painelNota.add(txtNota[16]);

		txtNota[17] = new JTextField();
		txtNota[17].setEditable(false);
		txtNota[17].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[17].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[17].setColumns(10);
		txtNota[17].setBounds(10, 350, 69, 20);
		painelNota.add(txtNota[17]);

		txtNota[18] = new JTextField();
		txtNota[18].setEditable(false);
		txtNota[18].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[18].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[18].setColumns(10);
		txtNota[18].setBounds(10, 370, 69, 20);
		painelNota.add(txtNota[18]);

		txtNota[19] = new JTextField();
		txtNota[19].setEditable(false);
		txtNota[19].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[19].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[19].setColumns(10);
		txtNota[19].setBounds(10, 390, 69, 20);
		painelNota.add(txtNota[19]);

		txtNota[20] = new JTextField();
		txtNota[20].setEditable(false);
		txtNota[20].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[20].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[20].setColumns(10);
		txtNota[20].setBounds(10, 410, 69, 20);
		painelNota.add(txtNota[20]);

		txtNota[21] = new JTextField();
		txtNota[21].setEditable(false);
		txtNota[21].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[21].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[21].setColumns(10);
		txtNota[21].setBounds(10, 430, 69, 20);
		painelNota.add(txtNota[21]);

		txtNota[22] = new JTextField();
		txtNota[22].setEditable(false);
		txtNota[22].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[22].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[22].setColumns(10);
		txtNota[22].setBounds(10, 450, 69, 20);
		painelNota.add(txtNota[22]);

		txtNota[23] = new JTextField();
		txtNota[23].setEditable(false);
		txtNota[23].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[23].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[23].setColumns(10);
		txtNota[23].setBounds(10, 470, 69, 20);
		painelNota.add(txtNota[23]);

		txtNota[24] = new JTextField();
		txtNota[24].setEditable(false);
		txtNota[24].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[24].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[24].setColumns(10);
		txtNota[24].setBounds(10, 490, 69, 20);
		painelNota.add(txtNota[24]);

		painelNome2 = new JPanel();
		painelNome2.setBackground(Color.WHITE);
		painelNome2.setLayout(null);
		painelNome2.setBounds(716, 128, 360, 517);
		add(painelNome2);

		lblNome[25] = new JLabel("");
		lblNome[25].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[25].setBounds(10, 10, 340, 18);
		painelNome2.add(lblNome[25]);

		lblNome[26] = new JLabel("");
		lblNome[26].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[26].setBounds(10, 30, 340, 18);
		painelNome2.add(lblNome[26]);

		lblNome[27] = new JLabel("");
		lblNome[27].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[27].setBounds(10, 50, 340, 18);
		painelNome2.add(lblNome[27]);

		lblNome[28] = new JLabel("");
		lblNome[28].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[28].setBounds(10, 70, 340, 18);
		painelNome2.add(lblNome[28]);

		lblNome[29] = new JLabel("");
		lblNome[29].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[29].setBounds(10, 90, 340, 18);
		painelNome2.add(lblNome[29]);

		lblNome[30] = new JLabel("");
		lblNome[30].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[30].setBounds(10, 110, 340, 18);
		painelNome2.add(lblNome[30]);

		lblNome[31] = new JLabel("");
		lblNome[31].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[31].setBounds(10, 130, 340, 18);
		painelNome2.add(lblNome[31]);

		lblNome[32] = new JLabel("");
		lblNome[32].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[32].setBounds(10, 150, 340, 18);
		painelNome2.add(lblNome[32]);

		lblNome[33] = new JLabel("");
		lblNome[33].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[33].setBounds(10, 170, 340, 18);
		painelNome2.add(lblNome[33]);

		lblNome[34] = new JLabel("");
		lblNome[34].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[34].setBounds(10, 190, 340, 18);
		painelNome2.add(lblNome[34]);

		lblNome[35] = new JLabel("");
		lblNome[35].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[35].setBounds(10, 210, 340, 18);
		painelNome2.add(lblNome[35]);

		lblNome[36] = new JLabel("");
		lblNome[36].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[36].setBounds(10, 230, 340, 18);
		painelNome2.add(lblNome[36]);

		lblNome[37] = new JLabel("");
		lblNome[37].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[37].setBounds(10, 250, 340, 18);
		painelNome2.add(lblNome[37]);

		lblNome[38] = new JLabel("");
		lblNome[38].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[38].setBounds(10, 270, 340, 18);
		painelNome2.add(lblNome[38]);

		lblNome[39] = new JLabel("");
		lblNome[39].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[39].setBounds(10, 290, 340, 18);
		painelNome2.add(lblNome[39]);

		lblNome[40] = new JLabel("");
		lblNome[40].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[40].setBounds(10, 310, 340, 18);
		painelNome2.add(lblNome[40]);

		lblNome[41] = new JLabel("");
		lblNome[41].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[41].setBounds(10, 330, 340, 18);
		painelNome2.add(lblNome[41]);

		lblNome[42] = new JLabel("");
		lblNome[42].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[42].setBounds(10, 350, 340, 18);
		painelNome2.add(lblNome[42]);

		lblNome[43] = new JLabel("");
		lblNome[43].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[43].setBounds(10, 390, 340, 18);
		painelNome2.add(lblNome[43]);

		lblNome[44] = new JLabel("");
		lblNome[44].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[44].setBounds(10, 410, 340, 18);
		painelNome2.add(lblNome[44]);

		lblNome[45] = new JLabel("");
		lblNome[45].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[45].setBounds(10, 430, 340, 18);
		painelNome2.add(lblNome[45]);

		lblNome[46] = new JLabel("");
		lblNome[46].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[46].setBounds(10, 450, 340, 18);
		painelNome2.add(lblNome[46]);

		lblNome[47] = new JLabel("");
		lblNome[47].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[47].setBounds(10, 470, 340, 18);
		painelNome2.add(lblNome[47]);

		lblNome[48] = new JLabel("");
		lblNome[48].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblNome[48].setBounds(10, 490, 340, 18);
		painelNome2.add(lblNome[48]);

		painelNota2 = new JPanel();
		painelNota2.setBackground(Color.WHITE);
		painelNota2.setLayout(null);
		painelNota2.setBounds(1080, 128, 89, 517);
		add(painelNota2);

		txtNota[25] = new JTextField();
		txtNota[25].setEditable(false);
		txtNota[25].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[25].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[25].setColumns(10);
		txtNota[25].setBounds(10, 10, 69, 20);
		painelNota2.add(txtNota[25]);

		txtNota[26] = new JTextField();
		txtNota[26].setEditable(false);
		txtNota[26].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[26].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[26].setColumns(10);
		txtNota[26].setBounds(10, 30, 69, 20);
		painelNota2.add(txtNota[26]);

		txtNota[27] = new JTextField();
		txtNota[27].setEditable(false);
		txtNota[27].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[27].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[27].setColumns(10);
		txtNota[27].setBounds(10, 50, 69, 20);
		painelNota2.add(txtNota[27]);

		txtNota[28] = new JTextField();
		txtNota[28].setEditable(false);
		txtNota[28].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[28].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[28].setColumns(10);
		txtNota[28].setBounds(10, 70, 69, 20);
		painelNota2.add(txtNota[28]);

		txtNota[29] = new JTextField();
		txtNota[29].setEditable(false);
		txtNota[29].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[29].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[29].setColumns(10);
		txtNota[29].setBounds(10, 90, 69, 20);
		painelNota2.add(txtNota[29]);

		txtNota[30] = new JTextField();
		txtNota[30].setEditable(false);
		txtNota[30].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[30].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[30].setColumns(10);
		txtNota[30].setBounds(10, 110, 69, 20);
		painelNota2.add(txtNota[30]);

		txtNota[31] = new JTextField();
		txtNota[31].setEditable(false);
		txtNota[31].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[31].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[31].setColumns(10);
		txtNota[31].setBounds(10, 130, 69, 20);
		painelNota2.add(txtNota[31]);

		txtNota[32] = new JTextField();
		txtNota[32].setEditable(false);
		txtNota[32].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[32].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[32].setColumns(10);
		txtNota[32].setBounds(10, 150, 69, 20);
		painelNota2.add(txtNota[32]);

		txtNota[33] = new JTextField();
		txtNota[33].setEditable(false);
		txtNota[33].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[33].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[33].setColumns(10);
		txtNota[33].setBounds(10, 170, 69, 20);
		painelNota2.add(txtNota[33]);

		txtNota[34] = new JTextField();
		txtNota[34].setEditable(false);
		txtNota[34].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[34].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[34].setColumns(10);
		txtNota[34].setBounds(10, 190, 69, 20);
		painelNota2.add(txtNota[34]);

		txtNota[35] = new JTextField();
		txtNota[35].setEditable(false);
		txtNota[35].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[35].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[35].setColumns(10);
		txtNota[35].setBounds(10, 210, 69, 20);
		painelNota2.add(txtNota[35]);

		txtNota[36] = new JTextField();
		txtNota[36].setEditable(false);
		txtNota[36].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[36].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[36].setColumns(10);
		txtNota[36].setBounds(10, 230, 69, 20);
		painelNota2.add(txtNota[36]);

		txtNota[37] = new JTextField();
		txtNota[37].setEditable(false);
		txtNota[37].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[37].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[37].setColumns(10);
		txtNota[37].setBounds(10, 250, 69, 20);
		painelNota2.add(txtNota[37]);

		txtNota[38] = new JTextField();
		txtNota[38].setEditable(false);
		txtNota[38].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[38].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[38].setColumns(10);
		txtNota[38].setBounds(10, 270, 69, 20);
		painelNota2.add(txtNota[38]);

		txtNota[39] = new JTextField();
		txtNota[39].setEditable(false);
		txtNota[39].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[39].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[39].setColumns(10);
		txtNota[39].setBounds(10, 290, 69, 20);
		painelNota2.add(txtNota[39]);

		txtNota[40] = new JTextField();
		txtNota[40].setEditable(false);
		txtNota[40].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[40].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[40].setColumns(10);
		txtNota[40].setBounds(10, 310, 69, 20);
		painelNota2.add(txtNota[40]);

		txtNota[41] = new JTextField();
		txtNota[41].setEditable(false);
		txtNota[41].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[41].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[41].setColumns(10);
		txtNota[41].setBounds(10, 330, 69, 20);
		painelNota2.add(txtNota[41]);

		txtNota[42] = new JTextField();
		txtNota[42].setEditable(false);
		txtNota[42].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[42].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[42].setColumns(10);
		txtNota[42].setBounds(10, 350, 69, 20);
		painelNota2.add(txtNota[42]);

		txtNota[43] = new JTextField();
		txtNota[43].setEditable(false);
		txtNota[43].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[43].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[43].setColumns(10);
		txtNota[43].setBounds(10, 370, 69, 20);
		painelNota2.add(txtNota[43]);

		txtNota[44] = new JTextField();
		txtNota[44].setEditable(false);
		txtNota[44].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[44].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[44].setColumns(10);
		txtNota[44].setBounds(10, 390, 69, 20);
		painelNota2.add(txtNota[44]);

		txtNota[45] = new JTextField();
		txtNota[45].setEditable(false);
		txtNota[45].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[45].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[45].setColumns(10);
		txtNota[45].setBounds(10, 410, 69, 20);
		painelNota2.add(txtNota[45]);

		txtNota[46] = new JTextField();
		txtNota[46].setEditable(false);
		txtNota[46].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[46].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[46].setColumns(10);
		txtNota[46].setBounds(10, 430, 69, 20);
		painelNota2.add(txtNota[46]);

		txtNota[47] = new JTextField();
		txtNota[47].setEditable(false);
		txtNota[47].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[47].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[47].setColumns(10);
		txtNota[47].setBounds(10, 450, 69, 20);
		painelNota2.add(txtNota[47]);

		txtNota[48] = new JTextField();
		txtNota[48].setEditable(false);
		txtNota[48].setHorizontalAlignment(SwingConstants.CENTER);
		txtNota[48].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNota[48].setColumns(10);
		txtNota[48].setBounds(10, 470, 69, 20);
		painelNota2.add(txtNota[48]);

		/*
		 * txtNota[49] = new JTextField(); txtNota[49].setEditable(false);
		 * txtNota[49].setHorizontalAlignment(SwingConstants.CENTER);
		 * txtNota[49].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		 * txtNota[49].setColumns(10); txtNota[49].setBounds(10, 490, 69, 20);
		 * painelNota2.add(txtNota[49]);
		 */

		painelRM2 = new JPanel();
		painelRM2.setBackground(Color.WHITE);
		painelRM2.setLayout(null);
		painelRM2.setBounds(621, 128, 89, 517);
		add(painelRM2);

		lblRM[25] = new JLabel("");
		lblRM[25].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[25].setBounds(10, 10, 100, 18);
		painelRM2.add(lblRM[25]);

		lblRM[26] = new JLabel("");
		lblRM[26].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[26].setBounds(10, 30, 340, 18);
		painelRM2.add(lblRM[26]);

		lblRM[27] = new JLabel("");
		lblRM[27].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[27].setBounds(10, 50, 340, 18);
		painelRM2.add(lblRM[27]);

		lblRM[28] = new JLabel("");
		lblRM[28].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[28].setBounds(10, 70, 340, 18);
		painelRM2.add(lblRM[28]);

		lblRM[29] = new JLabel("");
		lblRM[29].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[29].setBounds(10, 90, 340, 18);
		painelRM2.add(lblRM[29]);

		lblRM[30] = new JLabel("");
		lblRM[30].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[30].setBounds(10, 110, 340, 18);
		painelRM2.add(lblRM[30]);

		lblRM[31] = new JLabel("");
		lblRM[31].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[31].setBounds(10, 130, 340, 18);
		painelRM2.add(lblRM[31]);

		lblRM[32] = new JLabel("");
		lblRM[32].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[32].setBounds(10, 150, 340, 18);
		painelRM2.add(lblRM[32]);

		lblRM[33] = new JLabel("");
		lblRM[33].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[33].setBounds(10, 170, 340, 18);
		painelRM2.add(lblRM[33]);

		lblRM[34] = new JLabel("");
		lblRM[34].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[34].setBounds(10, 190, 340, 18);
		painelRM2.add(lblRM[34]);

		lblRM[35] = new JLabel("");
		lblRM[35].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[35].setBounds(10, 210, 340, 18);
		painelRM2.add(lblRM[35]);

		lblRM[36] = new JLabel("");
		lblRM[36].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[36].setBounds(10, 230, 340, 18);
		painelRM2.add(lblRM[36]);

		lblRM[37] = new JLabel("");
		lblRM[37].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[37].setBounds(10, 250, 340, 18);
		painelRM2.add(lblRM[37]);

		lblRM[38] = new JLabel("");
		lblRM[38].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[38].setBounds(10, 270, 340, 18);
		painelRM2.add(lblRM[38]);

		lblRM[39] = new JLabel("");
		lblRM[39].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[39].setBounds(10, 290, 340, 18);
		painelRM2.add(lblRM[39]);

		lblRM[40] = new JLabel("");
		lblRM[40].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[40].setBounds(10, 310, 340, 18);
		painelRM2.add(lblRM[40]);

		lblRM[41] = new JLabel("");
		lblRM[41].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[41].setBounds(10, 330, 340, 18);
		painelRM2.add(lblRM[41]);

		lblRM[42] = new JLabel("");
		lblRM[42].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[42].setBounds(10, 350, 89, 18);
		painelRM2.add(lblRM[42]);

		lblRM[43] = new JLabel("");
		lblRM[43].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[43].setBounds(10, 390, 340, 18);
		painelRM2.add(lblRM[43]);

		lblRM[44] = new JLabel("");
		lblRM[44].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[44].setBounds(10, 410, 340, 18);
		painelRM2.add(lblRM[44]);

		lblRM[45] = new JLabel("");
		lblRM[45].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[45].setBounds(10, 430, 340, 18);
		painelRM2.add(lblRM[45]);

		lblRM[46] = new JLabel("");
		lblRM[46].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[46].setBounds(10, 450, 340, 18);
		painelRM2.add(lblRM[46]);

		lblRM[47] = new JLabel("");
		lblRM[47].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[47].setBounds(10, 470, 340, 18);
		painelRM2.add(lblRM[47]);

		lblRM[48] = new JLabel("");
		lblRM[48].setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		lblRM[48].setBounds(10, 490, 340, 18);
		painelRM2.add(lblRM[48]);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparBotao();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(1173, 590, 161, 55);
		add(btnLimpar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (validacao == 1) {

					// Descobrir o tipo de avaliação

					if (rdbtnPAT.isSelected()) {
						avaliacao = 1;
						nAvaliacao = "PAT";
						maiorNota = 9;
					} else if (rdbtnPEM.isSelected()) {
						avaliacao = 2;
						nAvaliacao = "PEM";
						maiorNota = 7;
					} else if (rdbtnTrabalho.isSelected()) {
						avaliacao = 3;
						nAvaliacao = "Trabalho";
						maiorNota = 7;
					} else {
						avaliacao = 4;
						nAvaliacao = "Atitudinal";
						maiorNota = 2;
					}

					// Descobrir o trimestre
					int trimestre = 0;
					String nTrimestre = "";
					if (rdbtn1.isSelected()) {
						trimestre = 1;
						nTrimestre = "1º trimestre";
					} else if (rdbtn2.isSelected()) {
						trimestre = 2;
						nTrimestre = "2º trimestre";
					} else {
						trimestre = 3;
						nTrimestre = "3º trimestre";
					}

					btnNota.setText("Gravar");
					btnNota.setEnabled(true);

					int contador = 0;
					// Setar como editável uma quantidade de textbox igual a quantidade de alunos da
					// sala
					for (int i = 0; i < quantidadeAlunos; i++) {

						if (avaliacao == 1) {

							contador = 0;
							if (control.NotaControl.ValidarAvaliacao(codigoAtribuicaoTurma, avaliacao, trimestre,
									Integer.parseInt(lblRM[i].getText()))) {
								txtNota[i].setEditable(false);
								contador += 1;
							} else {
								txtNota[i].setEditable(true);
							}

						} else if (avaliacao == 4) {

							contador = 0;
							if (control.NotaControl.ValidarAvaliacao(codigoAtribuicaoTurma, avaliacao, trimestre,
									Integer.parseInt(lblRM[i].getText()))) {
								txtNota[i].setEditable(false);
								contador += 1;
							} else {
								txtNota[i].setEditable(true);
							}

						} else {
							txtNota[i].setEditable(true);
						}

					}

					if (contador != 0) {
						JOptionPane.showMessageDialog(null,
								"Os alunos desabilitados já possuem nota gravada, não será possível adicionar novas. Altere, se necessário");
					}

					txtNota[0].grabFocus();
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma turma");
				}
			}
		});
		btnNovo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnNovo.setBounds(529, 82, 137, 34);
		add(btnNovo);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Metódo de Consulta

				if (validacao == 1) {

					// Seta o botão como ALTERAR
					btnNota.setText("Alterar");

					// Descobrir o tipo de avaliação

					if (rdbtnPAT.isSelected()) {
						avaliacao = 1;
						nAvaliacao = "PAT";
						maiorNota = 9;
					} else if (rdbtnPEM.isSelected()) {
						avaliacao = 2;
						nAvaliacao = "PEM";
						maiorNota = 7;
					} else if (rdbtnTrabalho.isSelected()) {
						avaliacao = 3;
						nAvaliacao = "Trabalho";
						maiorNota = 7;
					} else {
						avaliacao = 4;
						nAvaliacao = "Atitudinal";
						maiorNota = 2;
					}

					// Descobrir o trimestre
					int trimestre = 0;
					String nTrimestre = "";
					if (rdbtn1.isSelected()) {
						trimestre = 1;
						nTrimestre = "1º trimestre";
					} else if (rdbtn2.isSelected()) {
						trimestre = 2;
						nTrimestre = "2º trimestre";
					} else {
						trimestre = 3;
						nTrimestre = "3º trimestre";
					}

					try {
						for (int i = 0; i < quantidadeAlunos; i++) {

							String notaConsulta[] = control.NotaControl
									.listarNotas(Integer.parseInt(lblRM[i].getText()), codigoAtribuicaoTurma, avaliacao,
											trimestre)
									.toString().split(" ");

							codigoNota[i] = Integer.parseInt(notaConsulta[0].substring(1, notaConsulta[0].length()));
							txtNota[i].setText(notaConsulta[1].substring(0, notaConsulta[1].length() - 1));

							txtNota[i].setEditable(true);
							btnNota.setEnabled(true);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro na consulta");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma turma");
				}

			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(678, 82, 139, 34);
		add(btnConsultar);

		btnExcel = new JButton("Excel");
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// Descobrir o tipo de avaliação

					if (rdbtnPAT.isSelected()) {
						avaliacao = 1;
						nAvaliacao = "PAT";
						maiorNota = 9;
					} else if (rdbtnPEM.isSelected()) {
						avaliacao = 2;
						nAvaliacao = "PEM";
						maiorNota = 7;
					} else if (rdbtnTrabalho.isSelected()) {
						avaliacao = 3;
						nAvaliacao = "Trabalho";
						maiorNota = 7;
					} else {
						avaliacao = 4;
						nAvaliacao = "Atitudinal";
						maiorNota = 2;
					}

					// Descobrir o trimestre
					int trimestre = 0;
					String nTrimestre = "";
					if (rdbtn1.isSelected()) {
						trimestre = 1;
						nTrimestre = "1º trimestre";
					} else if (rdbtn2.isSelected()) {
						trimestre = 2;
						nTrimestre = "2º trimestre";
					} else {
						trimestre = 3;
						nTrimestre = "3º trimestre";
					}
					if (validacao != 0) {
						String caminhoArquivo = util.Planilha.SelecionaPlanilha();
						int linhas = util.Planilha.LinhasPlanilha(caminhoArquivo);
						try {
							for (int i = 0; i < linhas; i++) {
								model.Nota objNota = util.Planilha.Excel(i, caminhoArquivo);

								try {

									control.NotaControl.InserirNota(objNota.getId_Aluno(), codigoAtribuicaoTurma,
											avaliacao, trimestre, objNota.getNota());

								} catch (NumberFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

						} catch (Exception e1) {

						}

					} else {
						JOptionPane.showMessageDialog(null, "Selecione uma turma");
					}
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExcel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnExcel.setBounds(1173, 462, 161, 55);
		add(btnExcel);

	}

	public void carregaRM(JPanel painel, JPanel painel2) {
		int y = 5;
		for (int i = 0; i < quantidadeAlunos; i++) {
			// lblRM[i] = new JLabel();
			lblRM[i].setText(String.valueOf(control.AlunoControl.carregaAlunos(codigoTurma).get(i)).substring(0, 5));
			// lblRM[i].setHorizontalAlignment(SwingConstants.LEFT);
			// lblRM[i].setBounds(5, y, 100, 14);

			if (i < 25) {
				painel.add(lblRM[i]);
				painel.repaint();
			} else {
				painel2.add(lblRM[i]);
				painel2.repaint();
			}

			// metodo de recriar painel

			// y += 15;
		}
	}

	public void carregaNome(JPanel painel, JPanel painel2) {
		int y = 5;
		for (int i = 0; i < quantidadeAlunos; i++) {
			// lblNome[i] = new JLabel();
			lblNome[i].setText(String.valueOf(control.AlunoControl.carregaAlunos(codigoTurma).get(i)).substring(7));
			// lblNome[i].setHorizontalAlignment(SwingConstants.LEFT);
			// lblNome[i].setBounds(5, y, 270, 14);

			if (i < 25) {
				painel.add(lblNome[i]);
				painel.repaint();
			} else {
				painel2.add(lblNome[i]);
				painel2.repaint();
			}

			// y += 15;
		}
	}

	public void carregaCaixas(JPanel painel, JPanel painel2) {
		int y = 5;
		for (int i = 0; i < quantidadeAlunos; i++) {
			// txtNota[i] = new JTextField();
			// txtNota[i].setHorizontalAlignment(SwingConstants.CENTER);
			// txtNota[i].setBounds(5, y, 86, 20);~

			txtNota[i].setVisible(true);

			if (i < 25) {
				painel.add(txtNota[i]);
				painel.repaint();
			} else {
				painel2.add(txtNota[i]);
				painel2.repaint();
			}

			// y += 21;
		}
	}

	public static void Inicializar() {
		try {
			for (int i = 0; i < quantidadeAlunos; i++) {
				lblRM[i].setText("");
				lblNome[i].setText("");
				txtNota[i].setText("");
				txtNota[i].setEditable(false);
				validacao = 0;
				btnNota.setText("Gravar");
				btnNota.setEnabled(false);
				TirarCaixas();
			}
		} catch (Exception e) {
		}

		validacao = 0;
		rdbtnPEM.setSelected(true);
		rdbtn3.setSelected(true);
		btnNota.setEnabled(false);
		TirarCaixas();
		// Limpar();

	}

	public static void TirarCaixas() {
		for (int i = 0; i < 49; i++) {
			txtNota[i].setVisible(false);
		}
		validacao = 0;
	}

	// limpar após grvar notas
	public static void FinalizarCadastro() {
		LimparCaixas();
		// btnNota.setEnabled(false);
		EnableCaixas();
		btnNota.setEnabled(false);
	}

	public static void LimparCaixas() {
		for (int i = 0; i < quantidadeAlunos; i++) {
			txtNota[i].setText("");
		}
	}

	public static void EnableCaixas() {
		if (validacao == 1) {
			for (int i = 0; i < quantidadeAlunos; i++) {
				txtNota[i].setEditable(false);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma turma");
		}
	}

	// limpar depois da consulta de turma
	public static void LimparCombo() {

		for (int i = 0; i < quantidadeAlunos; i++) {
			lblRM[i].setText("");
			lblNome[i].setText("");
			txtNota[i].setText("");
			txtNota[i].setVisible(false);
		}

		EnableCaixas();
		btnNota.setText("Gravar");

	}

	// limpar do botão limpar
	public static void LimparBotao() {
		if (validacao == 1) {
			for (int i = 0; i < quantidadeAlunos; i++) {
				lblRM[i].setText("");
				lblNome[i].setText("");
				txtNota[i].setText("");
				txtNota[i].setEditable(false);
				validacao = 0;
				btnNota.setText("Gravar");
				btnNota.setEnabled(false);
				TirarCaixas();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Campos limpos");
		}

	}
}

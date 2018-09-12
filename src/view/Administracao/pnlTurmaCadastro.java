package view.Administracao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Curso;
import java.awt.Color;

public class pnlTurmaCadastro extends JPanel {

	public static JComboBox<Curso> cbCursoTurma;
	public static JComboBox cbSerieTurma;
	public static JComboBox cbSiglaTurma;
	public static JComboBox cbPeriodoTurma;

	public static int idCurso = 0;
	public static String abreviaturaCurso = "";
	public static JLabel lblNewLabel;

	public static JTextField txtCodigo;
	public static JTextField txtNomeTurma;

	/**
	 * Create the panel.
	 */
	public pnlTurmaCadastro() {
		setBackground(Color.WHITE);
		setLayout(null);

		cbCursoTurma = new JComboBox<Curso>();
		control.CursoControl.carregarComboCurso(cbCursoTurma);

		cbCursoTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		cbCursoTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbCursoTurma.setBounds(399, 194, 293, 35);
		add(cbCursoTurma);

		JLabel lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCurso.setBounds(399, 164, 136, 29);
		add(lblCurso);

		txtNomeTurma = new JTextField();
		txtNomeTurma.setEditable(false);
		txtNomeTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNomeTurma.setColumns(10);
		txtNomeTurma.setBounds(551, 118, 161, 35);
		add(txtNomeTurma);

		JLabel lblCdigo = new JLabel("Nome da Turma (Ex. INF3FM)");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCdigo.setBounds(551, 84, 368, 35);
		add(lblCdigo);

		cbSerieTurma = new JComboBox();
		cbSerieTurma.setToolTipText("");
		cbSerieTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbSerieTurma.setBounds(399, 275, 149, 35);
		add(cbSerieTurma);
		cbSerieTurma.addItem("");
		cbSerieTurma.addItem("1º ano");
		cbSerieTurma.addItem("2º ano");
		cbSerieTurma.addItem("3º ano");

		JLabel lblAno = new JLabel("S\u00E9rie");
		lblAno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAno.setBounds(399, 253, 113, 18);
		add(lblAno);

		cbSiglaTurma = new JComboBox();
		cbSiglaTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbSiglaTurma.setBounds(581, 275, 149, 35);
		add(cbSiglaTurma);
		cbSiglaTurma.addItem("");
		cbSiglaTurma.addItem("A");
		cbSiglaTurma.addItem("B");
		cbSiglaTurma.addItem("C");
		cbSiglaTurma.addItem("D");
		cbSiglaTurma.addItem("E");
		cbSiglaTurma.addItem("F");
		cbSiglaTurma.addItem("G");
		cbSiglaTurma.addItem("H");
		cbSiglaTurma.addItem("I");
		cbSiglaTurma.addItem("J");
		cbSiglaTurma.addItem("K");
		cbSiglaTurma.addItem("L");
		cbSiglaTurma.addItem("M");
		cbSiglaTurma.addItem("N");

		JLabel lblSigla = new JLabel("Sigla");
		lblSigla.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblSigla.setBounds(581, 243, 113, 28);
		add(lblSigla);

		JButton btnGravarTurma = new JButton("Gravar");
		btnGravarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarTurma() == 1) {

					// Calendar ano = Calendar.getInstance();

					control.CursoControl.BuscarCursoNome(cbCursoTurma.getSelectedItem().toString(), "turma");

					String completoTurma = abreviaturaCurso + cbSerieTurma.getSelectedItem().toString()
							+ cbSiglaTurma.getSelectedItem().toString() + cbPeriodoTurma.getSelectedItem().toString();

					int resultado = control.TurmaControl.BuscarTurmaNomeValidacao(completoTurma);

					if (resultado == 1) {
					}

					else {

						String periodo = "";
						if (cbPeriodoTurma.getSelectedItem().toString() == "Manhã") {
							periodo = "M";
						} else {
							periodo = "T";
						}

						String ano = "";
						if (cbSerieTurma.getSelectedItem().toString() == "1º ano") {
							ano = "1";
						} else if (cbSerieTurma.getSelectedItem().toString() == "2º ano") {
							ano = "2";
						} else {
							ano = "3";
						}

						control.TurmaControl.CadastrarTurma(idCurso, ano, cbSiglaTurma.getSelectedItem().toString(),
								periodo
						// Integer.toString(ano.get(Calendar.YEAR))
						);

						LimparTurma();

					}

				}

			}
		});
		btnGravarTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarTurma.setBounds(312, 345, 161, 55);
		add(btnGravarTurma);

		JButton btnAlterarTurma = new JButton("Alterar");
		btnAlterarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ValidarTurma() == 1) {

					// Calendar ano = Calendar.getInstance();

					control.CursoControl.BuscarCursoNome(cbCursoTurma.getSelectedItem().toString(), "turma");

					String periodo = "";
					if (cbPeriodoTurma.getSelectedItem().toString() == "Manhã") {
						periodo = "M";
					} else {
						periodo = "T";
					}

					String ano = "";
					if (cbSerieTurma.getSelectedItem().toString() == "1º ano") {
						ano = "1";
					} else if (cbSerieTurma.getSelectedItem().toString() == "2º ano") {
						ano = "2";
					} else {
						ano = "3";
					}

					String completoTurma = abreviaturaCurso + ano + cbSiglaTurma.getSelectedItem().toString() + periodo;
					System.out.println(completoTurma);

					control.TurmaControl.AlterarTurma(Integer.parseInt(txtCodigo.getText()), idCurso, ano,
							cbSiglaTurma.getSelectedItem().toString(), periodo, completoTurma);

					LimparTurma();

				}

			}
		});
		btnAlterarTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnAlterarTurma.setBounds(494, 345, 161, 55);
		add(btnAlterarTurma);

		JButton btnExcluirTurma = new JButton("Excluir");
		btnExcluirTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ValidarTurma() == 1) {

					// Calendar ano = Calendar.getInstance();

					control.CursoControl.BuscarCursoNome(cbCursoTurma.getSelectedItem().toString(), "turma");

					String periodo = "";
					if (cbPeriodoTurma.getSelectedItem().toString() == "Manhã") {
						periodo = "M";
					} else {
						periodo = "T";
					}

					String ano = "";
					if (cbSerieTurma.getSelectedItem().toString() == "1º ano") {
						ano = "1";
					} else if (cbSerieTurma.getSelectedItem().toString() == "2º ano") {
						ano = "2";
					} else {
						ano = "3";
					}


					control.TurmaControl.ExcluirTurma(Integer.parseInt(txtCodigo.getText()));

					LimparTurma();

				}

			}
		});
		btnExcluirTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnExcluirTurma.setBounds(674, 345, 161, 55);
		add(btnExcluirTurma);

		JButton btnLimparTurma = new JButton("Limpar");
		btnLimparTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTurma();
			}
		});
		btnLimparTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimparTurma.setBounds(858, 345, 161, 55);
		add(btnLimparTurma);

		JButton button = new JButton("Pesquisar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtNomeTurma.isEnabled() == false) {
					txtNomeTurma.setEnabled(true);
					txtNomeTurma.setText("");
					txtNomeTurma.requestFocus();
					cbCursoTurma.setEditable(false);
					LimparTurma();
				} else {

					txtNomeTurma.setEnabled(false);
					if (txtNomeTurma.getText().trim().length() != 0) {

						control.TurmaControl.BuscarTurmaNome(txtNomeTurma.getText(), "consultar");

					} else {
						txtNomeTurma.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Digite uma turma");
						txtNomeTurma.requestFocus();
					}
				}

			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		button.setBounds(722, 118, 169, 35);
		add(button);

		cbPeriodoTurma = new JComboBox();
		cbPeriodoTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbPeriodoTurma.setBounds(758, 275, 161, 35);
		add(cbPeriodoTurma);
		cbPeriodoTurma.addItem("");
		cbPeriodoTurma.addItem("Manhã");
		cbPeriodoTurma.addItem("Tarde");

		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblPerodo.setBounds(758, 236, 113, 28);
		add(lblPerodo);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(342, 153, 46, 14);
		add(lblNewLabel);

		JLabel lblCadastroDeTurmas_1 = new JLabel("Cadastro de Turmas");
		lblCadastroDeTurmas_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeTurmas_1.setBounds(506, 11, 319, 40);
		add(lblCadastroDeTurmas_1);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(402, 118, 121, 35);
		add(txtCodigo);

		JLabel lblCdigo_1 = new JLabel("C\u00F3digo");
		lblCdigo_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCdigo_1.setBounds(402, 84, 89, 35);
		add(lblCdigo_1);

	}

	public int ValidarTurma() {
		int validar = 0;

		try {
			if ((cbCursoTurma.getSelectedItem().toString().trim().length() != 0)
					&& (cbSerieTurma.getSelectedItem().toString().trim().length() != 0)
					&& (cbSiglaTurma.getSelectedItem().toString().trim().length() != 0))

			{
				validar = 1;
			} else {
				JOptionPane.showMessageDialog(null, "Preenchimento de campos incorretos");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Preenchimento de campos incorretos");
		}

		return validar;
	}

	public void LimparTurma() {
		txtCodigo.setText("");
		txtNomeTurma.setText("");
		cbCursoTurma.setSelectedIndex(-1);
		cbSerieTurma.setSelectedIndex(-1);
		cbSiglaTurma.setSelectedIndex(-1);
		cbPeriodoTurma.setSelectedIndex(-1);
	}
}

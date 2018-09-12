package view.Administracao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class pnlCursoCadastro extends JPanel {
	public static JTextField txtNomeCurso;
	public static JTextField txtAbreviaturaCurso;
	public static JTextField txtCodigo;
	private static JLabel vNome;
	private static JLabel vAbreviatura;

	/**
	 * Create the panel.
	 */
	public pnlCursoCadastro() {
		setBackground(Color.WHITE);
		setLayout(null);

		txtNomeCurso = new JTextField();
		txtNomeCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNomeCurso.setColumns(10);
		txtNomeCurso.setBounds(398, 161, 476, 36);
		add(txtNomeCurso);

		JLabel label = new JLabel("Nome");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(397, 125, 135, 36);
		add(label);

		txtAbreviaturaCurso = new JTextField();
		txtAbreviaturaCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtAbreviaturaCurso.setColumns(10);
		txtAbreviaturaCurso.setBounds(399, 237, 155, 36);
		add(txtAbreviaturaCurso);

		JLabel lblAbreviatura = new JLabel("Abreviatura");
		lblAbreviatura.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAbreviatura.setBounds(398, 208, 177, 28);
		add(lblAbreviatura);

		JButton btnGravarCurso = new JButton("Gravar");
		btnGravarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarCurso() == 1) {

					int resultado = control.CursoControl.BuscarCursoNomeValidacao(txtNomeCurso.getText());

					if (resultado == 1) {
					}

					else {

						control.CursoControl.CadastrarCurso(txtNomeCurso.getText(), txtAbreviaturaCurso.getText());
					}

					LimparCurso();

				}

			}
		});
		btnGravarCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarCurso.setBounds(326, 295, 147, 55);
		add(btnGravarCurso);

		JButton btnAlterarCurso = new JButton("Alterar");
		btnAlterarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ValidarCurso() == 1) {

					if (txtCodigo.getText().toString().trim().length() != 0) {

						control.CursoControl.AlterarCurso(Integer.parseInt(txtCodigo.getText()), txtNomeCurso.getText(),
								txtAbreviaturaCurso.getText());
						
						LimparCurso();
					} else {
						JOptionPane.showMessageDialog(null, "É necessário o código");

					}

				}
			}
		});
		btnAlterarCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnAlterarCurso.setBounds(493, 295, 147, 55);
		add(btnAlterarCurso);

		JButton btnExcluirCurso = new JButton("Excluir");
		btnExcluirCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ValidarCurso() == 1) {

					if (txtCodigo.getText().toString().trim().length() != 0) {

						control.CursoControl.ExcluirCurso(Integer.parseInt(txtCodigo.getText()));
						
						LimparCurso();
					} else {
						JOptionPane.showMessageDialog(null, "É necessário o código");

					}

				}
			}
		});
		btnExcluirCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnExcluirCurso.setBounds(667, 295, 147, 55);
		add(btnExcluirCurso);

		JButton btnLimparCurso = new JButton("Limpar");
		btnLimparCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparCurso();
			}
		});
		btnLimparCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimparCurso.setBounds(840, 295, 147, 55);
		add(btnLimparCurso);

		JLabel lblCadastroDeCursos = new JLabel("Cadastro de Cursos");
		lblCadastroDeCursos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeCursos.setBounds(519, 11, 319, 40);
		add(lblCadastroDeCursos);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(399, 91, 102, 36);
		add(txtCodigo);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCdigo.setBounds(398, 62, 177, 28);
		add(lblCdigo);

		vNome = new JLabel("*");
		vNome.setForeground(Color.RED);
		vNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vNome.setBounds(370, 161, 28, 35);
		add(vNome);

		vAbreviatura = new JLabel("*");
		vAbreviatura.setForeground(Color.RED);
		vAbreviatura.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vAbreviatura.setBounds(370, 237, 28, 35);
		add(vAbreviatura);

	}

	public int ValidarCurso() {
		int validar = 0;

		if ((txtNomeCurso.getText().trim().length() != 0) && (txtAbreviaturaCurso.getText().trim().length() == 3)) {
			validar = 1;
		} else {
			JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");

			if (txtNomeCurso.getText().trim().length() == 0) {
				vNome.setVisible(true);
			} else {
				vNome.setVisible(false);
			}

			if (txtAbreviaturaCurso.getText().trim().length() != 3) {
				vAbreviatura.setVisible(true);
			} else {
				vAbreviatura.setVisible(false);
			}

		}

		return validar;
	}

	public static void LimparCurso() {
		txtCodigo.setText("");
		txtNomeCurso.setText("");
		vNome.setVisible(false);
		txtAbreviaturaCurso.setText("");
		vAbreviatura.setVisible(false);
	}
}

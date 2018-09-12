package view.Administracao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import model.Curso;
import model.Turma;

public class pnlMateriaCadastro extends JPanel {

	public static JTextField txtNomeDisciplina;
	public static JComboBox cbSerieMateria;
	public static JComboBox<Curso> cbCursoMateria;

	public static int idCurso = 0;
	public static JTextField txtCodigo;
	public static JLabel vNome;

	/**
	 * Create the panel.
	 */
	public pnlMateriaCadastro() {
		setBackground(Color.WHITE);
		setLayout(null);

		cbCursoMateria = new JComboBox<Curso>();
		control.CursoControl.carregarComboCurso(cbCursoMateria);

		cbCursoMateria = new JComboBox();
		cbCursoMateria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbCursoMateria.setBounds(507, 333, 342, 35);
		add(cbCursoMateria);

		JLabel label = new JLabel("Curso");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(507, 303, 113, 29);
		add(label);

		JButton btnGravarMateria = new JButton("Gravar");
		btnGravarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ValidarMateria() == 1) {

					int serie = 0;
					if (cbSerieMateria.getSelectedItem().toString() == "1º ano") {
						serie = 1;
					} else if (cbSerieMateria.getSelectedItem().toString() == "2º ano") {
						serie = 2;
					} else {
						serie = 3;
					}

					control.CursoControl.BuscarCursoNome(cbCursoMateria.getSelectedItem().toString(), "disciplina");

					if (control.DisciplinaControl.BuscarDisciplinaNomeValidacao(txtNomeDisciplina.getText(), serie,
							idCurso) == false) {

						control.DisciplinaControl.CadastrarDisciplina(txtNomeDisciplina.getText(), serie, idCurso);

						LimparMateria();
					} else {
						JOptionPane.showMessageDialog(null, "Disciplina já existe");
					}

				}

			}
		});
		btnGravarMateria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarMateria.setBounds(325, 394, 160, 55);
		add(btnGravarMateria);

		JButton btnAlterarMateria = new JButton("Alterar");
		btnAlterarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ValidarMateria() == 1) {

					if (txtCodigo.getText().toString().trim().length() != 0) {

						int serie = 0;
						if (cbSerieMateria.getSelectedItem().toString() == "1º ano") {
							serie = 1;
						} else if (cbSerieMateria.getSelectedItem().toString() == "2º ano") {
							serie = 2;
						} else {
							serie = 3;
						}

						control.CursoControl.BuscarCursoNome(cbCursoMateria.getSelectedItem().toString(), "disciplina");

						control.DisciplinaControl.AlterarDisciplina(Integer.parseInt(txtCodigo.getText()),
								txtNomeDisciplina.getText(), serie, idCurso);

						LimparMateria();

					} else {
						JOptionPane.showMessageDialog(null, "É necessário código");
					}
				}
			}
		});
		btnAlterarMateria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnAlterarMateria.setBounds(515, 394, 160, 55);
		add(btnAlterarMateria);

		JButton btnExcluirMateria = new JButton("Excluir");
		btnExcluirMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (ValidarMateria() == 1) {

					if (txtCodigo.getText().toString().trim().length() != 0) {

						int serie = 0;
						if (cbSerieMateria.getSelectedItem().toString() == "1º ano") {
							serie = 1;
						} else if (cbSerieMateria.getSelectedItem().toString() == "2º ano") {
							serie = 2;
						} else {
							serie = 3;
						}

						control.CursoControl.BuscarCursoNome(cbCursoMateria.getSelectedItem().toString(), "disciplina");

						control.DisciplinaControl.ExcluirDisciplina(Integer.parseInt(txtCodigo.getText()));

						LimparMateria();

					} else {
						JOptionPane.showMessageDialog(null, "É necessário código");
					}
				}
				
			}
		});
		btnExcluirMateria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnExcluirMateria.setBounds(704, 394, 160, 55);
		add(btnExcluirMateria);

		JButton btnLimparMateria = new JButton("Limpar");
		btnLimparMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LimparMateria();
			}
		});
		btnLimparMateria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimparMateria.setBounds(894, 394, 160, 55);
		add(btnLimparMateria);

		txtNomeDisciplina = new JTextField();
		txtNomeDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtNomeDisciplina.setColumns(10);
		txtNomeDisciplina.setBounds(507, 184, 342, 36);
		add(txtNomeDisciplina);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblNome.setBounds(507, 147, 71, 35);
		add(lblNome);

		cbSerieMateria = new JComboBox();
		cbSerieMateria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbSerieMateria.setBounds(507, 259, 155, 35);
		add(cbSerieMateria);
		cbSerieMateria.addItem("");
		cbSerieMateria.addItem("1º ano");
		cbSerieMateria.addItem("2º ano");
		cbSerieMateria.addItem("3º ano");

		JLabel lblSrie = new JLabel("S\u00E9rie");
		lblSrie.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblSrie.setBounds(507, 231, 113, 29);
		add(lblSrie);

		JLabel lblCadastroDeDisciplina = new JLabel("Cadastro de Disciplina");
		lblCadastroDeDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeDisciplina.setBounds(603, 11, 319, 40);
		add(lblCadastroDeDisciplina);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(507, 99, 125, 36);
		add(txtCodigo);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCdigo.setBounds(507, 62, 113, 35);
		add(lblCdigo);

		vNome = new JLabel("*");
		vNome.setForeground(Color.RED);
		vNome.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vNome.setBounds(480, 184, 28, 35);
		add(vNome);

	}

	public int ValidarMateria() {
		int validar = 0;

		if ((txtNomeDisciplina.getText().trim().length() != 0)
				&& (cbSerieMateria.getSelectedItem().toString().trim().length() != 0)
				&& (cbCursoMateria.getSelectedItem().toString().trim().length() != 0))

		{
			validar = 1;
		}

		else {

			if (txtNomeDisciplina.getText().trim().length() == 0) {
				vNome.setVisible(true);
			} else {
				vNome.setVisible(false);
			}

			JOptionPane.showMessageDialog(null, "Preenchimento de campos incorretos");
		}

		return validar;
	}

	public static void LimparMateria() {
		txtCodigo.setText("");
		txtNomeDisciplina.setText("");
		vNome.setVisible(false);
		cbSerieMateria.setSelectedIndex(-1);
		cbCursoMateria.setSelectedIndex(-1);
	}
}

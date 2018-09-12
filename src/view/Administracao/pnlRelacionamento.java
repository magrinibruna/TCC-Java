package view.Administracao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Atribuicao;
import model.Disciplina;
import model.Professor;
import model.Turma;

public class pnlRelacionamento extends JPanel {

	public static JComboBox<Disciplina> cbDisciplina;
	public static JComboBox<Professor> cbProfessor;
	public static JComboBox<Turma> cbTurma;
	public static JComboBox<Atribuicao> cbAtribuicao;

	public static int codigoProfessor = 0;
	public static int codigoDisciplina = 0;
	public static int idTurma = 0;
	public static int idAtribuicao = 0;

	/**
	 * Create the panel.
	 */
	public pnlRelacionamento() {
		setBackground(Color.WHITE);
		setLayout(null);

		cbDisciplina = new JComboBox<Disciplina>();
		control.DisciplinaControl.carregarComboDisciplina(cbDisciplina);

		cbProfessor = new JComboBox<Professor>();
		control.ProfessorControl.carregarComboProfessor(cbProfessor);

		cbTurma = new JComboBox<Turma>();
		// control.TurmaControl.carregarComboTurma(cbTurma);

		cbAtribuicao = new JComboBox<Atribuicao>();
		cbAtribuicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] serie = cbAtribuicao.getSelectedItem().toString().trim().split(" ");

				control.TurmaControl.carregarComboTurmaPorAno(cbTurma, serie[4].substring(0, 1));
				// System.out.println(serie[4].substring(0, 1));

			}
		});
		control.AtribuicaoControl.carregarComboAtribuicao(cbAtribuicao);

		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblProfessor.setBounds(301, 65, 140, 35);
		add(lblProfessor);

		cbProfessor = new JComboBox<Professor>();
		cbProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbProfessor.setBounds(301, 100, 325, 35);
		add(cbProfessor);

		JButton btnGravarProfessorDisciplina = new JButton("Gravar");
		btnGravarProfessorDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null,
							"Você tem certeza que deseja gravar o relacionamento?", "Confirmação", dialogButton);

					if (dialogResult == JOptionPane.YES_OPTION) {

						String[] textoDisciplina = cbDisciplina.getSelectedItem().toString().trim().split(" ");

						if (control.AtribuicaoControl.AtribuicaoValidacao(
								cbProfessor.getSelectedItem() + ", " + cbDisciplina.getSelectedItem())) {

							control.ProfessorControl.BuscarProfessorNome(cbProfessor.getSelectedItem().toString());
							control.DisciplinaControl.BuscarDisciplinaNome(textoDisciplina[0],
									Integer.parseInt(textoDisciplina[2].substring(0, 1)));
							control.AtribuicaoControl.CadastrarAtribuicao(codigoProfessor, codigoDisciplina,
									cbProfessor.getSelectedItem() + ", " + cbDisciplina.getSelectedItem());

							control.AtribuicaoControl.carregarComboAtribuicao(cbAtribuicao);
						} else {
							JOptionPane.showMessageDialog(null, "Atribuição já existe");
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro na gravação");
				}

			}
		});
		btnGravarProfessorDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarProfessorDisciplina.setBounds(919, 156, 160, 55);

		add(btnGravarProfessorDisciplina);

		cbDisciplina = new JComboBox<Disciplina>();
		cbDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbDisciplina.setBounds(723, 100, 356, 35);
		add(cbDisciplina);

		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblDisciplina.setBounds(723, 65, 133, 35);
		add(lblDisciplina);

		JLabel lblEnsina = new JLabel("ensina");
		lblEnsina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblEnsina.setBounds(636, 100, 77, 30);
		add(lblEnsina);

		// cbAtribuicao = new JComboBox<Atribuicao>();
		cbAtribuicao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbAtribuicao.setBounds(301, 254, 778, 31);
		add(cbAtribuicao);

		JLabel lblProfessorEDisciplna = new JLabel("Professor e Disciplina");
		lblProfessorEDisciplna.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblProfessorEDisciplna.setBounds(301, 215, 291, 45);
		add(lblProfessorEDisciplna);

		JLabel lblEnsinam = new JLabel("ensinam para");
		lblEnsinam.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblEnsinam.setBounds(578, 296, 224, 35);
		add(lblEnsinam);

		// cbTurma = new JComboBox<Turma>();
		cbTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbTurma.setBounds(301, 359, 306, 37);
		add(cbTurma);

		JLabel lblTurma = new JLabel("Turma");
		lblTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblTurma.setBounds(301, 330, 109, 28);
		add(lblTurma);

		JButton btnGravarProfessorDisciplinaTurma = new JButton("Gravar");
		btnGravarProfessorDisciplinaTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null,
							"Você tem certeza que deseja gravar o relacionamento?", "Confirmação", dialogButton);

					if (dialogResult == JOptionPane.YES_OPTION) {

						control.TurmaControl.BuscarTurmaNomeCadastros(cbTurma.getSelectedItem().toString(),
								"relacionamento");
						control.AtribuicaoControl.BuscarAtribuicaoNome(cbAtribuicao.getSelectedItem().toString(),
								"relacionamento");

						if (control.AtribuicaoTurmaControl.AtribuicaoTurmaValidacao(idAtribuicao, idTurma)) {

							control.AtribuicaoTurmaControl.CadastrarAtribuicaoTurma(idAtribuicao, idTurma);

						} else {
							JOptionPane.showMessageDialog(null, "Atribuicao - Turma já existe");
						}

					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao gravar");
				}

			}
		});
		btnGravarProfessorDisciplinaTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarProfessorDisciplinaTurma.setBounds(919, 346, 160, 63);
		add(btnGravarProfessorDisciplinaTurma);

		JLabel lblCadastroDeRelacionamentos = new JLabel("Cadastro de Relacionamentos");
		lblCadastroDeRelacionamentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeRelacionamentos.setBounds(535, 0, 425, 40);
		add(lblCadastroDeRelacionamentos);

	}
}

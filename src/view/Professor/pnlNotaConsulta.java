package view.Professor;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.vwAtribuicao;
import model.vwProfessor;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlNotaConsulta extends JPanel {

	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static JComboBox<vwProfessor> cbDisciplina;
	public static JComboBox<vwAtribuicao> cbTurma;
	static String avaliacao = "";
	static String trimestre = "";
	public static JTable tblNota;
	private static JRadioButton rdbtn1;
	private static JRadioButton rdbtn2;
	private static JRadioButton rdbtn3;

	int validacao = 0;
	public static int codigoProfessor = 0;
	public static String nomeProfessor = "";
	public static int codigoAtribuicao = 0;
	public static int codigoTurma = 0;
	public static int codigoAtribuicaoTurma = 0;
	private static JRadioButton rdbtnTodas;
	private JLabel lblAvaliao;
	private static JRadioButton rdbtnPAT;
	private static JRadioButton rdbtnPEM;
	private static JRadioButton rdbtnAtitudinal;
	private static JRadioButton rdbtnTrabalho;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public pnlNotaConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("Mat\u00E9ria");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(104, 56, 109, 28);
		add(label);

		cbDisciplina = new JComboBox();
		cbDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.AtribuicaoControl.BuscarAtribuicaoNome(nomeProfessor + ", " + cbDisciplina.getSelectedItem(),
						"nota2");
				control.NotaControl.carregarComboTurmaNota(cbTurma, codigoAtribuicao);
			}
		});
		cbDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbDisciplina.setBounds(104, 82, 212, 35);
		add(cbDisciplina);

		cbTurma = new JComboBox();
		cbTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.TurmaControl.BuscarTurmaNome(cbTurma.getSelectedItem().toString(), "nota2");
				control.AtribuicaoTurmaControl.BuscarAtribuicacoTurma(codigoAtribuicao, codigoTurma);
				validacao = 1;
			}
		});
		cbTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbTurma.setBounds(328, 82, 212, 35);
		add(cbTurma);

		JLabel label_1 = new JLabel("Turma");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_1.setBounds(328, 56, 109, 28);
		add(label_1);

		JLabel lblConsultaDeNotas = new JLabel("Consulta de Notas");
		lblConsultaDeNotas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeNotas.setBounds(606, 11, 319, 40);
		add(lblConsultaDeNotas);

		rdbtn2 = new JRadioButton("2");
		buttonGroup.add(rdbtn2);
		rdbtn2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn2.setBackground(Color.WHITE);
		rdbtn2.setBounds(1140, 94, 40, 23);
		add(rdbtn2);

		rdbtn1 = new JRadioButton("1");
		rdbtn1.setSelected(true);
		buttonGroup.add(rdbtn1);
		rdbtn1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn1.setBackground(Color.WHITE);
		rdbtn1.setBounds(1098, 94, 40, 23);
		add(rdbtn1);

		JLabel label_2 = new JLabel("Trimestre");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_2.setBounds(1098, 62, 109, 28);
		add(label_2);

		rdbtn3 = new JRadioButton("3");
		buttonGroup.add(rdbtn3);
		rdbtn3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn3.setBackground(Color.WHITE);
		rdbtn3.setBounds(1194, 94, 67, 23);
		add(rdbtn3);

		tblNota = new JTable();
		tblNota.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblNota);
		scrollPane.setBounds(104, 137, 1160, 427);
		add(scrollPane);

		JButton btnConsultar = new JButton("Consultar");
		buttonGroup_1.add(btnConsultar);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validacao == 1) {
					String trimestreEscolhido = Trimestre();

					if (Avaliacao() == "Geral") {
						control.ProcNotaControl.ConsultarNotaProfessor(codigoAtribuicaoTurma, trimestreEscolhido);
					} else {
						control.ProcNotaControl.ConsultarNotaProfessorAvaliacao(codigoAtribuicaoTurma, trimestreEscolhido, avaliacao);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma turma");
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1125, 575, 161, 55);
		add(btnConsultar);

		rdbtnTodas = new JRadioButton("Todas");
		buttonGroup_1.add(rdbtnTodas);
		rdbtnTodas.setSelected(true);
		rdbtnTodas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnTodas.setBackground(Color.WHITE);
		rdbtnTodas.setBounds(583, 94, 83, 23);
		add(rdbtnTodas);

		lblAvaliao = new JLabel("Avalia\u00E7\u00E3o");
		lblAvaliao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblAvaliao.setBounds(583, 62, 109, 28);
		add(lblAvaliao);

		rdbtnPAT = new JRadioButton("PAT");
		buttonGroup_1.add(rdbtnPAT);
		rdbtnPAT.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnPAT.setBackground(Color.WHITE);
		rdbtnPAT.setBounds(671, 94, 73, 23);
		add(rdbtnPAT);

		rdbtnPEM = new JRadioButton("PEM");
		buttonGroup_1.add(rdbtnPEM);
		rdbtnPEM.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnPEM.setBackground(Color.WHITE);
		rdbtnPEM.setBounds(746, 94, 83, 23);
		add(rdbtnPEM);

		rdbtnAtitudinal = new JRadioButton("Atitudinal");
		buttonGroup_1.add(rdbtnAtitudinal);
		rdbtnAtitudinal.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnAtitudinal.setBackground(Color.WHITE);
		rdbtnAtitudinal.setBounds(952, 94, 123, 23);
		add(rdbtnAtitudinal);

		rdbtnTrabalho = new JRadioButton("Trabalho");
		buttonGroup_1.add(rdbtnTrabalho);
		rdbtnTrabalho.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnTrabalho.setBackground(Color.WHITE);
		rdbtnTrabalho.setBounds(831, 94, 119, 23);
		add(rdbtnTrabalho);

	}

	public static String Trimestre() {

		if (rdbtn1.isSelected() == true) {
			trimestre = "1º Trimestre";
		} else if (rdbtn2.isSelected() == true) {
			trimestre = "2º Trimestre";
		} else {
			trimestre = "3º Trimestre";
		}

		return trimestre;
	}

	public static String Avaliacao() {

		if (rdbtnTodas.isSelected() == true) {
			avaliacao = "Geral";
		} else if (rdbtnPAT.isSelected() == true) {
			avaliacao = "PAT";
		} else if (rdbtnPEM.isSelected() == true) {
			avaliacao = "PEM";
		} else if (rdbtnTrabalho.isSelected() == true) {
			avaliacao = "Trabalho";
		} else {
			avaliacao = "Atitudinal";
		}
		return avaliacao;
	}
}

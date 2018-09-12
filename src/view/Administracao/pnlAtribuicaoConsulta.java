package view.Administracao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class pnlAtribuicaoConsulta extends JPanel {

	public static JTable tblAtribuicao;
	public static JTable tblAtribuicaoTurma;
	
	/**
	 * Create the panel.
	 */
	public pnlAtribuicaoConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		tblAtribuicao = new JTable();
		tblAtribuicao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblAtribuicao);
		scrollPane.setBounds(66, 112, 1182, 220);
		add(scrollPane);

		JLabel lblConsultaDeRelacionamentos = new JLabel("Consulta de Relacionamentos");
		lblConsultaDeRelacionamentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeRelacionamentos.setBounds(538, 11, 347, 62);
		add(lblConsultaDeRelacionamentos);

		tblAtribuicaoTurma = new JTable();
		tblAtribuicaoTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane_1 = new JScrollPane(tblAtribuicaoTurma);
		scrollPane_1.setBounds(66, 413, 1182, 220);
		add(scrollPane_1);

		JLabel lblProfessorEMatria = new JLabel("Professor e Mat\u00E9ria");
		lblProfessorEMatria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblProfessorEMatria.setBounds(66, 57, 347, 62);
		add(lblProfessorEMatria);

		JLabel lblProfessorMatriaE = new JLabel("Professor, Mat\u00E9ria e Turma");
		lblProfessorMatriaE.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblProfessorMatriaE.setBounds(66, 354, 347, 62);
		add(lblProfessorMatriaE);

	}

}

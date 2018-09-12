package view.Aluno;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class pnlNota extends JPanel {

	public static int rm = 0;
	public static JTable tblNota;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnAvaliacao;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnConsultar;

	/**
	 * Create the panel.
	 */
	public pnlNota() {
		setBackground(Color.WHITE);
		setLayout(null);

		tblNota = new JTable();
		tblNota.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblNota);
		scrollPane.setBounds(128, 133, 1132, 455);
		add(scrollPane);

		JLabel lbl = new JLabel("Notas");
		lbl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lbl.setBounds(663, 24, 94, 41);
		add(lbl);

		JRadioButton rdbtn1 = new JRadioButton("1");
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbtn1);
		rdbtn1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn1.setBackground(Color.WHITE);
		rdbtn1.setBounds(1099, 102, 52, 23);
		add(rdbtn1);

		JRadioButton rdbtn2 = new JRadioButton("2");
		rdbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbtn2);
		rdbtn2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn2.setBackground(Color.WHITE);
		rdbtn2.setBounds(1151, 102, 51, 23);
		add(rdbtn2);

		JLabel label = new JLabel("Trimestre");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(1099, 75, 109, 28);
		add(label);

		JRadioButton rdbtn3 = new JRadioButton("3");
		rdbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbtn3);
		rdbtn3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn3.setBackground(Color.WHITE);
		rdbtn3.setBounds(1204, 102, 52, 23);
		rdbtn3.setSelected(true);
		add(rdbtn3);

		rdbtnAvaliacao = new JRadioButton("Avalia\u00E7\u00F5es");
		buttonGroup_1.add(rdbtnAvaliacao);
		rdbtnAvaliacao.setSelected(true);
		rdbtnAvaliacao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnAvaliacao.setBackground(Color.WHITE);
		rdbtnAvaliacao.setBounds(128, 102, 137, 23);
		add(rdbtnAvaliacao);

		JLabel label_1 = new JLabel("Por:");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_1.setBounds(137, 64, 109, 28);
		add(label_1);

		JRadioButton rbtnMedia = new JRadioButton("M\u00E9dias");
		buttonGroup_1.add(rbtnMedia);
		rbtnMedia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rbtnMedia.setBackground(Color.WHITE);
		rbtnMedia.setBounds(273, 102, 147, 23);
		add(rbtnMedia);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int trimestre = 0;

				if (rdbtn1.isSelected()) {
					trimestre = 1;
				} else if (rdbtn2.isSelected()) {
					trimestre = 2;
				} else if (rdbtn3.isSelected()) {
					trimestre = 3;
				}

				if (rdbtnAvaliacao.isSelected()) {
					control.ProcNotaControl.ConsultarNota(rm, trimestre);
				} else {
					control.ProcNotaControl.ConsultarNota2(rm, trimestre);
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1099, 599, 161, 55);
		add(btnConsultar);

	}
}

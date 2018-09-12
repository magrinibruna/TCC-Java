package view.Administracao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class pnlNota extends JPanel {

	public static JTable tblNota;

	public static int trimestre = 3;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static JTextField txtRM;
	private static JRadioButton rdbtn1;
	private static JRadioButton rdbtn2;
	private static JRadioButton rdbtn3;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnNota;
	private JRadioButton rdbtnNota2;

	/**
	 * Create the panel.
	 */
	public pnlNota() {
		setBackground(Color.WHITE);
		setLayout(null);

		tblNota = new JTable();
		tblNota.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblNota);
		scrollPane.setBounds(65, 121, 1160, 455);
		add(scrollPane);

		rdbtn2 = new JRadioButton("2");
		rdbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbtn2);
		rdbtn2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn2.setBackground(Color.WHITE);
		rdbtn2.setBounds(1105, 87, 51, 23);
		add(rdbtn2);

		rdbtn1 = new JRadioButton("1");
		rdbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbtn1);
		rdbtn1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn1.setBackground(Color.WHITE);
		rdbtn1.setBounds(1053, 87, 52, 23);
		add(rdbtn1);

		JLabel label = new JLabel("Trimestre");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(1053, 60, 109, 28);
		add(label);

		JLabel label_1 = new JLabel("Notas");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label_1.setBounds(586, 11, 94, 41);
		add(label_1);

		rdbtn3 = new JRadioButton("3");
		buttonGroup.add(rdbtn3);
		rdbtn3.setSelected(true);
		rdbtn3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtn3.setBackground(Color.WHITE);
		rdbtn3.setBounds(1158, 87, 67, 23);
		add(rdbtn3);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Validacao() == 1) {

					if (control.AlunoControl.BuscarAlunoRMValidacao(Integer.parseInt(txtRM.getText()))) {
						Trimestre();

						if (rdbtnNota.isSelected()) {
							//avaliação
							control.ProcNotaControl.ConsultarNotaADM(Integer.parseInt(txtRM.getText()), trimestre);
						} else {
							//média
							control.ProcNotaControl.ConsultarNotaADM2(Integer.parseInt(txtRM.getText()), trimestre);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Aluno não existe");
						txtRM.requestFocus();
					}
				}

			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(893, 587, 161, 55);
		add(btnConsultar);

		txtRM = new JTextField();
		txtRM.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtRM.setColumns(10);
		txtRM.setBounds(65, 74, 94, 36);
		add(txtRM);

		JButton btnRelatorio = new JButton("Boletim");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Validacao() == 1) {
					Trimestre();
					if (control.AlunoControl.BuscarAlunoRMValidacao(Integer.parseInt(txtRM.getText()))) {
						control.ProcNotaControl.ConsultarJasper(Integer.parseInt(txtRM.getText()), trimestre);
					} else {
						JOptionPane.showMessageDialog(null, "Aluno não existe");
						txtRM.requestFocus();
					}
				}
			}
		});
		btnRelatorio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnRelatorio.setBounds(1064, 587, 161, 55);
		add(btnRelatorio);

		JLabel lblRm = new JLabel("RM");
		lblRm.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblRm.setBounds(65, 43, 109, 28);
		add(lblRm);

		rdbtnNota = new JRadioButton("Avalia\u00E7\u00F5es");
		buttonGroup_1.add(rdbtnNota);
		rdbtnNota.setSelected(true);
		rdbtnNota.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnNota.setBackground(Color.WHITE);
		rdbtnNota.setBounds(165, 81, 137, 23);
		add(rdbtnNota);

		rdbtnNota2 = new JRadioButton("M\u00E9dias");
		buttonGroup_1.add(rdbtnNota2);
		rdbtnNota2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnNota2.setBackground(Color.WHITE);
		rdbtnNota2.setBounds(310, 81, 147, 23);
		add(rdbtnNota2);

		JLabel lblTipo = new JLabel("Por:");
		lblTipo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblTipo.setBounds(174, 43, 109, 28);
		add(lblTipo);

	}

	public static int Trimestre() {

		if (rdbtn1.isSelected() == true) {
			trimestre = 1;
		} else if (rdbtn2.isSelected() == true) {
			trimestre = 2;
		} else {
			trimestre = 3;
		}

		return trimestre;
	}

	public static int Validacao() {
		int resultado = 0;

		if (txtRM.getText().trim().length() == 5) {
			resultado = 1;
		} else {
			JOptionPane.showMessageDialog(null, "RM inválido");
		}

		return resultado;
	}
}

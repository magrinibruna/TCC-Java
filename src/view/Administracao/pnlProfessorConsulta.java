package view.Administracao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class pnlProfessorConsulta extends JPanel {

	public static JTable tblProfessor;
	private JButton btnConsultar;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public pnlProfessorConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		tblProfessor = new JTable();
		tblProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblProfessor);
		scrollPane.setBounds(71, 111, 1182, 461);
		add(scrollPane);

		JLabel lblConsultaDeProfessores = new JLabel("Consulta de Professores");
		lblConsultaDeProfessores.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeProfessores.setBounds(556, 11, 347, 62);
		add(lblConsultaDeProfessores);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnConsultar.getText() == "Consultar") {
					try {
						int row = tblProfessor.getSelectedRow();

						view.Administracao.pnlProfessorCadastro.LimparProfessor();

						view.Administracao.pnlProfessorCadastro.txtCodigoProfessor
								.setText(String.valueOf(tblProfessor.getValueAt(row, 0)));
						view.Administracao.pnlProfessorCadastro.txtNomeProfessor
								.setText(String.valueOf(tblProfessor.getValueAt(row, 1)));
						view.Administracao.pnlProfessorCadastro.txtSobrenomeProfessor
								.setText(String.valueOf(tblProfessor.getValueAt(row, 2)));
						view.Administracao.pnlProfessorCadastro.txtCPFProfessor
								.setText(String.valueOf(tblProfessor.getValueAt(row, 3)));
						view.Administracao.pnlProfessorCadastro.txtEmailProfessor
								.setText(String.valueOf(tblProfessor.getValueAt(row, 4)));
						view.Administracao.frmAdministracao.painelAtivo("pnlProfessorCadastro");

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione umx professxrx");
					}
				} else {
					try {
						int row = tblProfessor.getSelectedRow();
						control.ProfessorControl.AlterarEstadoProfessor((int) tblProfessor.getValueAt(row, 0), 1);
						control.ProfessorControl.ConsultaProfessorExcluido();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione umx professxrx");
					}
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1092, 589, 161, 55);
		add(btnConsultar);

		JRadioButton radioButton = new JRadioButton("Ativo");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Consultar");
				control.ProfessorControl.ConsultaProfessor();
			}
		});
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(71, 81, 109, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Inativo");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Recuperar");
				control.ProfessorControl.ConsultaProfessorExcluido();
			}
		});
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(187, 81, 139, 23);
		add(radioButton_1);

	}
}

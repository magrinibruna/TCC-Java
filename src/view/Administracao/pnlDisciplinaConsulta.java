package view.Administracao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class pnlDisciplinaConsulta extends JPanel {

	public static JTable tblDisciplina;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnDisciplina;

	/**
	 * Create the panel.
	 */
	public pnlDisciplinaConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		btnDisciplina = new JButton("Consultar");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnDisciplina.getText() == "Consultar") {
					try {
						int row = tblDisciplina.getSelectedRow();

						view.Administracao.pnlMateriaCadastro.LimparMateria();
						view.Administracao.pnlMateriaCadastro.txtCodigo
								.setText(String.valueOf(tblDisciplina.getValueAt(row, 0)));
						view.Administracao.pnlMateriaCadastro.txtNomeDisciplina
								.setText(String.valueOf(tblDisciplina.getValueAt(row, 1)));
						view.Administracao.pnlMateriaCadastro.cbSerieMateria
								.setSelectedItem(tblDisciplina.getValueAt(row, 2));
						// combo não vai
						view.Administracao.pnlMateriaCadastro.cbCursoMateria
								.setSelectedItem(tblDisciplina.getValueAt(row, 3));
						view.Administracao.frmAdministracao.painelAtivo("pnlMateriaCadastro");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione uma disciplina");
					}

				} else {
					int row = tblDisciplina.getSelectedRow();
					control.DisciplinaControl.RecuperarDisciplina((int) tblDisciplina.getValueAt(row, 0));
					control.DisciplinaControl.ConsultarDisciplinaExcluido();
				}
			}
		});
		btnDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnDisciplina.setBounds(1102, 589, 161, 55);
		add(btnDisciplina);

		tblDisciplina = new JTable();
		tblDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblDisciplina);
		scrollPane.setBounds(81, 121, 1182, 451);
		add(scrollPane);

		JLabel lblConsultaDeDisciplina = new JLabel("Consulta de Disciplina");
		lblConsultaDeDisciplina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeDisciplina.setBounds(566, 11, 347, 62);
		add(lblConsultaDeDisciplina);

		JRadioButton radioButton = new JRadioButton("Ativo");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDisciplina.setText("Consultar");
				control.DisciplinaControl.ConsultarDisciplina();
			}
		});
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(81, 91, 109, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Inativo");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDisciplina.setText("Recuperar");
				control.DisciplinaControl.ConsultarDisciplinaExcluido();
			}
		});
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(197, 91, 139, 23);
		add(radioButton_1);

	}

}

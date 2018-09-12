package view.Administracao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class pnlTurmaConsulta extends JPanel {

	public static JTable tblTurma;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public pnlTurmaConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnConsultar.getText() == "Consultar") {

					try {
						int row = tblTurma.getSelectedRow();
						int codigo = (int) tblTurma.getValueAt(row, 0);

						view.Administracao.frmAdministracao.painelAtivo("pnlTurmaCadastro");
						view.Administracao.pnlTurmaCadastro.txtCodigo.setText(String.valueOf(codigo));
						view.Administracao.pnlTurmaCadastro.cbCursoTurma.setSelectedItem(tblTurma.getValueAt(row, 1));
						view.Administracao.pnlTurmaCadastro.cbSerieTurma.setSelectedItem(tblTurma.getValueAt(row, 2));
						view.Administracao.pnlTurmaCadastro.cbPeriodoTurma.setSelectedItem(tblTurma.getValueAt(row, 3));
						view.Administracao.pnlTurmaCadastro.cbSiglaTurma
								.setSelectedItem(tblTurma.getValueAt(row, 5).toString().substring(4, 5));
						view.Administracao.pnlTurmaCadastro.txtNomeTurma
								.setText(String.valueOf(tblTurma.getValueAt(row, 5)));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione uma turma");
					}


				} else {
					
					try {
						int row = tblTurma.getSelectedRow();
						int codigo = (int) tblTurma.getValueAt(row, 0);
						control.TurmaControl.RecuperarTurma(codigo);
						control.TurmaControl.ConsultarTurmaExcluido();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione uma turma");
					}

					
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1104, 536, 161, 55);
		add(btnConsultar);

		tblTurma = new JTable();
		tblTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblTurma);
		scrollPane.setBounds(83, 130, 1182, 395);
		add(scrollPane);

		JLabel lblConsultaDeTurmas = new JLabel("Consulta de Turmas");
		lblConsultaDeTurmas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeTurmas.setBounds(576, 25, 236, 62);
		add(lblConsultaDeTurmas);

		JRadioButton radioButton = new JRadioButton("Ativo");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Consultar");
				control.TurmaControl.ConsultarTurma();
			}
		});
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(83, 100, 109, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Inativo");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Recuperar");
				control.TurmaControl.ConsultarTurmaExcluido();
			}
		});
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(199, 100, 139, 23);
		add(radioButton_1);

	}
}

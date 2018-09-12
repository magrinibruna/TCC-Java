package view.Administracao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class pnlCursoConsulta extends JPanel {

	public static JTable tblCurso;
	private JButton btnConsultar;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public pnlCursoConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		tblCurso = new JTable();
		tblCurso.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblCurso);
		scrollPane.setBounds(434, 110, 533, 477);
		add(scrollPane);

		JLabel lblConsultaDeCursos = new JLabel("Consulta de Cursos");
		lblConsultaDeCursos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeCursos.setBounds(570, 11, 347, 62);
		add(lblConsultaDeCursos);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnConsultar.getText() == "Consultar") {
					try {
						int row = tblCurso.getSelectedRow();

						view.Administracao.pnlCursoCadastro.LimparCurso();
						view.Administracao.pnlCursoCadastro.txtCodigo
								.setText((String.valueOf(tblCurso.getValueAt(row, 0))));
						view.Administracao.pnlCursoCadastro.txtNomeCurso
								.setText(String.valueOf(tblCurso.getValueAt(row, 1)));
						view.Administracao.pnlCursoCadastro.txtAbreviaturaCurso
								.setText(String.valueOf(tblCurso.getValueAt(row, 2)));
						view.Administracao.frmAdministracao.painelAtivo("pnlCursoCadastro");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione um curso");
					}
				} else {
					try {
						int row = tblCurso.getSelectedRow();
						control.CursoControl.RecuperarCurso((int) tblCurso.getValueAt(row, 0));
						control.CursoControl.ConsultarCursoExcluido();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Selecione um curso");
					}
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(806, 598, 161, 55);
		add(btnConsultar);

		JRadioButton radioButton = new JRadioButton("Ativo");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Consultar");
				control.CursoControl.ConsultarCurso();
			}
		});
		buttonGroup.add(radioButton);
		radioButton.setSelected(true);
		radioButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(434, 80, 109, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Inativo");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Recuperar");
				control.CursoControl.ConsultarCursoExcluido();
			}
		});
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(550, 80, 139, 23);
		add(radioButton_1);

	}

}

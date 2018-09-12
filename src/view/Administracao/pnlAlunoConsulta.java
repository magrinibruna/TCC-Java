package view.Administracao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class pnlAlunoConsulta extends JPanel {

	public static JTable tableAluno;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public pnlAlunoConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblConsultaDeAlunos = new JLabel("Consulta de Alunos");
		lblConsultaDeAlunos.setBounds(605, 0, 236, 62);
		lblConsultaDeAlunos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		add(lblConsultaDeAlunos);

		tableAluno = new JTable();
		tableAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tableAluno);
		scrollPane.setBounds(79, 135, 1182, 427);
		add(scrollPane);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnConsultar.getText() == "Consultar") {

					try {

						int row = tableAluno.getSelectedRow();
						int rmTabela = (int) tableAluno.getValueAt(row, 0);

						view.Administracao.frmAdministracao.painelAtivo("pnlAlunoCadastro");
						view.Administracao.pnlAlunoCadastro.ConsultarAluno(rmTabela);
						view.Administracao.pnlAlunoCadastro.txtRMAluno.setText(String.valueOf(rmTabela));

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Selecione umx alunx");
					}
				} else {

					try {
						
						int row = tableAluno.getSelectedRow();
						int rmTabela = (int) tableAluno.getValueAt(row, 0);
						
						control.AlunoControl.AlterarEstadoAluno(rmTabela, 1);
						control.AlunoControl.ConsultaAlunosExcluido();
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Selecione umx alunx");
					}
					
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1100, 573, 161, 55);
		add(btnConsultar);

		JRadioButton radioButton = new JRadioButton("Inativo");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Recuperar");
				control.AlunoControl.ConsultaAlunosExcluido();
			}
		});
		buttonGroup.add(radioButton);
		radioButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(195, 101, 139, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Ativo");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Consultar");
				control.AlunoControl.ConsultaAlunos();
			}
		});
		buttonGroup.add(radioButton_1);
		radioButton_1.setSelected(true);
		radioButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(79, 101, 109, 23);
		add(radioButton_1);

	}
}

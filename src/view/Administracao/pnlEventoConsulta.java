package view.Administracao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class pnlEventoConsulta extends JPanel {

	public static JTable tblEvento;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public pnlEventoConsulta() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("Consulta de Eventos");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label.setBounds(587, 11, 236, 62);
		add(label);

		tblEvento = new JTable();
		tblEvento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblEvento);
		scrollPane.setBounds(50, 126, 1182, 446);
		add(scrollPane);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnConsultar.getText() == "Consultar") {
					try {

						int row = tblEvento.getSelectedRow();

						view.Administracao.pnlEventoCadastro.LimparEvento();
						view.Administracao.pnlEventoCadastro.txtCodigo
								.setText(String.valueOf(tblEvento.getValueAt(row, 0)));
						view.Administracao.pnlEventoCadastro.txtTituloEvento
								.setText(String.valueOf(tblEvento.getValueAt(row, 1)));
						view.Administracao.pnlEventoCadastro.txtDescricaoEvento
								.setText(String.valueOf(tblEvento.getValueAt(row, 2)));
						view.Administracao.pnlEventoCadastro.txtData
								.setText(String.valueOf(tblEvento.getValueAt(row, 3)));
						view.Administracao.frmAdministracao.painelAtivo("pnlEventoCadastro");

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Selecione um evento");
					}
				} else {

					try {
						
						int row = tblEvento.getSelectedRow();
						int codigo = (int) tblEvento.getValueAt(row, 0);
						
						control.EventoControl.RecuperarEvento(codigo);
						control.EventoControl.ConsultarEventoExcluido("administrador");
						
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "Selecione um evento");
					}
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1097, 584, 147, 55);
		add(btnConsultar);

		JRadioButton rdbtnInativo = new JRadioButton("Inativo");
		buttonGroup.add(rdbtnInativo);
		rdbtnInativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Recuperar");
				control.EventoControl.ConsultarEventoExcluido("administrador");
			}
		});
		rdbtnInativo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnInativo.setBackground(Color.WHITE);
		rdbtnInativo.setBounds(166, 96, 139, 23);
		add(rdbtnInativo);

		JRadioButton rdbtnAtivo = new JRadioButton("Ativo");
		rdbtnAtivo.setSelected(true);
		buttonGroup.add(rdbtnAtivo);
		rdbtnAtivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setText("Consultar");
				control.EventoControl.ConsultarEvento("administrador");
			}
		});
		rdbtnAtivo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		rdbtnAtivo.setBackground(Color.WHITE);
		rdbtnAtivo.setBounds(50, 96, 109, 23);
		add(rdbtnAtivo);

	}
}

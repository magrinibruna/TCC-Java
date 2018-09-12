package view.Aluno;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlEvento extends JPanel {
	
	public static JTable tblEvento;
	MaskFormatter data;
	public static JFormattedTextField txtData;
	private static JTextField txtTitulo;
	private static JTextArea txtDescricao;

	/**
	 * Create the panel.
	 */
	public pnlEvento() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		try {

			data = new MaskFormatter("##/##/####");
			data.setValidCharacters("0123456789");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		tblEvento = new JTable();
		tblEvento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblEvento);
		scrollPane.setBounds(64, 115, 774, 459);
		add(scrollPane);
		
		JLabel lblConsultaDeEventos = new JLabel("Consulta de Eventos");
		lblConsultaDeEventos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeEventos.setBounds(590, 11, 236, 62);
		add(lblConsultaDeEventos);
		
		txtDescricao = new JTextArea();
		txtDescricao.setEditable(false);
		txtDescricao.setRows(6);
		txtDescricao.setLineWrap(true);
		txtDescricao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(Color.LIGHT_GRAY);
		txtDescricao.setBounds(883, 350, 390, 181);
		add(txtDescricao);
		
		txtTitulo = new JTextField();
		txtTitulo.setEditable(false);
		txtTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(883, 267, 390, 36);
		add(txtTitulo);
		
		JLabel label = new JLabel("Descri\u00E7\u00E3o");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(881, 308, 139, 40);
		add(label);
		
		JLabel label_1 = new JLabel("Titulo");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_1.setBounds(883, 238, 61, 18);
		add(label_1);
		
		txtData = new JFormattedTextField((AbstractFormatter) data);
		txtData.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtData.setColumns(10);
		txtData.setBounds(883, 191, 156, 36);
		add(txtData);
		
		JLabel label_2 = new JLabel("Data do Evento");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_2.setBounds(881, 149, 198, 28);
		add(label_2);
		
		JButton btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				int row = tblEvento.getSelectedRow();
				
				txtTitulo.setText(String.valueOf(tblEvento.getValueAt(row, 1)));
				txtDescricao.setText(String.valueOf(tblEvento.getValueAt(row, 2)));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Selecione uma mensagem");
				}
			}
		});
		btnConsulta.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsulta.setBounds(691, 584, 147, 55);
		add(btnConsulta);
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		lblEventos.setBounds(1041, 76, 100, 62);
		add(lblEventos);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(1126, 542, 147, 55);
		add(btnLimpar);

	}
	
	public static void Limpar() {
		txtTitulo.setText("");
		txtDescricao.setText("");
	}

}

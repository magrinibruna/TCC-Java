package view.Professor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class pnlEvento extends JPanel {
	
	public static JTable tblEvento;
	private static JTextField txtTitulo;
	private static JTextArea txtDescricao;
	MaskFormatter data;

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
		
		JLabel label = new JLabel("Consulta de Eventos");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label.setBounds(570, 11, 236, 62);
		add(label);
		
		tblEvento = new JTable();
		tblEvento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblEvento);
		scrollPane.setBounds(47, 96, 792, 488);
		add(scrollPane);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(1128, 550, 147, 55);
		add(btnLimpar);
		
		
		
		txtDescricao = new JTextArea();
		txtDescricao.setRows(6);
		txtDescricao.setLineWrap(true);
		txtDescricao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtDescricao.setEditable(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBackground(Color.LIGHT_GRAY);
		txtDescricao.setBounds(885, 358, 390, 181);
		add(txtDescricao);
		
		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_1.setBounds(883, 316, 139, 40);
		add(label_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtTitulo.setEditable(false);
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(885, 275, 390, 36);
		add(txtTitulo);
		
		JLabel label_2 = new JLabel("Titulo");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_2.setBounds(885, 246, 61, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("Data do Evento");
		label_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_3.setBounds(883, 157, 198, 28);
		add(label_3);
		
		JLabel label_4 = new JLabel("Eventos");
		label_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		label_4.setBounds(1043, 84, 100, 62);
		add(label_4);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
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
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(693, 592, 147, 55);
		add(btnConsultar);
		
		JFormattedTextField txtData = new JFormattedTextField((AbstractFormatter) data);
		txtData.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtData.setColumns(10);
		txtData.setBounds(885, 196, 156, 36);
		add(txtData);

	}
	
	public static void Limpar() {
		txtTitulo.setText("");
		txtDescricao.setText("");
	}
}

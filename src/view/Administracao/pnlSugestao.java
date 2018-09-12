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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class pnlSugestao extends JPanel {

	public static JTable tblSugestao;
	private static JTextArea txtSugestao;
	private static JTextField txtRemetente;
	
	/**
	 * Create the panel.
	 */
	public pnlSugestao() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		tblSugestao = new JTable();
		tblSugestao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		JScrollPane scrollPane = new JScrollPane(tblSugestao);
		scrollPane.setBounds(79, 146, 632, 488);
		add(scrollPane);
		
		JLabel lblConsultaDeSugestes = new JLabel("Consulta de Sugest\u00F5es");
		lblConsultaDeSugestes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultaDeSugestes.setBounds(564, 11, 347, 62);
		add(lblConsultaDeSugestes);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Limpar();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(890, 579, 161, 55);
		add(btnLimpar);
		
		txtSugestao = new JTextArea();
		txtSugestao.setEditable(false);
		txtSugestao.setRows(10);
		txtSugestao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtSugestao.setBounds(816, 290, 301, 263);
		add(txtSugestao);
		
		JLabel label = new JLabel("Sugest\u00E3o");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label.setBounds(900, 99, 161, 40);
		add(label);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int row = tblSugestao.getSelectedRow();
					txtRemetente.setText((String) tblSugestao.getValueAt(row, 1));
					txtSugestao.setText((String) tblSugestao.getValueAt(row, 3));
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,"Selecione uma sugestão");
				}
				
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(79, 78, 161, 55);
		add(btnConsultar);
		
		txtRemetente = new JTextField();
		txtRemetente.setEditable(false);
		txtRemetente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtRemetente.setColumns(10);
		txtRemetente.setBounds(815, 200, 246, 35);
		add(txtRemetente);
		
		JLabel lblRemetente = new JLabel("Remetente:");
		lblRemetente.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblRemetente.setBounds(814, 157, 161, 40);
		add(lblRemetente);
		
		JLabel lblMensagem = new JLabel("Mensagem:");
		lblMensagem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblMensagem.setBounds(813, 249, 161, 40);
		add(lblMensagem);

	}
	
	public static void Limpar() {
		txtSugestao.setText("");
		txtRemetente.setText("");
	}
}

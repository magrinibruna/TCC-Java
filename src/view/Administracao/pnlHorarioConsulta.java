package view.Administracao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.Turma;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlHorarioConsulta extends JPanel {
	
	//na hora de consultar, validar pela turma e pelo ai
	String foto = "";
	private static int validacaoTurma = 0;
	private JComboBox<Turma> cbTurma;

	/**
	 * Create the panel.
	 */
	public pnlHorarioConsulta() {
		
		cbTurma = new JComboBox<Turma>();
		control.TurmaControl.carregarComboTurma(cbTurma);
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblFoto = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/horarios.jpg")).getImage();
		lblFoto.setIcon(new ImageIcon(img1));
		lblFoto.setBounds(89, 130, 1189, 397);
		add(lblFoto);
		
		JLabel lblConsultadeHorrios = new JLabel("Consulta de Hor\u00E1rios");
		lblConsultadeHorrios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblConsultadeHorrios.setBounds(563, 31, 319, 40);
		add(lblConsultadeHorrios);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Validacao()) {
					//pode pesquisar
				} 
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(1116, 548, 160, 61);
		add(btnConsultar);
		
		//cbTurma = new JComboBox<Turma>();
		cbTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validacaoTurma = 1;
				
			}
		});
		cbTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbTurma.setBounds(93, 84, 187, 35);
		add(cbTurma);
		
		JLabel label_2 = new JLabel("Turma");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_2.setBounds(89, 58, 131, 23);
		add(label_2);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Validacao()) {
					//pode pesquisar
				} 
			}
		});
		btnPesquisar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnPesquisar.setBounds(938, 548, 160, 61);
		add(btnPesquisar);

	}

	public static boolean Validacao() {
		if(validacaoTurma == 1) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma turma");
			return false;
		}
	}
}

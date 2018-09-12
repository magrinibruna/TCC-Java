package view.Aluno;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class pnlPaginaInicial extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlPaginaInicial() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblBemvindoAlunx = new JLabel("Bem-vindo, alunx!");
		lblBemvindoAlunx.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblBemvindoAlunx.setBounds(20, 95, 351, 47);
		add(lblBemvindoAlunx);
		
		JLabel label_1 = new JLabel("P\u00E1gina Inicial");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label_1.setBounds(601, 11, 319, 40);
		add(label_1);

	}
}

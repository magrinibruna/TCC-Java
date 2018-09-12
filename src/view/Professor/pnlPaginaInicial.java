package view.Professor;

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
		
		JLabel label = new JLabel("P\u00E1gina Inicial");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label.setBounds(629, 11, 319, 40);
		add(label);
		
		JLabel lblBemvindoProfessxrx = new JLabel("Bem-vindo, professxrx!");
		lblBemvindoProfessxrx.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblBemvindoProfessxrx.setBounds(48, 95, 351, 47);
		add(lblBemvindoProfessxrx);

	}
}

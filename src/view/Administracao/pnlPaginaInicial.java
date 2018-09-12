package view.Administracao;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;

public class pnlPaginaInicial extends JPanel {

	/**
	 * Create the panel.
	 */
	public pnlPaginaInicial() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblBemvindo = new JLabel("Bem-vindo, administradxrx!");
		lblBemvindo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblBemvindo.setBounds(43, 95, 351, 47);
		add(lblBemvindo);
		
		JLabel lblPgina = new JLabel("P\u00E1gina Inicial");
		lblPgina.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblPgina.setBounds(624, 11, 319, 40);
		add(lblPgina);
		Image img1 = new ImageIcon(this.getClass().getResource("/fundo3.jpg")).getImage();
	

	}
}

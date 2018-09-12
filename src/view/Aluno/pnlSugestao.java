package view.Aluno;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;
import java.awt.Color;


public class pnlSugestao extends JPanel {
	public static int IDUsuario;
	
	MaskFormatter nascimento;
	private JTextArea txtMensagemSugestao;

	/**
	 * Create the panel.
	 */
	public pnlSugestao() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		try {
		
			nascimento = new MaskFormatter("##/##/####");
			nascimento.setValidCharacters("0123456789");

			
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ValidarSugestao() == 1) {
					
					Date data = new Date(System.currentTimeMillis());
					SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
					System.out.println(formatarDate.format(data));
					
				control.SugestaoControl.CadastrarSugestao(
						IDUsuario, 		
						//new Date(System.currentTimeMillis()),
						txtMensagemSugestao.getText());
					
				LimparSugestao();
				
				}
				
			}
		});
		btnGravar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravar.setBounds(472, 420, 161, 55);
		add(btnGravar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparSugestao();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(656, 420, 161, 55);
		add(btnLimpar);
		
		txtMensagemSugestao = new JTextArea();
		txtMensagemSugestao.setBackground(Color.LIGHT_GRAY);
		txtMensagemSugestao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtMensagemSugestao.setRows(10);
		txtMensagemSugestao.setBounds(488, 131, 301, 263);
		txtMensagemSugestao.setLineWrap(true);
		add(txtMensagemSugestao);
		
		JLabel lblSugesto_1 = new JLabel("Sugest\u00E3o");
		lblSugesto_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblSugesto_1.setBounds(578, 11, 161, 40);
		add(lblSugesto_1);
		
		JLabel lblDigiteSuaSugesto = new JLabel("Digite sua sugest\u00E3o:");
		lblDigiteSuaSugesto.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblDigiteSuaSugesto.setBounds(542, 85, 224, 35);
		add(lblDigiteSuaSugesto);

	}
	
	public int ValidarSugestao() {
		int resultado = 0;
		
		if(txtMensagemSugestao.getRows() != 0) {
			resultado = 1;
		}
		
		return resultado;
	}
	
	public void LimparSugestao() {
		txtMensagemSugestao.setText("");
	}
}

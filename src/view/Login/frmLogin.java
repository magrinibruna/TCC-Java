package view.Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	public static JTextField txtUsuario;
	public static JPasswordField txtSenha;
	public static JLabel lblLogin;
	public static JButton btnEntrar;
	public static JLabel lblSenha;
	private JLabel lblLogo;
	private JLabel lblFundo;
	private JLabel lblPortalDoAluno;

	public static int AlterarSenha = 0;
	private JLabel lblRanking;
	private JLabel lblTurma;
	private JLabel lblNota;
	
	public static JLabel lblRanking1;
	public static JLabel lblRanking2;
	public static JLabel lblRanking3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void abreForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		
		
		
		setTitle("Portal do Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRanking = new JLabel("Melhores Turmas");
		lblRanking.setForeground(Color.WHITE);
		lblRanking.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		lblRanking.setBounds(1052, 460, 252, 45);
		contentPane.add(lblRanking);
		
		JLabel lblTrimestre = new JLabel("Trimestre");
		lblTrimestre.setForeground(Color.WHITE);
		lblTrimestre.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		lblTrimestre.setBounds(1034, 516, 110, 31);
		contentPane.add(lblTrimestre);
		
		lblTurma = new JLabel("Turma");
		lblTurma.setForeground(Color.WHITE);
		lblTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		lblTurma.setBounds(1161, 516, 84, 31);
		contentPane.add(lblTurma);

		lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 32));
		lblLogin.setBounds(779, 170, 177, 45);
		contentPane.add(lblLogin);

		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Logar();

			}
		});
		
		lblNota = new JLabel("Nota");
		lblNota.setForeground(Color.WHITE);
		lblNota.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		lblNota.setBounds(1255, 516, 84, 31);
		contentPane.add(lblNota);
		btnEntrar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		btnEntrar.setBounds(730, 426, 196, 51);
		contentPane.add(btnEntrar);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtUsuario.setBounds(681, 269, 288, 45);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logar();
			}
		});

		txtSenha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtSenha.setColumns(10);
		txtSenha.setBounds(681, 359, 288, 45);
		contentPane.add(txtSenha);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		lblUsurio.setBounds(679, 236, 135, 31);
		contentPane.add(lblUsurio);

		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Berlin Sans FB", Font.PLAIN, 27));
		lblSenha.setBounds(681, 325, 148, 31);
		contentPane.add(lblSenha);

		lblLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.jpg")).getImage();

		lblPortalDoAluno = new JLabel("Portal do Aluno");
		lblPortalDoAluno.setBackground(Color.WHITE);
		lblPortalDoAluno.setForeground(Color.WHITE);
		lblPortalDoAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 74));
		lblPortalDoAluno.setBounds(441, 39, 594, 68);
		contentPane.add(lblPortalDoAluno);
		
		lblRanking1 = new JLabel("");
		lblRanking1.setForeground(Color.WHITE);
		lblRanking1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblRanking1.setBounds(979, 558, 344, 31);
		contentPane.add(lblRanking1);
		
		lblRanking2 = new JLabel("");
		lblRanking2.setForeground(Color.WHITE);
		lblRanking2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblRanking2.setBounds(979, 600, 344, 31);
		contentPane.add(lblRanking2);
		
		lblRanking3 = new JLabel("");
		lblRanking3.setForeground(Color.WHITE);
		lblRanking3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblRanking3.setBounds(979, 641, 344, 31);
		contentPane.add(lblRanking3);
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 145, 525, 473);
		contentPane.add(lblLogo);
		
		control.RankingControl.listarRanking();

		lblFundo = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/fundo3.jpg")).getImage();
		lblFundo.setIcon(new ImageIcon(img1));
		lblFundo.setBounds(0, 0, 1368, 701);
		contentPane.add(lblFundo);

	}

	public void keyPressed(KeyEvent evt) {
		// abaixo é só mudar o ENTER para o código que da tecla que vc deseja...
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			Logar();
		}
	}

	public static void Alterar() {
		AlterarSenha = 1;
	}

	public static void Professor() {
		AlterarSenha = 2;
	}

	public static void Aluno() {
		AlterarSenha = 3;
	}

	public static void Administrador() {
		AlterarSenha = 4;
	}

	public void Logar() {

		/* Case any textbox be empty, it's necessary to fill it, else, to login */
		if ((txtUsuario.getText().trim().length() == 0)
				|| (String.valueOf(txtSenha.getPassword()).trim().length() == 0)) {

			JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto :[");
			txtUsuario.requestFocus();
		}

		else {
			control.LoginControl.Logar(txtUsuario.getText());

			if (AlterarSenha == 1) {

			} else if (AlterarSenha == 2) {
				dispose();
			} else if (AlterarSenha == 3) {
				dispose();
			} else if (AlterarSenha == 4) {
				dispose();
			}

			AlterarSenha = 0;

		}

	}
}

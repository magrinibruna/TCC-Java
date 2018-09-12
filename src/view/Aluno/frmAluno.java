package view.Aluno;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frmAluno extends JFrame {

	private static JPanel contentPane;
	
	public static int rm = 0;
	
	pnlPaginaInicial objpnlPaginaInicial = new pnlPaginaInicial();
	pnlSugestao objpnlSugestao = new pnlSugestao();
	pnlEvento objpnlEvento = new pnlEvento();
	pnlMensagem objpnlMensagem = new pnlMensagem();
	pnlNota objpnlNota = new pnlNota();
	pnlHorario objpnlHorario = new pnlHorario();

	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAluno frame = new frmAluno();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public static void abrirForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAluno frame = new frmAluno();
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
	public frmAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1334, 731);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 153));
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Inicial");
		menu.setForeground(Color.WHITE);
		menu.setBackground(new Color(0, 0, 153));
		menu.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("P\u00E1gina Inicial");
		menuItem.setBackground(new Color(0, 0, 153));
		menuItem.setForeground(Color.WHITE);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				painelAtivo("pp");
				
			}
		});
		menuItem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Sair");
		menuItem_1.setBackground(new Color(0, 0, 153));
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new view.Login.frmLogin().abreForm();
				dispose();
				
			}
		});
		menuItem_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("Notas");
		menu_1.setForeground(Color.WHITE);
		menu_1.setBackground(new Color(0, 0, 153));
		menu_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(menu_1);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mntmVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlNota");
				System.out.println(rm);
				control.ProcNotaControl.ConsultarNota(rm, 3);
				
			}
		});
		mntmVisualizar.setForeground(Color.WHITE);
		mntmVisualizar.setBackground(new Color(0, 0, 153));
		mntmVisualizar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menu_1.add(mntmVisualizar);
		
		JMenu menu_2 = new JMenu("Horar\u00EDos");
		menu_2.setForeground(Color.WHITE);
		menu_2.setBackground(new Color(0, 0, 153));
		menu_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("Visualizar");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlHorario");
				
			}
		});
		menuItem_2.setBackground(new Color(0, 0, 153));
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menu_2.add(menuItem_2);
		
		JMenu menu_3 = new JMenu("Eventos");
		menu_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menu_3.setForeground(Color.WHITE);
		menu_3.setBackground(new Color(0, 0, 153));
		menu_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_3 = new JMenuItem("Visualizar");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlEvento");
				control.EventoControl.ConsultarEvento("aluno");
				view.Aluno.pnlEvento.Limpar();
				
			}
		});
		menuItem_3.setForeground(Color.WHITE);
		menuItem_3.setBackground(new Color(0, 0, 153));
		menuItem_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menu_3.add(menuItem_3);
		
		JMenu menu_4 = new JMenu("Mensagens");
		menu_4.setForeground(Color.WHITE);
		menu_4.setBackground(new Color(0, 0, 153));
		menu_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(menu_4);
		
		JMenuItem menuItem_4 = new JMenuItem("Visualizar");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlMensagem");
				control.ProcMensagemControl.ConsultarMensagemAluno(rm);
			}
		});
		menuItem_4.setBackground(new Color(0, 0, 153));
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menu_4.add(menuItem_4);
		
		JMenu menu_5 = new JMenu("Sugest\u00F5es");
		menu_5.setForeground(Color.WHITE);
		menu_5.setBackground(new Color(0, 0, 153));
		menu_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(menu_5);
		
		JMenuItem menuItem_5 = new JMenuItem("Visualizar");
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setBackground(new Color(0, 0, 153));
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				painelAtivo("pnlSugestao");
				
			}
		});
		menuItem_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menu_5.add(menuItem_5);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		objpnlPaginaInicial.setBackground(Color.WHITE);
		
		contentPane.add(objpnlPaginaInicial, "pp");
		contentPane.add(objpnlEvento, "pnlEvento");
		contentPane.add(objpnlSugestao, "pnlSugestao");
		contentPane.add(objpnlMensagem, "pnlMensagem");
		contentPane.add(objpnlNota, "pnlNota");
		contentPane.add(objpnlHorario, "pnlHorario");
	
		
		
	}
	
	public static void painelAtivo(String painel) {
	    CardLayout cl = (CardLayout)(contentPane.getLayout());
	    cl.show(contentPane, painel);
	}
}

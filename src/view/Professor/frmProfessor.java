package view.Professor;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class frmProfessor extends JFrame {

	private static JPanel contentPane;

	pnlPaginaInicial objpnlPaginaInicial = new pnlPaginaInicial();
	pnlNota objpnlNota = new pnlNota();
	pnlNotaConsulta objpnlNotaConsulta = new pnlNotaConsulta();
	pnlMensagem objpnlMensagem = new pnlMensagem();
	pnlEvento objpnlEvento = new pnlEvento();
	pnlHorario objpnlHorario = new pnlHorario();

	public static int codigoProfessor = 0;

	/**
	 * Launch the application.
	 */

	public static void abreForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmProfessor frame = new frmProfessor();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { frmProfessor frame = new
	 * frmProfessor(); frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public frmProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1337, 732);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 153));
		setJMenuBar(menuBar);

		JMenu mnInicial = new JMenu("Inicial");
		mnInicial.setForeground(Color.WHITE);
		mnInicial.setBackground(new Color(0, 0, 153));
		mnInicial.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnInicial);

		JMenuItem menuItem_1 = new JMenuItem("P\u00E1gina Inicial");
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setBackground(new Color(0, 0, 153));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				painelAtivo("pp");

			}
		});
		menuItem_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnInicial.add(menuItem_1);

		JMenuItem menuItem = new JMenuItem("Sair");
		menuItem.setForeground(Color.WHITE);
		menuItem.setBackground(new Color(0, 0, 153));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new view.Login.frmLogin().abreForm();
				dispose();

			}
		});
		menuItem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnInicial.add(menuItem);

		JMenu mnNotas = new JMenu("Notas");
		mnNotas.setForeground(Color.WHITE);
		mnNotas.setBackground(new Color(0, 0, 153));
		mnNotas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnNotas);

		JMenuItem mntmCadastros = new JMenuItem("Cadastros");
		mntmCadastros.setForeground(Color.WHITE);
		mntmCadastros.setBackground(new Color(0, 0, 153));
		mntmCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				painelAtivo("pnlNota");
				control.NotaControl.carregarComboDisciplinaNota(view.Professor.pnlNota.cbDisciplina, codigoProfessor);
				control.ProfessorControl.BuscarProfessorCodigo(codigoProfessor, "nota");
				// control.vwQuantidadeAlunosControl.QuantidadeAlunos(1);
				view.Professor.pnlNota.Inicializar();
				

			}
		});
		mntmCadastros.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnNotas.add(mntmCadastros);

		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mntmConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlNotaConsulta");
				control.ProfessorControl.BuscarProfessorCodigo(codigoProfessor, "nota2");
				control.NotaControl.carregarComboDisciplinaNota(view.Professor.pnlNotaConsulta.cbDisciplina,
						codigoProfessor);
				view.Professor.pnlNotaConsulta.codigoProfessor = codigoProfessor;
				
			}
		});
		mntmConsultas.setForeground(Color.WHITE);
		mntmConsultas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mntmConsultas.setBackground(new Color(0, 0, 153));
		mnNotas.add(mntmConsultas);

		JMenu mnHoraros = new JMenu("Horar\u00EDos");
		mnHoraros.setForeground(Color.WHITE);
		mnHoraros.setBackground(new Color(0, 0, 153));
		mnHoraros.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnHoraros);

		JMenuItem mntmVisualizar_2 = new JMenuItem("Visualizar");
		mntmVisualizar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlHorario");
			}
		});
		mntmVisualizar_2.setForeground(Color.WHITE);
		mntmVisualizar_2.setBackground(new Color(0, 0, 153));
		mntmVisualizar_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnHoraros.add(mntmVisualizar_2);

		JMenu mnEventos = new JMenu("Eventos");
		mnEventos.setForeground(Color.WHITE);
		mnEventos.setBackground(new Color(0, 0, 153));
		mnEventos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnEventos);

		JMenuItem mntmVisualizar_3 = new JMenuItem("Visualizar");
		mntmVisualizar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlEvento");
				control.EventoControl.ConsultarEvento("professor");
				view.Professor.pnlEvento.Limpar();
			}
		});
		mntmVisualizar_3.setForeground(Color.WHITE);
		mntmVisualizar_3.setBackground(new Color(0, 0, 153));
		mntmVisualizar_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnEventos.add(mntmVisualizar_3);

		JMenu mnMensagens = new JMenu("Mensagens");
		mnMensagens.setForeground(Color.WHITE);
		mnMensagens.setBackground(new Color(0, 0, 153));
		mnMensagens.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnMensagens);

		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mntmVisualizar.setForeground(Color.WHITE);
		mntmVisualizar.setBackground(new Color(0, 0, 153));
		mntmVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				painelAtivo("pnlMensagem");
				view.Professor.pnlMensagem.rdbtnAluno.setSelected(true);
				control.ProcMensagemControl.ConsultarMensagemProfessor(codigoProfessor);

			}
		});
		mntmVisualizar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnMensagens.add(mntmVisualizar);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		objpnlPaginaInicial.setBackground(Color.WHITE);

		contentPane.add(objpnlPaginaInicial, "pp");
		contentPane.add(objpnlNota, "pnlNota");
		contentPane.add(objpnlNotaConsulta, "pnlNotaConsulta");
		contentPane.add(objpnlMensagem, "pnlMensagem");
		contentPane.add(objpnlEvento, "pnlEvento");
		contentPane.add(objpnlHorario, "pnlHorario");

	}

	public static void painelAtivo(String painel) {
		CardLayout cl = (CardLayout) (contentPane.getLayout());
		cl.show(contentPane, painel);
	}

}

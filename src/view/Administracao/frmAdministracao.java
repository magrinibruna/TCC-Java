package view.Administracao;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Curso;
import model.Disciplina;
import model.Turma;
import view.Professor.pnlNota;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class frmAdministracao extends JFrame {

	private static JPanel contentPane;
	pnlPaginaInicial objpnlPaginaInicial = new pnlPaginaInicial();
	pnlAlunoCadastro objpnlAlunoCadastro = new pnlAlunoCadastro();
	pnlAlunoConsulta objpnlAlunoConsulta = new pnlAlunoConsulta();
	pnlCursoCadastro objpnlCursoCadastro = new pnlCursoCadastro();
	pnlCursoConsulta objpnlCursoConsulta = new pnlCursoConsulta();
	pnlTurmaCadastro objpnlTurmaCadastro = new pnlTurmaCadastro();
	pnlTurmaConsulta objpnlTurmaConsulta = new pnlTurmaConsulta();
	pnlProfessorCadastro objpnlProfessorCadastro = new pnlProfessorCadastro();
	pnlProfessorConsulta objpnlProfessorConsulta = new pnlProfessorConsulta();
	pnlMateriaCadastro objpnlMateriaCadastro = new pnlMateriaCadastro();
	pnlDisciplinaConsulta objpnlDisciplinaConsulta = new pnlDisciplinaConsulta();
	pnlEventoCadastro objpnlEventoCadastro = new pnlEventoCadastro();
	pnlEventoConsulta objpnlEventoConsulta = new pnlEventoConsulta();
	pnlSugestao objpnlSugestao = new pnlSugestao();
	pnlRelacionamento objpnlRelacionamento = new pnlRelacionamento();
	pnlAtribuicaoConsulta objpnlAtribuicaoConsulta = new pnlAtribuicaoConsulta();
	view.Administracao.pnlNota objpnlNota = new view.Administracao.pnlNota();
	pnlHorario objpnlHorarioCadastro = new pnlHorario();
	pnlHorarioConsulta objpnlHorarioConsulta = new pnlHorarioConsulta();
	


	/**
	 * Launch the application.
	 */
	public static void abreForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAdministracao frame = new frmAdministracao();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 
	
	/* public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAdministracao frame = new frmAdministracao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	/**
	 * Create the frame.
	 */
	
	
	public frmAdministracao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1345, 740);
		

		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 139));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Inicial");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setBackground(new Color(0, 0, 255));
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		mnNewMenu.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPginaInicial = new JMenuItem("P\u00E1gina Inicial");
		mntmPginaInicial.setForeground(new Color(255, 255, 255));
		mntmPginaInicial.setBackground(new Color(0, 0, 139));
		mntmPginaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				painelAtivo("pp");
				
			}
		});
		mntmPginaInicial.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnNewMenu.add(mntmPginaInicial);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setForeground(new Color(255, 255, 255));
		mntmSair.setBackground(new Color(0, 0, 139));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new view.Login.frmLogin().abreForm();
				dispose();
	
			}
		});
		mntmSair.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnNewMenu.add(mntmSair);
		
		JMenu mnHorrios = new JMenu("Hor\u00E1rios");
		mnHorrios.setForeground(new Color(255, 255, 255));
		mnHorrios.setBackground(new Color(0, 0, 255));
		mnHorrios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnHorrios);
		
		JMenuItem menuItem = new JMenuItem("Cadastros");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlHorarioCadastro");
			}
		});
		menuItem.setForeground(new Color(255, 255, 255));
		menuItem.setBackground(new Color(0, 0, 139));
		menuItem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnHorrios.add(menuItem);
		
		JMenu mnEventos = new JMenu("Eventos");
		mnEventos.setForeground(new Color(255, 255, 255));
		mnEventos.setBackground(new Color(0, 0, 255));
		mnEventos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnEventos);
		
		JMenuItem menuItem_2 = new JMenuItem("Cadastros");
		menuItem_2.setForeground(new Color(255, 255, 255));
		menuItem_2.setBackground(new Color(0, 0, 139));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlEventoCadastro");
				objpnlEventoCadastro.LimparEvento();
			}
		});
		menuItem_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnEventos.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Consultas");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlEventoConsulta");
				control.EventoControl.ConsultarEvento("administrador");
				
			}
		});
		menuItem_3.setForeground(new Color(255, 255, 255));
		menuItem_3.setBackground(new Color(0, 0, 139));
		menuItem_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnEventos.add(menuItem_3);
		
		JMenu mnBoletim = new JMenu("Notas");
		mnBoletim.setForeground(Color.WHITE);
		mnBoletim.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		mnBoletim.setBackground(Color.BLUE);
		menuBar.add(mnBoletim);
		
		JMenuItem menuItem_8 = new JMenuItem("Visualizar");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlNota1");
			}
		});
		menuItem_8.setForeground(Color.WHITE);
		menuItem_8.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		menuItem_8.setBackground(new Color(0, 0, 139));
		mnBoletim.add(menuItem_8);
		
		JMenu mnSugestes = new JMenu("Sugest\u00F5es");
		mnSugestes.setForeground(new Color(255, 255, 255));
		mnSugestes.setBackground(new Color(0, 0, 255));
		mnSugestes.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnSugestes);
		
		JMenuItem mntmVisualizar = new JMenuItem("Visualizar");
		mntmVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlSugestao");
				control.SugestaoControl.ConsultarSugestao();
				view.Administracao.pnlSugestao.Limpar();
			}
		});
		mntmVisualizar.setBackground(new Color(0, 0, 139));
		mntmVisualizar.setForeground(new Color(255, 255, 255));
		mntmVisualizar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnSugestes.add(mntmVisualizar);
		
		JMenu mnAluno = new JMenu("Alunos");
		mnAluno.setForeground(new Color(255, 255, 255));
		mnAluno.setBackground(new Color(0, 0, 255));
		mnAluno.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnAluno);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastros");
		mntmCadastro.setForeground(new Color(255, 255, 255));
		mntmCadastro.setBackground(new Color(0, 0, 139));
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelAtivo("pnlAlunoCadastro");
				control.TurmaControl.carregarComboTurma(objpnlAlunoCadastro.cbTurmaAluno);
				objpnlAlunoCadastro.LimparAluno();
			}
		});
		mntmCadastro.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnAluno.add(mntmCadastro);
		
		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mntmConsultas.setForeground(new Color(255, 255, 255));
		mntmConsultas.setBackground(new Color(0, 0, 139));
		mntmConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelAtivo("pnlAlunoConsulta");
				control.AlunoControl.ConsultaAlunos();
			}
		});
		mntmConsultas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnAluno.add(mntmConsultas);
		
		JMenu mnProfessor = new JMenu("Professor");
		mnProfessor.setForeground(new Color(255, 255, 255));
		mnProfessor.setBackground(new Color(0, 0, 255));
		mnProfessor.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnProfessor);
		
		JMenuItem menuItem_4 = new JMenuItem("Cadastros");
		menuItem_4.setForeground(new Color(255, 255, 255));
		menuItem_4.setBackground(new Color(0, 0, 139));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlProfessorCadastro");
				objpnlProfessorCadastro.LimparProfessor();
			}
		});
		menuItem_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnProfessor.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Consultas");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlProfessorConsulta");
				control.ProfessorControl.ConsultaProfessor();
			}
		});
		menuItem_5.setForeground(new Color(255, 255, 255));
		menuItem_5.setBackground(new Color(0, 0, 139));
		menuItem_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnProfessor.add(menuItem_5);
		
		JMenu mnMatria = new JMenu("Disciplina");
		mnMatria.setForeground(new Color(255, 255, 255));
		mnMatria.setBackground(new Color(0, 0, 255));
		mnMatria.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnMatria);
		
		JMenuItem menuItem_6 = new JMenuItem("Cadastros");
		menuItem_6.setForeground(new Color(255, 255, 255));
		menuItem_6.setBackground(new Color(0, 0, 139));
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlMateriaCadastro");
				control.CursoControl.carregarComboCurso(objpnlMateriaCadastro.cbCursoMateria);
				objpnlMateriaCadastro.LimparMateria();
			}
		});
		menuItem_6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnMatria.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Consultas");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlDisciplinaConsulta");
				control.DisciplinaControl.ConsultarDisciplina();
				view.Administracao.pnlMateriaCadastro.LimparMateria();
				control.CursoControl.carregarComboCurso(objpnlMateriaCadastro.cbCursoMateria);
				
			}
		});
		menuItem_7.setForeground(new Color(255, 255, 255));
		menuItem_7.setBackground(new Color(0, 0, 139));
		menuItem_7.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnMatria.add(menuItem_7);
		
		JMenu mnCursos = new JMenu("Cursos");
		mnCursos.setForeground(new Color(255, 255, 255));
		mnCursos.setBackground(new Color(0, 0, 255));
		mnCursos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnCursos);
		
		JMenuItem menuItem_10 = new JMenuItem("Cadastros");
		menuItem_10.setForeground(new Color(255, 255, 255));
		menuItem_10.setBackground(new Color(0, 0, 139));
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelAtivo("pnlCursoCadastro");
				objpnlCursoCadastro.LimparCurso();		
			}
		});
		menuItem_10.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnCursos.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("Consultas");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlCursoConsulta");
				control.CursoControl.ConsultarCurso();
			}
		});
		menuItem_11.setForeground(new Color(255, 255, 255));
		menuItem_11.setBackground(new Color(0, 0, 139));
		menuItem_11.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnCursos.add(menuItem_11);
		
		JMenu mnTurmas = new JMenu("Turmas");
		mnTurmas.setForeground(new Color(255, 255, 255));
		mnTurmas.setBackground(new Color(0, 0, 255));
		mnTurmas.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnTurmas);
		
		JMenuItem menuItem_12 = new JMenuItem("Cadastros");
		menuItem_12.setForeground(new Color(255, 255, 255));
		menuItem_12.setBackground(new Color(0, 0, 139));
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlTurmaCadastro");
				control.CursoControl.carregarComboCurso(objpnlTurmaCadastro.cbCursoTurma);
				objpnlTurmaCadastro.LimparTurma();
			}
		});
		menuItem_12.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnTurmas.add(menuItem_12);
		
		JMenuItem menuItem_13 = new JMenuItem("Consultas");
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlTurmaConsulta");
				control.TurmaControl.ConsultarTurma();
			}
		});
		menuItem_13.setForeground(new Color(255, 255, 255));
		menuItem_13.setBackground(new Color(0, 0, 139));
		menuItem_13.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnTurmas.add(menuItem_13);
		
		JMenu mnRelacionamentos = new JMenu("Relacionamentos");
		mnRelacionamentos.setForeground(new Color(255, 255, 255));
		mnRelacionamentos.setBackground(new Color(0, 0, 255));
		mnRelacionamentos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		menuBar.add(mnRelacionamentos);
		
		JMenuItem menuItem_14 = new JMenuItem("Cadastros");
		menuItem_14.setForeground(new Color(255, 255, 255));
		menuItem_14.setBackground(new Color(0, 0, 139));
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				painelAtivo("pnlRelacionamento");
				
				control.DisciplinaControl.carregarComboDisciplina(objpnlRelacionamento.cbDisciplina);
				control.ProfessorControl.carregarComboProfessor(objpnlRelacionamento.cbProfessor);
				//control.TurmaControl.carregarComboTurma(objpnlRelacionamento.cbTurma);
				control.AtribuicaoControl.carregarComboAtribuicao(objpnlRelacionamento.cbAtribuicao);
			}
		});
		menuItem_14.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnRelacionamentos.add(menuItem_14);
		
		JMenuItem menuItem_15 = new JMenuItem("Consultas");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelAtivo("pnlAtribuicaoConsulta");
				control.AtribuicaoControl.ConsultarAtribuicao();
				control.AtribuicaoTurmaControl.ConsultarAtribuicaoTurma();
			}
		});
		menuItem_15.setForeground(new Color(255, 255, 255));
		menuItem_15.setBackground(new Color(0, 0, 139));
		menuItem_15.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		mnRelacionamentos.add(menuItem_15);
	
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 812, 475);
		objpnlPaginaInicial.add(panel);
		
		contentPane.add(objpnlPaginaInicial, "pp");
		contentPane.add(objpnlAlunoCadastro, "pnlAlunoCadastro");
		contentPane.add(objpnlAlunoConsulta, "pnlAlunoConsulta");
		contentPane.add(objpnlCursoCadastro, "pnlCursoCadastro");
		contentPane.add(objpnlCursoConsulta, "pnlCursoConsulta");
		contentPane.add(objpnlTurmaCadastro, "pnlTurmaCadastro");
		contentPane.add(objpnlTurmaConsulta, "pnlTurmaConsulta");
		contentPane.add(objpnlProfessorCadastro, "pnlProfessorCadastro");
		contentPane.add(objpnlProfessorConsulta, "pnlProfessorConsulta");
		contentPane.add(objpnlMateriaCadastro, "pnlMateriaCadastro");
		contentPane.add(objpnlDisciplinaConsulta, "pnlDisciplinaConsulta");
		contentPane.add(objpnlSugestao, "pnlSugestao");
		contentPane.add(objpnlEventoCadastro, "pnlEventoCadastro");
		contentPane.add(objpnlEventoConsulta, "pnlEventoConsulta");
		contentPane.add(objpnlRelacionamento, "pnlRelacionamento"); 
		contentPane.add(objpnlAtribuicaoConsulta, "pnlAtribuicaoConsulta");
		contentPane.add(objpnlNota, "pnlNota1");
		contentPane.add(objpnlHorarioCadastro,"pnlHorarioCadastro");
		contentPane.add(objpnlHorarioConsulta,"pnlHorarioConsulta");
	
		

	}
	
	public static void painelAtivo(String painel) {
	    CardLayout cl = (CardLayout)(contentPane.getLayout());
	    cl.show(contentPane, painel);
	}

}

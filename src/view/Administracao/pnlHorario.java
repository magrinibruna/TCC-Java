package view.Administracao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import model.Turma;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class pnlHorario extends JPanel {

	public static JLabel lblFoto;
	private JComboBox<Turma> cbTurma;
	public String foto = "";
	private static int validacaoTurma = 0;
	public static int codigoTurma = 0;
	public static JTextField txtCodigo;
	public static String caminho = "";
	static Image img1;
	// static Image img2;

	/**
	 * Create the panel.
	 */
	public pnlHorario() {

		cbTurma = new JComboBox<Turma>();
		control.TurmaControl.carregarComboTurma(cbTurma);

		setBackground(Color.WHITE);
		setLayout(null);

		lblFoto = new JLabel("");
		img1 = new ImageIcon(this.getClass().getResource("/horarios.jpg")).getImage();
		lblFoto.setIcon(new ImageIcon(img1));
		lblFoto.setBounds(81, 124, 1189, 405);
		add(lblFoto);

		JButton button = new JButton("Foto");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foto = util.Outros.Imagem(lblFoto);
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		button.setBounds(1110, 551, 160, 61);
		add(button);

		JLabel lblCadastroDeHorrios = new JLabel("Cadastro de Hor\u00E1rios");
		lblCadastroDeHorrios.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblCadastroDeHorrios.setBounds(559, 21, 319, 40);
		add(lblCadastroDeHorrios);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnLimpar.setBounds(940, 551, 160, 61);
		add(btnLimpar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validacao()) {
					control.TurmaControl.BuscarTurmaNome(cbTurma.getSelectedItem().toString(), "horario");
					if (control.HorarioControl.ValidarHorario(codigoTurma)) {
						control.HorarioControl.BuscarHorarioTurma(codigoTurma, "administrador");
					} else {
						JOptionPane.showMessageDialog(null, "Horario não existe");
					}
				}
			}
		});
		btnConsultar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnConsultar.setBounds(595, 551, 160, 61);
		add(btnConsultar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validacao()) {
					if (txtCodigo.getText().toString().trim().length() != 0) {
						control.HorarioControl.AlterarHorario(Integer.parseInt(txtCodigo.getText()), codigoTurma, foto);
						if (control.HorarioControl.ValidarHorario(codigoTurma)) {
							control.TurmaControl.BuscarTurmaNome(cbTurma.getSelectedItem().toString(), "horario");
							Limpar();
						} else {
							JOptionPane.showMessageDialog(null, "Horario não existe");
						}
					} else {
						JOptionPane.showMessageDialog(null, "É necessário o código");
					}

				}
			}
		});
		btnAlterar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnAlterar.setBounds(770, 551, 160, 61);
		add(btnAlterar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validacao()) {
					control.TurmaControl.BuscarTurmaNome(cbTurma.getSelectedItem().toString(), "horario");
					if (control.HorarioControl.ValidarHorario(codigoTurma) != true) {
						control.HorarioControl.CadastrarHorario(codigoTurma, foto);
						Limpar();
					} else {
						JOptionPane.showMessageDialog(null, "Turma já possui horário");
					}
					
				}
			}
		});
		btnCadastrar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnCadastrar.setBounds(425, 551, 160, 61);
		add(btnCadastrar);

		// cbTurma = new JComboBox<Turma>();
		cbTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validacaoTurma = 1;
			}
		});
		cbTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbTurma.setBounds(200, 78, 187, 35);
		add(cbTurma);

		JLabel label = new JLabel("Turma");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label.setBounds(196, 52, 131, 23);
		add(label);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCodigo.setBounds(81, 78, 93, 35);
		add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblCdigo.setBounds(81, 52, 99, 23);
		add(lblCdigo);

	}

	public static boolean Validacao() {
		if (validacaoTurma == 1) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma turma");
			return false;
		}
	}

	public static void Limpar() {
		txtCodigo.setText("");
		lblFoto.setIcon(new ImageIcon(img1));

	}

}

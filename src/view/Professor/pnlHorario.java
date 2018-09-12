package view.Professor;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import model.Turma;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlHorario extends JPanel {

	public static int validacaoTurma = 1;
	private JComboBox<Turma> cbTurma;
	public static int codigoTurma = 0;
	public static JLabel lblFoto;
	/**
	 * Create the panel.
	 */
	public pnlHorario() {
		cbTurma = new JComboBox<Turma>();
		control.TurmaControl.carregarComboTurma(cbTurma);
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		JButton button = new JButton("Consultar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Validacao()) {
					control.TurmaControl.BuscarTurmaNome(cbTurma.getSelectedItem().toString(), "horarioprofessor");
					if (control.HorarioControl.ValidarHorario(codigoTurma)) {
						control.HorarioControl.BuscarHorarioTurma(codigoTurma, "professor");
					} else {
						JOptionPane.showMessageDialog(null, "Horario não existe");
					}
				} 
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		button.setBounds(1118, 550, 160, 61);
		add(button);
		
		lblFoto = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/horarios.jpg")).getImage();
		lblFoto.setIcon(new ImageIcon(img1));
		lblFoto.setBounds(91, 132, 1189, 397);
		add(lblFoto);
		
		//cbTurma = new JComboBox<Turma>();
		cbTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validacaoTurma = 1;
			}
		});
		cbTurma.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		cbTurma.setBounds(95, 86, 187, 35);
		add(cbTurma);
		
		JLabel label_1 = new JLabel("Turma");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		label_1.setBounds(91, 60, 131, 23);
		add(label_1);
		
		JLabel label_2 = new JLabel("Consulta de Hor\u00E1rios");
		label_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		label_2.setBounds(591, 38, 319, 40);
		add(label_2);

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

package view.Administracao;

import java.awt.Font;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.Color;

public class pnlEventoCadastro extends JPanel {
	public static JTextField txtTituloEvento;
	public static JTextArea txtDescricaoEvento;

	MaskFormatter data;
	public static JFormattedTextField txtData;
	public static JTextField txtCodigo;

	public static JLabel vData;
	public static JLabel vTitulo;
	public static JLabel vDescricao;

	/**
	 * Create the panel.
	 */
	public pnlEventoCadastro() {
		setBackground(Color.WHITE);
		setLayout(null);

		try {

			data = new MaskFormatter("##/##/####");
			data.setValidCharacters("0123456789");

		} catch (Exception e) {
			e.printStackTrace();
		}

		txtTituloEvento = new JTextField();
		txtTituloEvento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtTituloEvento.setColumns(10);
		txtTituloEvento.setBounds(448, 250, 390, 36);
		add(txtTituloEvento);

		txtDescricaoEvento = new JTextArea();
		txtDescricaoEvento.setBackground(Color.LIGHT_GRAY);
		txtDescricaoEvento.setRows(6);
		txtDescricaoEvento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtDescricaoEvento.setColumns(10);
		txtDescricaoEvento.setBounds(448, 333, 390, 181);
		txtDescricaoEvento.setLineWrap(true);
		add(txtDescricaoEvento);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblTitulo.setBounds(448, 221, 61, 18);
		add(lblTitulo);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblDescrio.setBounds(448, 296, 139, 40);
		add(lblDescrio);

		JButton btnGravarEvento = new JButton("Gravar");
		btnGravarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (ValidarEvento() == 1) {

					Calendar ano = Calendar.getInstance();

					control.EventoControl.CadastrarEvento(txtTituloEvento.getText(), txtDescricaoEvento.getText(),
							control.EventoControl.converteData(txtData), Integer.toString(ano.get(Calendar.YEAR)));

					LimparEvento();
				}

			}
		});
		btnGravarEvento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnGravarEvento.setBounds(322, 543, 147, 55);
		add(btnGravarEvento);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (ValidarEvento() == 1) {

					if (txtCodigo.getText().toString().trim().length() != 0) {

						control.EventoControl.AlterarEvento(Integer.parseInt(txtCodigo.getText()),
								txtTituloEvento.getText(), txtDescricaoEvento.getText(),
								control.EventoControl.converteData(txtData));

						LimparEvento();
					} else {
						JOptionPane.showMessageDialog(null, "Código é necessário");
					}
				}
			}
		});
		btnAlterar.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		btnAlterar.setBounds(496, 543, 147, 55);
		add(btnAlterar);

		JButton button_3 = new JButton("Excluir");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ValidarEvento() == 1) {

					if (txtCodigo.getText().toString().trim().length() != 0) {

						control.EventoControl.ExcluirEvento(Integer.parseInt(txtCodigo.getText()));

						LimparEvento();
					} else {
						JOptionPane.showMessageDialog(null, "Código é necessário");
					}
				}
			}
		});
		button_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		button_3.setBounds(669, 543, 147, 55);
		add(button_3);

		JButton button_4 = new JButton("Limpar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LimparEvento();
			}
		});
		button_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		button_4.setBounds(839, 543, 147, 55);
		add(button_4);

		txtData = new JFormattedTextField((AbstractFormatter) data);
		txtData.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtData.setColumns(10);
		txtData.setBounds(447, 163, 156, 36);
		add(txtData);

		JLabel lblDataDoEvento = new JLabel("Data do Evento");
		lblDataDoEvento.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		lblDataDoEvento.setBounds(446, 132, 198, 28);
		add(lblDataDoEvento);

		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		lblEventos.setBounds(642, 11, 162, 40);
		add(lblEventos);

		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 23));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(448, 91, 117, 36);
		add(txtCodigo);

		JLabel tx = new JLabel("C\u00F3digo");
		tx.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		tx.setBounds(448, 53, 103, 36);
		add(tx);

		vData = new JLabel("*");
		vData.setForeground(Color.RED);
		vData.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vData.setBounds(420, 163, 28, 35);
		add(vData);

		vTitulo = new JLabel("*");
		vTitulo.setForeground(Color.RED);
		vTitulo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vTitulo.setBounds(420, 250, 28, 35);
		add(vTitulo);

		vDescricao = new JLabel("*");
		vDescricao.setForeground(Color.RED);
		vDescricao.setFont(new Font("Berlin Sans FB", Font.PLAIN, 54));
		vDescricao.setBounds(420, 333, 28, 35);
		add(vDescricao);

	}

	public int ValidarEvento() {
		int resultado = 0;

		if ((txtData.getText().trim().length() != 0) && (txtTituloEvento.getText().trim().length() != 0)
				&& (txtDescricaoEvento.getText().trim().length() != 0)) {

			resultado = 1;

		} else {

			JOptionPane.showMessageDialog(null, "Preenchimento de campos incorreto");

			resultado = 0;

			if (txtData.getText().trim().length() < 5) {
				vData.setVisible(true);
			} else {
				vData.setVisible(false);
			}

			if (txtTituloEvento.getText().trim().length() == 0) {
				vTitulo.setVisible(true);
			} else {
				vTitulo.setVisible(false);
			}

			if (txtDescricaoEvento.getText().trim().length() == 0) {
				vDescricao.setVisible(true);
			} else {
				vDescricao.setVisible(false);
			}

		}

		return resultado;

	}

	public static void LimparEvento() {

		txtCodigo.setText("");
		txtData.setText("");
		vData.setVisible(false);
		txtTituloEvento.setText("");
		vTitulo.setVisible(false);
		txtDescricaoEvento.setText("");
		vDescricao.setVisible(false);

	}
}

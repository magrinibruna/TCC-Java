package util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.Nota;

public class Planilha {

	public static Nota Excel(int linha, String caminho) throws IOException, BiffException {

		model.Nota objNota = new model.Nota();
		List<Nota> listNota = new ArrayList<>();

		Workbook workbook = Workbook.getWorkbook(new File(caminho));
		// BufferedReader reader = new BufferedReader(new FileReader(new
		// File("src/codigo/planilha.xlsx")));

		// contagem de linhas
		Sheet sheet = workbook.getSheet(0);
		int linhas = sheet.getRows();

		// leitura da planilh
		// for (int i = 0; i < linhas; i++) {

		// pegando valores coluna/linha
		Cell a1 = sheet.getCell(0, linha);
		Cell a2 = sheet.getCell(1, linha);
		// Cell a3 = sheet.getCell(2, i);

		// convertendo valores p string
		String rm = a1.getContents();
		String nota = a2.getContents();
		// String as3 = a3.getContents();

		// setando os valores
		objNota.setId_Aluno(Integer.parseInt(rm));
		objNota.setNota(Double.parseDouble(nota));
		return objNota;

		// mostrando valores
		// System.out.println("Coluna 1: " + rm);
		// System.out.println("Coluna 2: " + nota);
		// System.out.println("Coluna 3: " + as3);
		// }

		// workbook.close();
		// return objNota;

	}

	public static int LinhasPlanilha(String caminho) throws IOException, BiffException {

		model.Nota objNota = new model.Nota();
		List<Nota> listNota = new ArrayList<>();

		Workbook workbook = Workbook.getWorkbook(new File(caminho));
		// BufferedReader reader = new BufferedReader(new FileReader(new
		// File("src/codigo/planilha.xlsx")));

		// contagem de linhas
		Sheet sheet = workbook.getSheet(0);
		int linhas = sheet.getRows();

		return linhas;
	}

	static String caminhoArquivo = "";
	public static String SelecionaPlanilha() {

		JFileChooser arquivoEscolhido = new JFileChooser();
		int retorno = arquivoEscolhido.showOpenDialog(null);

		if (retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = arquivoEscolhido.getSelectedFile().getAbsolutePath();
		}
		return caminhoArquivo;

	}

}

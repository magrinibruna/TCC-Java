package util;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class Outros {
	
	static String caminhoFoto = "";
	
	public static String Imagem(JLabel labelImagem) {
		
		JFileChooser arquivoEscolhido = new JFileChooser();
		int retorno = arquivoEscolhido.showOpenDialog(null); 
		 
		if (retorno==JFileChooser.APPROVE_OPTION){
			 caminhoFoto = arquivoEscolhido.getSelectedFile().getAbsolutePath();  
		}
		ImageIcon image = new ImageIcon(caminhoFoto);
				 
		labelImagem.setIcon(new ImageIcon
				(image.getImage().getScaledInstance(labelImagem.getWidth(),labelImagem.getHeight(), Image.SCALE_DEFAULT)));
		
		return caminhoFoto;
		
	}

}

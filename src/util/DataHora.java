package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class DataHora {
	
	public static Date converteData(JFormattedTextField campoComData) {
		
		SimpleDateFormat formatoDaData = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dataUsuario = new java.util.Date(); 
		try {
			dataUsuario = formatoDaData.parse(campoComData.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date dataSQL = new java.sql.Date(dataUsuario.getTime());
		return dataSQL;
	}
	
	public static void pegaData(final JLabel label){
		 Timer timer = new Timer();  
		    TimerTask task = new TimerTask() {  
		        public void run() {  
		        	label.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));  
		    }  
		    };  
		    timer.schedule(task, 1000, 1000);  
	}
	public static Date pegaData(){
		    return new Date(System.currentTimeMillis());
	}
	
	public static void pegaHora(final JLabel label){
		 Timer timer = new Timer();  
		    TimerTask task = new TimerTask() {  
		        public void run() {  
		        	label.setText(new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));  
		    }  
		    };  
		    timer.schedule(task, 1000, 1000);  
	}
	
	public static void pegaDataHora(final JLabel label){
		 Timer timer = new Timer();  
		    TimerTask task = new TimerTask() {  
		        public void run() {  
		        	label.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(System.currentTimeMillis())));  
		    }  
		    };  
		    timer.schedule(task, 1000, 1000);  
	}

}

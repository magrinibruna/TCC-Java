package util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;

import javax.swing.JFormattedTextField;

public class ConnectionFactory {
	
	public Connection getConnection() 
	{ 
		try {
			return DriverManager.getConnection(
					//drivermanager � a classe (letra maiuscula)
					//getconnection (metodo de conex�o da classe drivermanager)
					"jdbc:sqlserver://localhost:1433;" +
					//jdb � o conector, no caso sqlserver
					//localhost � que o servidor est� na m�quina
					//1433 porta
					"databaseName=Portalzinho_v3;" +
					//nome do banco
					"user=sa; password=123456;");				
					//usuario e senha
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	//Convertendo texto pra data data
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
	
	public static String pegaData(Date data) {
		
		return String.valueOf((new SimpleDateFormat("dd/MM/yyyy").format(data)));
		
	}
	

}

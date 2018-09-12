package util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MensagemEmail {

	public static void EmailMensagem(String destinario) throws EmailException {

		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("portaldoalunoINF3FM@gmail.com", "emilysaidozap")); // login
		email.setSSLOnConnect(true);
		email.setFrom("portaldoalunoINF3FM@gmail.com", "Portal do Aluno"); // enviado de
		email.setSubject("Nova mensagem!"); // assunto
		email.setMsg("Você tem uma nova mensagem! Logue no Portal do Aluno e verifique [: "); // mensagem
		email.addTo(destinario); // destinario
		email.send();
	}

}

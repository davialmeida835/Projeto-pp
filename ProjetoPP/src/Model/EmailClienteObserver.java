package Model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import DTO.ClienteDTO;

public class EmailClienteObserver implements ClienteObserver {

	
	public  void clienteOptInParaEmail(ClienteDTO cliente) {
		SimpleEmail email = new SimpleEmail();
		try {

		// email.setDebug(true);

		email.setHostName("smtp.gmail.com");
		email.setAuthentication("mensageiroct@gmail.com", "ocmghxpsdmtryxkn");
		email.setSSL(true);
		email.addTo(cliente.getEmail());
		email.setFrom(cliente.getEmail());
		email.setSubject("Contrato");
		email.setMsg(null);
		email.send();
		} catch (EmailException e) {
		System.out.println("Falha ao enviar o email!");
		}
		}

}

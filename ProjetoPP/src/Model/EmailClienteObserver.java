package Model;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import DTO.ClienteDTO;
import DTO.DatasDeNotificacaoDTO;

public class EmailClienteObserver implements Observerint {

	
	public void clienteOptInParaEmail(SujeitoObservable cliente) {
	    CentralDeInformacoes central = CentralDeInformacoes.getInstance();
	    List<DatasDeNotificacaoDTO> datas = central.getDatas();

	    for (DatasDeNotificacaoDTO data : datas) {
	        LocalDate dataAtual = LocalDate.now();

	      
	        if (data.getDataDeEntrega().isEqual(dataAtual)) {
	            enviarEmailParaCliente(cliente, data);
	        }
	    }
	}

	private void enviarEmailParaCliente(SujeitoObservable cliente, DatasDeNotificacaoDTO data) {

	    if (((ClienteDTO) cliente).getDesejaReceberEmail()) {
	       
	        String descricao = data.getDescricao();
	        enviarEmail((ClienteDTO) cliente, descricao);
	    }
	}

	private void enviarEmail(ClienteDTO cliente, String descricao) {
	    SimpleEmail email = new SimpleEmail();
	    try {
	        // Configuração do e-mail
	        email.setHostName("smtp.gmail.com");
	        email.setAuthentication("mensageiroct@gmail.com", "ocmghxpsdmtryxkn");
	        email.setSSL(true);

	        // Construção do e-mail
	        email.addTo(cliente.getEmail());
	        email.setFrom(CentralDeInformacoes.getInstance().getUsuario().getEmail());
	        email.setSubject("Atenção!!");
	        email.setMsg("Novo Evento na nossa Loja!!! Venha Conferir as Novidades. " + descricao);
	        // Envio do e-mail
	        email.send();
	    } catch (EmailException e) {
	        System.out.println("Falha ao enviar o email!");
	    }
	}

	
	

	
	


}

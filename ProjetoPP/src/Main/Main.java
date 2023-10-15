package Main;

import DAO.Persistencia;
import Model.CentralDeInformacoes;
import View.JanelaDeCadastroUsuario;
import View.JanelaDeLogin;

public class Main {
	public static void main(String[] args) {
		
		CentralDeInformacoes central = Persistencia.recuperarCentral("central");
		if (central.getUsuario() == null) {
			JanelaDeCadastroUsuario jde = new JanelaDeCadastroUsuario();
		}
		else {
			JanelaDeLogin jdl = new JanelaDeLogin();
		}
		
	}


}

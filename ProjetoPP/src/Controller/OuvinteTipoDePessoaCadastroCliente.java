package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaDeCadastroCliente;

public class OuvinteTipoDePessoaCadastroCliente implements ActionListener {

	private JanelaDeCadastroCliente janelaDeCadastro;

	public OuvinteTipoDePessoaCadastroCliente(JanelaDeCadastroCliente janelaDeCadastro) {
		this.janelaDeCadastro = janelaDeCadastro;
	}

	public void actionPerformed(ActionEvent e) {
		janelaDeCadastro.getTipoDePessoa().setEnabled(true);
		if(janelaDeCadastro.getCaixaDePessoaFisica().isSelected()) {
			janelaDeCadastro.getPessoaFisica().setText("Digite seu cpf:");
		}
		else {
			janelaDeCadastro.getPessoaFisica().setText("Digite seu cnpj:");
		}
	}

}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

import DAO.Persistencia;
import Model.CentralDeInformacoes;
import Model.Cliente;
import Model.ClientePessoaFisica;
import Model.ClientePessoaJuridica;
import Util.Validar;
import View.JanelaDeCadastroCliente;

public class OuvinteBotaoCadastrarCliente implements ActionListener {

	private JanelaDeCadastroCliente cadastrarCliente;

	public OuvinteBotaoCadastrarCliente(JanelaDeCadastroCliente cadastrarCliente) {
		this.cadastrarCliente = cadastrarCliente;
	}

	//cadastra os clientes se todas as informações estiverem corretas
	public void actionPerformed(ActionEvent e) {
		cadastrarCliente.getTipoDePessoa().setEnabled(true);
		if (cadastrarCliente.getCaixaDePessoaFisica().isSelected()) {
			cadastrarCliente.getPessoaFisica().setText("Digite seu cpf:");
		} else {
			cadastrarCliente.getPessoaFisica().setText("Digite seu cnpj:");
		}

		CentralDeInformacoes central = Persistencia.recuperarCentral("central");
		String nome = cadastrarCliente.getCampoDoNome().getText();
		String telefone = cadastrarCliente.getCampoDoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		String email = cadastrarCliente.getCampoDeEmail().getText();

		String cpfOuCnpj = cadastrarCliente.getTipoDePessoa().getText();

		boolean flag = true;
		try {
			InternetAddress eValido = new InternetAddress(email);
			eValido.validate();
		} catch (AddressException a) {
			flag = false;
		}

		if (flag == false) {
			JOptionPane.showMessageDialog(cadastrarCliente, "Digite um E-mail válido");
		} else if (nome.length() == 0) {
			JOptionPane.showMessageDialog(cadastrarCliente, "Preencha o campo do nome");

		} else if (telefone.length() != 11) {
			JOptionPane.showMessageDialog(cadastrarCliente, "Digite um número de telefone válido");
		} else if ((cadastrarCliente.getCaixaDePessoaFisica().isSelected() && !Validar.validarCpf(cpfOuCnpj)) || (cadastrarCliente.getCaixaDePessoaJuridica().isSelected() && !Validar.validarCnpj(cpfOuCnpj))) {
			JOptionPane.showMessageDialog(cadastrarCliente, "Digite um cpf ou cnpj válido");
		} 
		else {
			Cliente cliente = null;
			if (cadastrarCliente.getCaixaDePessoaFisica().isSelected()) {
				cliente = new ClientePessoaFisica(nome,Long.parseLong(telefone), email, Long.parseLong(cpfOuCnpj));
			} else {
				cliente = new ClientePessoaJuridica(nome, Long.parseLong(telefone), email, Long.parseLong(cpfOuCnpj));
			}
			JOptionPane.showMessageDialog(cadastrarCliente, "Cadastro efetuado com sucesso!");
			central.addCliente(cliente);
			Persistencia.salvarCentral(central, "central");
			cadastrarCliente.dispose();
			new JanelaDeCadastroCliente();
		}
	}



}

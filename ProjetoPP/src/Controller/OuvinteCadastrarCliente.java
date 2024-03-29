package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import Model.CentralDeInformacoes;
import Model.Cliente;
import Model.EmailClienteObserver;
import Model.Validar;
import View.JanelaDeCadastroCliente;

public class OuvinteCadastrarCliente implements ActionListener {

	private JanelaDeCadastroCliente cadastrarCliente;

	public OuvinteCadastrarCliente(JanelaDeCadastroCliente cadastrarCliente) {
		this.cadastrarCliente = cadastrarCliente;
	}

	//cadastra os clientes se todas as informações estiverem corretas
	public void actionPerformed(ActionEvent e) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		String nome = cadastrarCliente.getCampoDoNome().getText();
		String telefone = cadastrarCliente.getCampoDoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		String email = cadastrarCliente.getCampoDeEmail().getText();
		boolean receber = cadastrarCliente.getCaixaReceber().isSelected();
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
		} else if ((cadastrarCliente.getCaixaDePessoaFisica().isSelected() && (cpfOuCnpj.length() != 11) || (cadastrarCliente.getCaixaDePessoaJuridica().isSelected() && (cpfOuCnpj.length() != 14)))) {
			JOptionPane.showMessageDialog(cadastrarCliente, "Digite um cpf ou cnpj válido");
		} 
		else {
			ClienteDTO cliente = new ClienteDTO(nome,Long.parseLong(telefone), email, Long.parseLong(cpfOuCnpj), receber);
			ClienteDAO clienteDAO = new ClienteDAO();
			EmailClienteObserver ob = new  EmailClienteObserver();
			cliente.addObserver(ob);
			JOptionPane.showMessageDialog(cadastrarCliente, "Cadastro efetuado com sucesso!");
			clienteDAO.cadastrarCliente(cliente);
			Persistencia.salvarCentral(central, "central");
			cadastrarCliente.dispose();
			new JanelaDeCadastroCliente();
		}
	}



}

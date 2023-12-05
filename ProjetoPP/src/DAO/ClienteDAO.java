package DAO;

import javax.swing.JOptionPane;

import Controller.Persistencia;
import DTO.ClienteDTO;
import Model.CentralDeInformacoes;

public class ClienteDAO implements ClienteDAOIf{

	public void cadastrarCliente(ClienteDTO clienteDTO) {
		if(!verificarSeTemCliente(clienteDTO)) {
			CentralDeInformacoes.getInstance().getClientes().add(clienteDTO);
			Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
		}else {
			JOptionPane.showMessageDialog(null, "Cliente com cpf/cnpj já existente");
		}
	}

	public boolean verificarSeTemCliente(ClienteDTO clienteDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		for(ClienteDTO clientes : central.getClientes()) {
			if(clientes.getCpfECnpj() == clienteDTO.getCpfECnpj()){
				return true;
			}
		}
		return false;
	}

	public void atualizarCliente(ClienteDTO clienteDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		if(verificarSeTemCliente(clienteDTO)) {
			for(ClienteDTO clientes : central.getClientes()) {
				if(clientes.getId() == clienteDTO.getId()){
					clientes.setCpfECnpj(clienteDTO.getCpfECnpj());
					clientes.setEmail(clienteDTO.getEmail());
					clientes.setNome(clienteDTO.getNome());
					clientes.setTelefone(clienteDTO.getTelefone());
				}
			}
		}
		Persistencia.salvarCentral(central, "central");
	}

	public void deletarCliente(ClienteDTO clienteDTO) {
		if(verificarSeTemCliente(clienteDTO)) {
			CentralDeInformacoes.getInstance().getClientes().remove(clienteDTO);
		}
		Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
	}

	
}

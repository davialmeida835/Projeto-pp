package DAO;

import Controller.Persistencia;
import DTO.ClienteDTO;
import Model.CentralDeInformacoes;

public class ClienteDAO implements ClienteDAOIf{

	public void cadastrarCliente(ClienteDTO clienteDTO) {
		if(!verificarSeTemCliente(clienteDTO)) {
			CentralDeInformacoes.getInstance().getClientes().add(clienteDTO);
			Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
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
				if(clientes.getCpfECnpj() == clienteDTO.getCpfECnpj()){
					clientes = clienteDTO;
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

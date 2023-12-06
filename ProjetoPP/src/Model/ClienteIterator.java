package Model;

import DTO.ClienteDTO;

public class ClienteIterator implements Iterator {

	private ClienteDTO[] clientes;
	private int posicao;
	
	public ClienteIterator(ClienteDTO[] clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public boolean hasNext() {
		if(posicao >= clientes.length || clientes[posicao] != null) {
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Object next() {
		ClienteDTO cliente = clientes[posicao];
		posicao++;
		return cliente;
	}

	
}

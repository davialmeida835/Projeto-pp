package Model;

import java.util.Iterator;
import java.util.List;

import DTO.ClienteDTO;

public class ClienteDTOIterator implements Iterable<ClienteDTO>{
	
	private List<ClienteDTO> clientes;
	
	public ClienteDTOIterator(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}

	@Override
	public Iterator<ClienteDTO> iterator() {
		return clientes.iterator();
	}

}

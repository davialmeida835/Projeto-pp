package DAO;

import DTO.ClienteDTO;

public interface ClienteDAOIf {

	void cadastrarCliente(ClienteDTO clienteDTO);
    boolean verificarSeTemCliente(ClienteDTO clienteDTO);
    void atualizarCliente(ClienteDTO clienteDTO);
    void deletarCliente(ClienteDTO clienteDTO);
}

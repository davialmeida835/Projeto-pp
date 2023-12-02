package DAO;

import DTO.PedidoDTO;

public interface PedidoIf {
	
	void cadastrarPedido(PedidoDTO pedidoDTO);
    boolean verificarSeTemPedido(PedidoDTO pedidoDTO);
    void atualizarPedido(PedidoDTO pedidoDTO);
    void deletarPedido(PedidoDTO pedidoDTO);
}

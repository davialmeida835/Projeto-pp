package Model;

import java.time.LocalDate;
import java.util.List;

import DTO.ClienteDTO;
import DTO.MaterialDTO;
import DTO.PedidoDTO;

public interface PedidoBuilder {
	



	PedidoBuilder descricao(String descricao);
    PedidoBuilder dataEntrega(LocalDate dataEntrega);
    PedidoBuilder quantidade(int quantidade);
    PedidoBuilder cliente(ClienteDTO cliente);
    PedidoBuilder tamanho(TamanhoRoupa tamanho);
    PedidoBuilder materiais(List<MaterialDTO> materiais);
    PedidoBuilder preco(double preco);
    PedidoBuilder tipoRoupa(Object tipoRoupa);
    PedidoBuilder pagamento(boolean pagamento);
    PedidoBuilder finalizado(boolean finalizado);

    PedidoDTO build();
	 	
}

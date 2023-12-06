package Model;

import java.time.LocalDate;
import java.util.List;

import DTO.ClienteDTO;
import DTO.MaterialDTO;
import DTO.PedidoDTO;

public class PedidoBuilderImpl implements PedidoBuilder{
	private String descricao=null;
    private LocalDate dataEntrega;
    private int quantidade;
    private ClienteDTO cliente;
    private TamanhoRoupa tamanho;
    private List<MaterialDTO> materiais;
    private double preco;
    private Object tipoRoupa;
    private boolean pagamento;
    private boolean finalizado = false;
    private int numero;

    @Override
    public PedidoBuilder descricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    @Override
    public PedidoBuilder dataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
        return this;
    }

    @Override
    public PedidoBuilder quantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    @Override
    public PedidoBuilder cliente(ClienteDTO cliente) {
        this.cliente = cliente;
        return this;
    }

    @Override
    public PedidoBuilder tamanho(TamanhoRoupa tamanho) {
        this.tamanho = tamanho;
        return this;
    }

    @Override
    public PedidoBuilder materiais(List<MaterialDTO> materiais) {
        this.materiais = materiais;
        return this;
    }

    @Override
    public PedidoBuilder preco(double preco) {
        this.preco = preco;
        return this;
    }

    @Override
    public PedidoBuilder tipoRoupa(Object tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
        return this;
    }

    @Override
    public PedidoBuilder pagamento(boolean pagamento) {
        this.pagamento = pagamento;
        return this;
    }

    @Override
    public PedidoBuilder finalizado(boolean finalizado) {
        this.finalizado = finalizado;
        return this;
    }

    public PedidoDTO build() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setDescricao(this.descricao);
        pedidoDTO.setDataEntrega(this.dataEntrega);
        pedidoDTO.setQuantidade(this.quantidade);
        pedidoDTO.setCliente(this.cliente);
        pedidoDTO.setTamanho(this.tamanho);
        pedidoDTO.setMateriais(this.materiais);
        pedidoDTO.setPreco(this.preco);
        pedidoDTO.setTipoderoupa(this.tipoRoupa);
        pedidoDTO.setPagamento(this.pagamento);
        pedidoDTO.setFinalizado(this.finalizado);
        pedidoDTO.setNumero(this.numero);

        return pedidoDTO;
    }

	public PedidoBuilder numero(int proximoNumero) {
		this.numero=proximoNumero;
		return this;
	}


}

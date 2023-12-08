package DTO;

import java.time.LocalDate;
import java.util.List;

import Model.CentralDeInformacoes;
import Model.Cliente;
import Model.Material;
import Model.PedidoBuilder;
import Model.PedidoBuilderImpl;
import Model.TamanhoRoupa;
import Model.TipoRoupa;

public class PedidoDTO {

	

    public static PedidoBuilder builder() {
    	  int proximoNumero = obterUltimoNumeroPedido();
          return new PedidoBuilderImpl().numero(proximoNumero);
    }

    public static int obterUltimoNumeroPedido() {
        List<PedidoDTO> pedidos = CentralDeInformacoes.getInstance().getPedidos();
        
        int ultimoNumero = 0;

        for (PedidoDTO pedido : pedidos) {
            int numeroAtual = pedido.getNumero();
            if (numeroAtual > ultimoNumero) {
                ultimoNumero = numeroAtual;
            }
        }

        return ultimoNumero +1;
    }
    
    private static int proximoId = obterUltimoNumeroPedido();
    private TipoRoupa tipoderoupa;
	private int numero;
    private String descricao;
    private LocalDate dataEntrega;
    public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	private int quantidade;
    private ClienteDTO cliente;
    private TamanhoRoupa tamanho;
    private List<MaterialDTO> materiais;
    private double preco;
    private boolean pagamento;
    private boolean finalizado = false;
    private LocalDate dataDePagamento;



    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

   



	public ClienteDTO getCliente() {
		return cliente;
	}



	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public TamanhoRoupa getTamanho() {
		return tamanho;
	}



	public void setTamanho(TamanhoRoupa tamanho) {
		this.tamanho = tamanho;
	}



	public List<MaterialDTO> getMateriais() {
		return materiais;
	}



	public void setMateriais(List<MaterialDTO> materiais) {
		this.materiais = materiais;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Object getTipoderoupa() {
		return tipoderoupa;
	}

	public void setTipoderoupa(TipoRoupa tipoderoupa) {
		this.tipoderoupa = tipoderoupa;
	}

	public String isPagamento() {
		if(pagamento==true) {
			return"Pago";
		}
		return "Pendente";
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}

	public String isFinalizado() {
		if(finalizado==false) {
			return "Em Andamento";
		}
		return "Finalizado";
		
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTipoderoupa1(TipoRoupa tipoderoupa) {
		this.tipoderoupa = tipoderoupa;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static int getProximoId() {
		return proximoId;
	}

	public static int setProximoId(int proximoId) {
		PedidoDTO.proximoId = proximoId;
		return proximoId;
	}

	public LocalDate getDataDePagamento() {
		return dataDePagamento;
	}

	public void setDataDePagamento(LocalDate dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}
	

}

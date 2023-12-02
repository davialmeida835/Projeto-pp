package DTO;

import java.time.LocalDate;
import java.util.List;

import Model.CentralDeInformacoes;
import Model.Cliente;
import Model.Material;
import Model.TamanhoRoupa;
import Model.TipoRoupa;

public class PedidoDTO {

    public PedidoDTO( String descricao, LocalDate dataEntrega, int quantidade, ClienteDTO cliente,
			TamanhoRoupa tamanho, List<MaterialDTO> materiais,double preco,Object tipoRoupaSelecionado) {
	
		numero=++proximoId;
		this.descricao = descricao;
		this.dataEntrega = dataEntrega;
		this.quantidade = quantidade;
		this.cliente = cliente;
		this.tamanho = tamanho;
		this.materiais = materiais;
		this.setPreco(preco);
		this.tipoderoupa= tipoRoupaSelecionado;
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

        return ultimoNumero;
    }
    
    private static int proximoId = obterUltimoNumeroPedido();
    private Object tipoderoupa;
	private int numero;
    private String descricao;
    private LocalDate dataEntrega;
    private int quantidade;
    private ClienteDTO cliente;
    private TamanhoRoupa tamanho;
    private List<MaterialDTO> materiais;
    private double preco;


 



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
	

}

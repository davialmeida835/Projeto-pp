package Model;

import java.time.LocalDate;
import java.util.List;

import DTO.ClienteDTO;
import DTO.MaterialDTO;

public class Pedido {

	
	    private int numero;
	    private String descricao;
	    private LocalDate dataEntrega;
	    private int quantidade;
	    private ClienteDTO cliente;
	    private TamanhoRoupa tamanho;
	    private List<MaterialDTO> materiais;
	    private double preco;
	    private Object tipoDeRoupa;
	    private boolean pagamento;
	    private boolean finalizado = false;
	   
	

	    public Pedido(int numero, String descricao, LocalDate dataEntrega, int quantidade, ClienteDTO cliente,
				TamanhoRoupa tamanho, List<MaterialDTO> materiais,double preco,Object tipoDeRoupa) {
		
			this.numero = numero;
			this.descricao = descricao;
			this.dataEntrega = dataEntrega;
			this.quantidade = quantidade;
			this.cliente = cliente;
			this.tamanho = tamanho;
			this.materiais = materiais;
			this.preco=preco;
			this.setTipoDeRoupa(tipoDeRoupa);
			
		}

	

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



		public Object getTipoDeRoupa() {
			return tipoDeRoupa;
		}



		public void setTipoDeRoupa(Object tipoDeRoupa) {
			this.tipoDeRoupa = tipoDeRoupa;
		}



		public boolean isPagamento() {
			return pagamento;
		}



		public void setPagamento(boolean pagamento) {
			this.pagamento = pagamento;
		}



		public boolean isFinalizado() {
			return finalizado;
		}



		public void setFinalizado(boolean finalizado) {
			this.finalizado = finalizado;
		}



	

}

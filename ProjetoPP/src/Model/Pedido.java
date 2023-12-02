package Model;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	
	    private int numero;
	    private String descricao;
	    private LocalDate dataEntrega;
	    private int quantidade;
	    private Cliente cliente;
	    private TamanhoRoupa tamanho;
	    private List<Material> materiais;
	    private double preco;
	   
	

	    public Pedido(int numero, String descricao, LocalDate dataEntrega, int quantidade, Cliente cliente,
				TamanhoRoupa tamanho, List<Material> materiais,double preco) {
		
			this.numero = numero;
			this.descricao = descricao;
			this.dataEntrega = dataEntrega;
			this.quantidade = quantidade;
			this.cliente = cliente;
			this.tamanho = tamanho;
			this.materiais = materiais;
			this.preco=preco;
			
			
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

	   



		public Cliente getCliente() {
			return cliente;
		}



		public void setCliente(Cliente cliente) {
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



		public List<Material> getMateriais() {
			return materiais;
		}



		public void setMateriais(List<Material> materiais) {
			this.materiais = materiais;
		}



		public double getPreco() {
			return preco;
		}



		public void setPreco(double preco) {
			this.preco = preco;
		}



	

}

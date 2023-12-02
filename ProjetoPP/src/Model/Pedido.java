package Model;

import java.util.List;

public class Pedido {

	
	    private int numero;
	    private String descricao;
	    private String dataEntrega;
	    private int quantidade;
	    private Cliente cliente;
	    private TamanhoRoupa tamanho;
	    private List<Material> materiais;
	

	    public Pedido(int numero, String descricao, String dataEntrega, int quantidade, Cliente cliente,
				TamanhoRoupa tamanho, List<Material> materiais) {
		
			this.numero = numero;
			this.descricao = descricao;
			this.dataEntrega = dataEntrega;
			this.quantidade = quantidade;
			this.cliente = cliente;
			this.tamanho = tamanho;
			this.materiais = materiais;
		}

	

	    public int getNumero() {
	        return numero;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public String getDataEntrega() {
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
	

}

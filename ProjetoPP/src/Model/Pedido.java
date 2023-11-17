package Model;

public class Pedido {

	
	    private int numero;
	    private String descricao;
	    private String dataEntrega;
	    private String itens;

	

	    public Pedido(int numero, String descricao, String dataEntrega, String itens) {
	        this.numero = numero;
	        this.descricao = descricao;
	        this.dataEntrega = dataEntrega;
	        this.itens = itens;
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

	    public String getItens() {
	        return itens;
	    }
	

}

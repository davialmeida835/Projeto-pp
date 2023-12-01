package Model;

public class Material {

	private String nome;
	private double tamanho;
	
	private TipoDeMaterial tipoDeMaterial;
	private double preco;
	private long id;
	
	public Material(String nome, double tamanho, TipoDeMaterial tipoDeMaterial, double preco) {
		this.nome = nome;
		this.tamanho = tamanho;
		
		this.tipoDeMaterial = tipoDeMaterial;
		this.preco = preco;
		this.id = System.currentTimeMillis(); 
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	
	public TipoDeMaterial getTipoDeMaterial() {
		return tipoDeMaterial;
	}
	
	public void setTipoDeMaterial(TipoDeMaterial tipoDeMaterial) {
		this.tipoDeMaterial = tipoDeMaterial;
	}

}

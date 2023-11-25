package Model;

public class Material {

	private String nome;
	private double tamanho;
	private boolean disponivel;
	private TipoDeMaterial tipoDeMaterial;
	private double preco;
	
	public Material(String nome, double tamanho, boolean disponivel, TipoDeMaterial tipoDeMaterial, double preco) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.disponivel = disponivel;
		this.tipoDeMaterial = tipoDeMaterial;
		this.preco = preco;
	}
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
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

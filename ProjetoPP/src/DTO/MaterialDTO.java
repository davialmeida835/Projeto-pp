package DTO;

import Model.TipoDeMaterial;

public class MaterialDTO {

	private String nome;
	private double tamanho;
	private TipoDeMaterial tipoDeMaterial;
	private double preco;
	private long id;
	
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

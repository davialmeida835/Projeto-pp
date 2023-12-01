package DTO;

import java.time.LocalDate;

public class HistoricoDeCompraDTO {

	private MaterialDTO material;
	private LocalDate dataDaCompra;
	private double preco;
	private double tamanho;
	
	public MaterialDTO getMaterial() {
		return material;
	}
	public void setMaterial(MaterialDTO material) {
		this.material = material;
	}
	public LocalDate getDataDaCompra() {
		return dataDaCompra;
	}
	public void setDataDaCompra(LocalDate dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public HistoricoDeCompraDTO(MaterialDTO material, double preco, double tamanho) {
		this.material = material;
		this.dataDaCompra = LocalDate.now();
		this.preco = preco;
		this.tamanho = tamanho;
	}
	
	
}

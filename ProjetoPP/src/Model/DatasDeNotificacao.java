package Model;

import java.time.LocalDate;

public class DatasDeNotificacao {
	
	private LocalDate dataDeEntrega;
	private String descricao;
	
	public DatasDeNotificacao(LocalDate dataDeEntrega,String descricao) {
		this.dataDeEntrega=dataDeEntrega;
		this.descricao=descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataDeEntrega() {
		return dataDeEntrega;
	}
	public void setDataDeEntrega(LocalDate dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

}

package DTO;

import java.time.LocalDate;

public class DatasDeNotificacaoDTO {
	private LocalDate dataDeEntrega;
	private String descricao;
	private long id;
	
	public DatasDeNotificacaoDTO(LocalDate dataDeEntrega,String descricao) {
		this.dataDeEntrega=dataDeEntrega;
		this.descricao=descricao;
		setId(System.currentTimeMillis());
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}

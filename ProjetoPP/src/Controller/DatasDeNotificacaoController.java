package Controller;

import DAO.DatasDeNotificacaoDAO;
import DTO.DatasDeNotificacaoDTO;

public class DatasDeNotificacaoController {

	private DatasDeNotificacaoDTO data;
	
	public DatasDeNotificacaoController(DatasDeNotificacaoDTO data) {
		this.setData(data);
	}
	public void add() {
		DatasDeNotificacaoDAO d = new DatasDeNotificacaoDAO();
		d.cadastrarData(data);
	}
	public void remover() {
		DatasDeNotificacaoDAO d = new DatasDeNotificacaoDAO();
		d.deletarData(data);
	}
	public void atualizar() {
		DatasDeNotificacaoDAO d = new DatasDeNotificacaoDAO();
		d.atualizarData(data);
	}
	
	public DatasDeNotificacaoDTO getData() {
		return data;
	}

	public void setData(DatasDeNotificacaoDTO data) {
		this.data = data;
	}
}

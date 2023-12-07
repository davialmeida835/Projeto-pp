package DAO;

import DTO.ClienteDTO;
import DTO.DatasDeNotificacaoDTO;

public interface DatasDeNotificacaoDAOIf {
	
	void cadastrarData(DatasDeNotificacaoDTO dataDTO);
    boolean verificarSeTemData(DatasDeNotificacaoDTO dataDTO);
    void atualizarData(DatasDeNotificacaoDTO dataDTO);
    void deletarData(DatasDeNotificacaoDTO dataDTO);

}

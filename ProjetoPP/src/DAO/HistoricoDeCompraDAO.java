package DAO;

import Controller.Persistencia;
import DTO.HistoricoDeCompraDTO;
import Model.CentralDeInformacoes;

public class HistoricoDeCompraDAO implements HistoricoDeCompraDAOIf{

	
	public void cadastrarHistoricoDeCompra(HistoricoDeCompraDTO historicoDeCompra) {
		CentralDeInformacoes.getInstance().getHistorico().add(0, historicoDeCompra);
		
		Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
	}

	public void deletarHistoricoDeCompra(HistoricoDeCompraDTO historicoDeCompra) {
		CentralDeInformacoes.getInstance().getHistorico().remove(historicoDeCompra);
		
		Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
	}

	
}

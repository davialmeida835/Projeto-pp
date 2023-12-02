package DAO;

import DTO.HistoricoDeCompraDTO;

public interface HistoricoDeCompraDAOIf {

	void cadastrarHistoricoDeCompra(HistoricoDeCompraDTO HistoricoDeCompra);
    void deletarHistoricoDeCompra(HistoricoDeCompraDTO HistoricoDeCompra);
    
}

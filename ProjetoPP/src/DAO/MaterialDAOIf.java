package DAO;

import DTO.MaterialDTO;

public interface MaterialDAOIf {

	void cadastrarMaterial(MaterialDTO materialDTO);
    boolean verificarSeTemMaterial(MaterialDTO materialDTO);
    void atualizarMaterial(MaterialDTO materialDTO);
    void deletarMaterial(MaterialDTO materialDTO);
}

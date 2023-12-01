package DAO;

import DTO.FornecedorDTO;

public interface FornecedorDAOIf {
	void cadastrarFornecedor(FornecedorDTO fornecedorDTO);
    boolean JaCadastradoFornecedor(FornecedorDTO fornecedorDTO);
    void atualizarFornecedor(FornecedorDTO fornecedorDTO);
    void deletarFornecedor(FornecedorDTO fornecedorDTO);

}

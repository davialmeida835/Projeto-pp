package Controller;

import DAO.FornecedorDAO;
import DTO.FornecedorDTO;
import Model.CentralDeInformacoes;


public class FornecedorController {
	  private CentralDeInformacoes central;

	    public FornecedorController(CentralDeInformacoes central) {
	        this.central = central;
	    }

	    public boolean cadastrarFornecedor(FornecedorDTO fornecedorDTO) {
	        FornecedorDAO fornecedorDAO = new FornecedorDAO(central);

	        if (!fornecedorDAO.JaCadastradoFornecedor(fornecedorDTO)) {
	            fornecedorDAO.cadastrarFornecedor(fornecedorDTO);
	            return true;
	        }

	        return false;
	    }

}

package Controller;

import DAO.FornecedorDAO;
import DTO.FornecedorDTO;
import Model.CentralDeInformacoes;
import Model.Fornecedor;
import View.JanelaPadrao;


public class FornecedorController {
	  
		private JanelaPadrao janela;
	
	    public FornecedorController(JanelaPadrao janela) {
	    	this.janela=janela;
	    }


	
	    public void deletarFornecedor(FornecedorDTO fornecedorDTO) {
	    	FornecedorDAO fornecedorDAO = new FornecedorDAO();
	    	fornecedorDAO.deletarFornecedor(fornecedorDTO);
	    }
	  


	    public boolean cadastrarFornecedor(FornecedorDTO fornecedorDTO) {
	        Fornecedor fornecedor = new Fornecedor(fornecedorDTO.getNome(), fornecedorDTO.getTelefone(), fornecedorDTO.getMateriaisFornecidos());
	    	
	    	
	    	FornecedorDAO fornecedorDAO = new FornecedorDAO();

	        if (!fornecedorDAO.JaCadastradoFornecedor(fornecedorDTO)) {
	            fornecedorDAO.cadastrarFornecedor(fornecedorDTO);
	            return true;
	        }

	        return false;
	    }
	    
	    public void atualizarFornecedor(FornecedorDTO fornecedorDTO) {
	    	FornecedorDAO fornecedorDAO = new FornecedorDAO();
	    	fornecedorDAO.atualizarFornecedor(fornecedorDTO);
	    }

}

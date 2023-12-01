package Controller;

import Model.CentralDeInformacoes;
import Model.Fornecedor;

public class FornecedorController {
	  private CentralDeInformacoes central;

	    public FornecedorController(CentralDeInformacoes central) {
	        this.central = central;
	    }

	    public boolean cadastrarFornecedor(String nome, String telefone, String materiaisFornecidos) {
	        if (!fornecedorJaCadastrado(nome, telefone)) {
	            Fornecedor fornecedor = new Fornecedor(nome, telefone, materiaisFornecidos);
	            central.addFornecedor(fornecedor);
	            Persistencia.salvarCentral(central, "central");
	            return true; 
	        }
	        return false; 
	    }

	    public boolean fornecedorJaCadastrado(String nome, String telefone) {
	        for (Fornecedor fornecedor : central.getFornecedores()) {
	            if (fornecedor.getNome().equalsIgnoreCase(nome) && fornecedor.getTelefone().equals(telefone)) {
	                return true; 
	            }
	        }
	        return false; 
	    }
	
	

}

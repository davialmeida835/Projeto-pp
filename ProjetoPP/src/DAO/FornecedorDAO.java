package DAO;

import java.util.ArrayList;
import java.util.List;

import Controller.Persistencia;
import DTO.FornecedorDTO;
import Model.CentralDeInformacoes;

public class FornecedorDAO implements FornecedorDAOIf{
	private CentralDeInformacoes central;
	private List<FornecedorDTO> fornecedores;
	public FornecedorDAO(CentralDeInformacoes central) {
        this.fornecedores = new ArrayList<>();
        this.central=central;
    }
	public void cadastrarFornecedor(FornecedorDTO fornecedorDTO) {
		fornecedores.add(fornecedorDTO);
		central.addFornecedor(fornecedorDTO);
		Persistencia.salvarCentral(central, "central");
	}
	

	public boolean JaCadastradoFornecedor(FornecedorDTO fornecedorDTO) {
		 for (FornecedorDTO fornecedor : fornecedores) {
	            if (fornecedor.getNome().equalsIgnoreCase(fornecedorDTO.getNome())
	                    && fornecedor.getTelefone().equals(fornecedorDTO.getTelefone())) {
	                
	                return true;
	            }
	        }
	        return false;
	
	}

	public void atualizarFornecedor(FornecedorDTO fornecedorDTO) {
		
	}

	public void deletarFornecedor(FornecedorDTO fornecedorDTO) {
	
	}

}

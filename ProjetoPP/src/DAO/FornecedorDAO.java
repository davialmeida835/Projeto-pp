package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.Persistencia;
import DTO.FornecedorDTO;
import DTO.PedidoDTO;
import Model.CentralDeInformacoes;

public class FornecedorDAO implements FornecedorDAOIf{
	

	public void cadastrarFornecedor(FornecedorDTO fornecedorDTO) {
		if(!JaCadastradoFornecedor(fornecedorDTO)) {
			CentralDeInformacoes.getInstance().getFornecedores().add(fornecedorDTO);
			Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Pedido já EXISTE");
		}
	}
	

	public boolean JaCadastradoFornecedor(FornecedorDTO fornecedorDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		for(FornecedorDTO fornecedor : central.getFornecedores()) {
			if(fornecedor.getTelefone()== fornecedorDTO.getTelefone()){
				if(fornecedor.getNome()== fornecedorDTO.getNome()) {
				return true;
				}
			}
		}
		return false;
		
	
	}

	public void atualizarFornecedor(FornecedorDTO fornecedorDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		    if (JaCadastradoFornecedor(fornecedorDTO)) {
		        for (FornecedorDTO fornecedor : central.getFornecedores()) {
		            if (fornecedor.getNome().equals(fornecedorDTO.getNome()) || fornecedor.getTelefone().equals(fornecedorDTO.getTelefone())) {
		                fornecedor.setNome(fornecedorDTO.getNome());
		                fornecedor.setTelefone(fornecedorDTO.getTelefone());
		                fornecedor.setMateriaisFornecidos(fornecedorDTO.getMateriaisFornecidos());
		               
		                break; 
		            }
		        }
		    }
		    Persistencia.salvarCentral(central, "central");
		
		
	}

	
	public void deletarFornecedor(FornecedorDTO fornecedorDTO) {
	
		if (JaCadastradoFornecedor(fornecedorDTO)) {
	        CentralDeInformacoes.getInstance().getFornecedores().removeIf(fornecedor ->
	            fornecedor.getNome().equals(fornecedorDTO.getNome()) && fornecedor.getTelefone().equals(fornecedorDTO.getTelefone())
	        );
	        JOptionPane.showInternalMessageDialog(null, "FOI DELETADO!");
	    }
	    Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
	}
	

}

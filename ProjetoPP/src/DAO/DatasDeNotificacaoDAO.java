package DAO;

import javax.swing.JOptionPane;

import Controller.Persistencia;
import DTO.DatasDeNotificacaoDTO;

import Model.CentralDeInformacoes;

public class DatasDeNotificacaoDAO implements DatasDeNotificacaoDAOIf{

	
	public void cadastrarData(DatasDeNotificacaoDTO dataDTO) {
		if(!verificarSeTemData(dataDTO)) {
			CentralDeInformacoes.getInstance().addData(dataDTO);
			Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Data já EXISTE");
		}
		
	}

	
	public boolean verificarSeTemData(DatasDeNotificacaoDTO dataDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		if(central.getDatas()==null) {
			return false;
		}
		for(DatasDeNotificacaoDTO data : central.getDatas()) {
			if(data.getId()== dataDTO.getId()){
				return true;
				
			}
		}
		return false;
		
	}

	
	public void atualizarData(DatasDeNotificacaoDTO dataDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
	    if (verificarSeTemData(dataDTO)) {
	        for (DatasDeNotificacaoDTO data : central.getDatas()) {
	            if (data.getId()==dataDTO.getId()) {
	               data=dataDTO;
	               break; 
	            }
	        }
	    }
	    Persistencia.salvarCentral(central, "central");
	
		
	}

	
	public void deletarData(DatasDeNotificacaoDTO dataDTO) {
		if (verificarSeTemData(dataDTO)) {
	        CentralDeInformacoes.getInstance().getDatas().removeIf(data ->
	           data.getId()==dataDTO.getId());
	        JOptionPane.showInternalMessageDialog(null, "FOI DELETADO!");
	    }
	    Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
	}
	
		
		
	

}

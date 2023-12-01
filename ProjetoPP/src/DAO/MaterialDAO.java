package DAO;

import javax.swing.JOptionPane;

import Controller.Persistencia;
import DTO.ClienteDTO;
import DTO.MaterialDTO;
import Model.CentralDeInformacoes;

public class MaterialDAO implements MaterialDAOIf{

	@Override
	public void cadastrarMaterial(MaterialDTO materialDTO) {
		if(!verificarSeTemMaterial(materialDTO)) {
			CentralDeInformacoes.getInstance().getMateriais().add(materialDTO);
			Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
		}else {
			JOptionPane.showMessageDialog(null, "Já existe esse material");
		}
		
	}

	@Override
	public boolean verificarSeTemMaterial(MaterialDTO materialDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		for(MaterialDTO materiais : central.getMateriais()) {
			if(materiais.getNome().equals(materialDTO.getNome())){
				return true;
			}
		}
		return false;
	}

	@Override
	public void atualizarMaterial(MaterialDTO materialDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		if(verificarSeTemMaterial(materialDTO)) {
			for(MaterialDTO materiais : central.getMateriais()) {
				if(materiais.getNome().equals(materialDTO.getNome())){
					materiais = materialDTO;
				}
			}
		}
		Persistencia.salvarCentral(central, "central");
		
	}

	@Override
	public void deletarMaterial(MaterialDTO materialDTO) {
		if(verificarSeTemMaterial(materialDTO)) {
			CentralDeInformacoes.getInstance().getMateriais().remove(materialDTO);
		}
		Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
		
	}

	
}

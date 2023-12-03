package DAO;

import java.util.Iterator;

import javax.swing.JOptionPane;

import Controller.Persistencia;
import DTO.MaterialDTO;
import Model.CentralDeInformacoes;
import Model.MaterialIterator;

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
	public void atualizarMaterial(MaterialDTO materialDTO, boolean disponibilidade) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		if(verificarSeTemMaterial(materialDTO)) {
			for(MaterialDTO materiais : central.getMateriais()) {
				if(materiais.getNome().equals(materialDTO.getNome())){
					materiais.setDisponivel(disponibilidade);;
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

	@Override
	public void atualizarMaterial(MaterialDTO materialDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		if(verificarSeTemMaterial(materialDTO)) {
			for(MaterialDTO materiais : central.getMateriais()) {
				if(materiais.getId() == materialDTO.getId()){
					materiais.setNome(materialDTO.getNome());
					materiais.setTipoDeMaterial(materialDTO.getTipoDeMaterial());
					materiais.setDisponivel(materialDTO.isDisponivel());
				}
			}
		}
		Persistencia.salvarCentral(central, "central");
		
	}

//	public Iterator<MaterialDTO> iterator(){
//		return new MaterialIterator(CentralDeInformacoes.getInstance().getMateriais().toArray());
//	}
}

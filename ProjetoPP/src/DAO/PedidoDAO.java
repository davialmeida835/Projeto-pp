package DAO;

import javax.swing.JOptionPane;

import Controller.Persistencia;
import DTO.ClienteDTO;
import DTO.PedidoDTO;
import Model.CentralDeInformacoes;

public class PedidoDAO implements PedidoIf{

	
	public void cadastrarPedido(PedidoDTO pedidoDTO) {
		if(!verificarSeTemPedido(pedidoDTO)) {
			CentralDeInformacoes.getInstance().getPedidos().add(pedidoDTO);
			Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Pedido já EXISTE");
		}
		
	}

	
	public boolean verificarSeTemPedido(PedidoDTO pedidoDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		for(PedidoDTO pedidos : central.getPedidos()) {
			if(pedidos.getNumero()== pedidoDTO.getNumero()){
				return true;
			}
		}
		return false;
		
	}


	public void atualizarPedido(PedidoDTO pedidoDTO) {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		if(verificarSeTemPedido(pedidoDTO)) {
			for(PedidoDTO pedidos : central.getPedidos()) {
				if(pedidos.getNumero() == pedidoDTO.getNumero()){
					pedidos = pedidoDTO;
					JOptionPane.showInternalMessageDialog(null, "FOI ATUALIZADO!");
				}
			}
		}
		Persistencia.salvarCentral(central, "central");
	
		
	}

	@Override
	public void deletarPedido(PedidoDTO pedidoDTO) {
		if(verificarSeTemPedido(pedidoDTO)) {
			CentralDeInformacoes.getInstance().getPedidos().remove(pedidoDTO);
			JOptionPane.showInternalMessageDialog(null, "FOI DELETADO!");
		}
		Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
		
	}

}

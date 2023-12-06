package Controller;

import DAO.PedidoDAO;
import DTO.PedidoDTO;
import Model.Pedido;
import View.JanelaPadrao;

public class PedidoController {
	
	public PedidoController(JanelaPadrao janela, PedidoDTO pedido) {
		
		this.setJanela(janela);
		this.pedido = pedido;
		
		
	}
	public void add() {
		

		PedidoDAO p = new PedidoDAO();
		
		p.cadastrarPedido(pedido);
	}
	public void atualizarPedido() {
	        PedidoDAO pedidoDAO = new PedidoDAO();
	        pedidoDAO.atualizarPedido(pedido);
	}
	public void deletar() {
		 PedidoDAO pedidoDAO = new PedidoDAO();
	     pedidoDAO.deletarPedido(pedido);
	}
	public JanelaPadrao getJanela() {
		return janela;
	}

	public void setJanela(JanelaPadrao janela) {
		this.janela = janela;
	}
	private JanelaPadrao janela;
	private PedidoDTO pedido;

	
	
	

	

}

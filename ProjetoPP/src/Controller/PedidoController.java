package Controller;

import DAO.PedidoDAO;
import DTO.PedidoDTO;
import Model.Pedido;
import View.JanelaPadrao;

public class PedidoController {
	
	public PedidoController(JanelaPadrao janela, PedidoDTO pedido) {
		
		this.setJanela(janela);
		this.pedido = pedido;
		add();
		
	}
	public void add() {
		Pedido pedidoM = new Pedido(pedido.getNumero(),pedido.getDescricao(),
				pedido.getDataEntrega(),pedido.getQuantidade(),pedido.getCliente(),
				pedido.getTamanho(),pedido.getMateriais(),pedido.getPreco(),
				pedido.getTipoderoupa());

		PedidoDAO p = new PedidoDAO();
		
		p.cadastrarPedido(pedido);
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

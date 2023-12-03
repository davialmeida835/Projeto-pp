package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.JanelaAdicionarMateriais;
import View.JanelaDeCadastraPedido;
import View.JanelaDeCadastroCliente;
import View.JanelaDeCadastroFornecedor;
import View.JanelaDeMenu;
import View.JanelaListaFornecedores;
import View.JanelaListaMateriais;
import View.JanelaListaPedidos;

public class MenuController implements ActionListener {

	private JanelaDeMenu janelaDeMenu;

	public MenuController(JanelaDeMenu janelaDeMenu) {
		this.janelaDeMenu = janelaDeMenu;
	}

	//entra na janela do nome do botão
	public void actionPerformed(ActionEvent e) {
		 String selecionado = e.getActionCommand();
		 CriaJanela.criarJanela(selecionado);
		 janelaDeMenu.dispose();
	}
	
		
	

}

package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaDeCadastroCliente;
import View.JanelaDeCadastroFornecedor;
import View.JanelaDeMenu;
import View.JanelaListaFornecedores;

public class OuvinteBotoesDoMenu implements ActionListener {

	private JanelaDeMenu janelaDeMenu;

	public OuvinteBotoesDoMenu(JanelaDeMenu janelaDeMenu) {
		this.janelaDeMenu = janelaDeMenu;
	}

	//entra na janela do nome do botão
	public void actionPerformed(ActionEvent e) {
		String selecionado = e.getActionCommand();
		if (selecionado.equals("CADASTRAR CLIENTES")) {
			new JanelaDeCadastroCliente();
		} else if (selecionado.equals("CADASTRAR FORNECEDORES")) {
			new JanelaDeCadastroFornecedor();
		} else if (selecionado.equals("Cadastrar Pacotes de Fornecedores")) {
			//new JanelaCadastrarPacoteDeFornecedores();
		} else if (selecionado.equals("Cadastrar Serviços")) {
			//new JanelaCadastrarServico();
		} else if (selecionado.equals("Editar Serviços")) {
			//new JanelaEditarServicos();
		} else if (selecionado.equals("Cadastrar Orçamentos")) {
			//new JanelaCadastrarOrcamento();
		} else if (selecionado.equals("LISTA DE FORNECEDORES")) {
			new JanelaListaFornecedores();
		} else if (selecionado.equals("Lista de Pacotes de Fornecedores")) {
			//new JanelaListaDePacotesDeFornecedores();
		} else if (selecionado.equals("Lista de Orçamentos")) {
			//new JanelaListaDeOrcamentos();
		}
		janelaDeMenu.dispose();
	}

}

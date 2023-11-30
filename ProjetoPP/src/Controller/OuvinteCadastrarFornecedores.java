package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.JanelaDeCadastroFornecedor;
import View.JanelaPadrao;

public class OuvinteCadastrarFornecedores implements ActionListener {

	 private JanelaPadrao janelaPadrao;

	    public OuvinteCadastrarFornecedores(JanelaPadrao janelaPadrao) {
	        this.janelaPadrao = janelaPadrao;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Lógica para abrir a janela de cadastro de fornecedores
	        new JanelaDeCadastroFornecedor();
	        janelaPadrao.dispose(); // Fechar a janela atual, se necessário
	    }
	
}

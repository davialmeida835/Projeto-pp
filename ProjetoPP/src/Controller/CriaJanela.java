package Controller;

import javax.swing.JFrame;

import View.JanelaAdicionarMateriais;
import View.JanelaDeCadastraPedido;
import View.JanelaDeCadastroCliente;
import View.JanelaDeCadastroFornecedor;
import View.JanelaListaFornecedores;
import View.JanelaListaMateriais;
import View.JanelaListaPedidos;

public class CriaJanela {
	
	public static JFrame criarJanela(String tipoDeJanela) {
        switch (tipoDeJanela) {
            case "CADASTRAR CLIENTES":
                return new JanelaDeCadastroCliente();
            case "CADASTRAR FORNECEDORES":
                return new JanelaDeCadastroFornecedor();
            case "CADASTRAR MATERIAIS":
                return new JanelaAdicionarMateriais();
            case "CADASTRAR PEDIDOS":
                return new JanelaDeCadastraPedido();
            case "LISTA DE PEDIDOS":
                return new JanelaListaPedidos();
            case "Cadastrar Orçamentos":
                //return new JanelaCadastrarOrcamento();
            case "LISTA DE FORNECEDORES":
                return new JanelaListaFornecedores();
            case "LISTA DE MATERIAIS":
                return new JanelaListaMateriais();
            case "Lista de Orçamentos":
                //return new JanelaListaDeOrcamentos();
            	
            default:
               throw null;
                    
                
        }
    }

}

package Controller;

import javax.swing.JFrame;

import View.JanelaAdicionarMateriais;
import View.JanelaAgenda;
import View.JanelaDeCadastraPedido;
import View.JanelaDeCadastroCliente;
import View.JanelaDeCadastroFornecedor;
import View.JanelaGerarRelatorio;
import View.JanelaListaClientes;
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
            case "LISTA DE CLIENTES":
                return new JanelaListaClientes();
            case "LISTA DE FORNECEDORES":
                return new JanelaListaFornecedores();
            case "LISTA DE MATERIAIS":
                return new JanelaListaMateriais();
            case "AGENDA":
                return new JanelaAgenda();
            case "GERAR RELATÓRIO":
            	return new JanelaGerarRelatorio();
            default:
               throw null;
                    
                
        }
    }

}

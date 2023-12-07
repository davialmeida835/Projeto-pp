package Controller;

import javax.swing.JFrame;

import View.JanelaAdicionarMateriais;
import View.JanelaDeCadastraPedido;
import View.JanelaDeCadastroCliente;
import View.JanelaDeCadastroFornecedor;
import View.JanelaListaClientes;
import View.JanelaListaDeDatas;
import View.JanelaListaFornecedores;
import View.JanelaListaMateriais;
import View.JanelaListaPedidos;
import View.janelaDatasEmail;

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
            case "CADASTRAR DATA":
                return new janelaDatasEmail();
            case "LISTA DE DATAS":
            	return new JanelaListaDeDatas();
            	
            default:
               throw null;
                    
                
        }
    }

}

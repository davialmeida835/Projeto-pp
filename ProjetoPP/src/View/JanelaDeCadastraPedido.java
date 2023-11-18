package View;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controller.TipoRoupaFactory;
import Model.TipoRoupa;
import Util.Util;

public class JanelaDeCadastraPedido extends JanelaPadrao{

	public JanelaDeCadastraPedido() {
		addTexto(0, 10, 550, 30, "Fazer Pedido", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(0, 30, 550, 30,  "Monte seu Pedido",new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		String[] opcoes = {"Opção 1", "Opção 2", "Opção 3", "Opção 4"};
		
		addTexto(70,70,200,20,"Tipo de Roupa:");
		addTexto(70,140,150,20,"Tipo de costura:");
		addComboBox(70,170,100,30,opcoes );
		addTexto(70,210,150,20,"Tipo de Tecido:");
		addTexto(300,140,150,20,"Tamanho da Peça:");
		addComboBox(300,170,100,30,opcoes );
		addComboBox(70,240,100,30,opcoes );
		adicionarComponentesQuantidade();
		 List<String> tiposRoupaStrings = new ArrayList<>();
	        JComboBox<String> comboBoxTipoRoupa = new JComboBox<>(tiposRoupaStrings.toArray(new String[0]));
	        comboBoxTipoRoupa.setBounds(70, 100, 150, 30);
	        add(comboBoxTipoRoupa);
	        
	        comboBoxTipoRoupa.addActionListener(e -> {
	            
	            String tipoSelecionado = (String) comboBoxTipoRoupa.getSelectedItem();

	           
	            int preco = (int) obterPrecoDoTipoRoupa(tipoSelecionado);

	            
	            TipoRoupa tipoRoupa = TipoRoupaFactory.criarTipoRoupa(tipoSelecionado,preco);

	         
	            System.out.println("Tipo de Roupa Selecionado: " + tipoRoupa.getDescricao());
	            System.out.println("Preço: " + tipoRoupa.getPreco());
	        });

	       
	        tiposRoupaStrings.add("Vestido");
	        tiposRoupaStrings.add("Camiseta");
	        tiposRoupaStrings.add("Terno");
	        tiposRoupaStrings.add("Shorts");

	    
	        
	        comboBoxTipoRoupa.setModel(new DefaultComboBoxModel<>(tiposRoupaStrings.toArray(new String[0])));
		criarTabelaClientes();
		addB();
		addTexto(300,70,150,20,"Data de Entrega:");
		
		
		adicionarCampoDaDataDeNascimento();
		setVisible(true);
		
		}
	private int obterPrecoDoTipoRoupa(String tipoRoupa) {
		if("Vestido"==tipoRoupa) {
			return 20;
		}
        return 10;
	}
	
	private void adicionarCampoDaDataDeNascimento() {
		
		JFormattedTextField campoDoNatalicio;
		try {
			MaskFormatter mf = new MaskFormatter("##/##/####");
			campoDoNatalicio = new JFormattedTextField(mf);
			campoDoNatalicio.setBorder(new LineBorder(Color.BLACK, 1));
			campoDoNatalicio.setFont(Util.FONTE_PADRAO);
			campoDoNatalicio.setHorizontalAlignment(JTextField.CENTER);
			campoDoNatalicio.setBounds(300, 100, 130, 25);
			add(campoDoNatalicio);
		} catch (ParseException e) {}

	}
	
	private void addB() {
		JButton botao = new JButton("Salvar");
		botao.setBounds(150, 400, 100, 30);
		botao.setForeground(Color.BLACK);
		botao.setBackground(Color.WHITE);
		add(botao);
		
		JButton botao1 = new JButton("Cancelar");
		botao1.setBounds(300, 400, 100, 30);
		botao1.setForeground(Color.BLACK);
		botao1.setBackground(Color.WHITE);
		add(botao1);
	
	}
	private void criarTabelaClientes() {
        String[] colunas = {"Nome", "Telefone", "Endereço"};
        Object[][] dados = {
                {"Cliente 1", "123-456-7890", "Rua A, 123"},
                {"Cliente 2", "987-654-3210", "Rua B, 456"},
               
        };

        JTable tabelaClientes = new JTable(dados, colunas);
        tabelaClientes.setBounds(70, 300, 400, 80);

        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        scrollPane.setBounds(70, 300, 400, 80);

        add(scrollPane);
    }

    private void adicionarComponentesQuantidade() {
        addTexto(300, 210, 150, 20, "Quantidade:");

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1); 
        JSpinner spinnerQuantidade = new JSpinner(spinnerModel);
        spinnerQuantidade.setBounds(400, 210, 50, 25);
        add(spinnerQuantidade);
    }
    public static void main(String[]args) {
    	TipoRoupaFactory t = new TipoRoupaFactory();
    	
    	JanelaDeCadastraPedido j = new JanelaDeCadastraPedido();
	
    }
}

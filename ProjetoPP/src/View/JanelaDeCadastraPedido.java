package View;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Controller.TipoRoupaFactory;
import DTO.ClienteDTO;
import Model.CentralDeInformacoes;
import Model.Cliente;
import Model.Material;
import Model.TamanhoRoupa;
import Model.Util;

public class JanelaDeCadastraPedido extends JanelaPadrao{
	public List<Material> materiaisSelecionados = new ArrayList<>();
	private DefaultListModel<Material> listModel;
    private JList<Material> jListMateriais;
	public JanelaDeCadastraPedido() {
		addTexto(0, 10, 550, 30, "Fazer Pedido", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(0, 30, 550, 30,  "Monte seu Pedido",new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(70,140,100,30,"Materiais:");
		addTexto(70,70,200,20,"Tipo de Roupa:");
		addTexto(300,140,150,30,"Tamanho:");
//		List<Material> materiais = obterMateriais();
		JComboBox<TamanhoRoupa> comboBoxTamanhoRoupa = new JComboBox<>(TamanhoRoupa.values());
        comboBoxTamanhoRoupa.setBounds(380, 140, 90, 25);
        add(comboBoxTamanhoRoupa);
		
		listModel = new DefaultListModel<>();
		
		 	
	    jListMateriais = new JList<>(listModel);
	    jListMateriais.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

//	    CentralDeInformacoes centralDeInfo = CentralDeInformacoes.getInstance();
//	       materiais = centralDeInfo.getMateriais();
//	       for (Material material : materiais) {
//	           listModel.addElement(material);
//	        }

//	     TipoDeMaterial tipo1 = new TipoDeMaterial("Tipo1");
//	     TipoDeMaterial tipo2 = new TipoDeMaterial("Tipo2");
//	     TipoDeMaterial tipo3 = new TipoDeMaterial("Tipo3");
//
//	
//	     listModel.addElement(new Material("Material1", 30.0, true, tipo1, 25.0));
//	     listModel.addElement(new Material("Material2", 20.0, false, tipo2, 15.0));
//	     listModel.addElement(new Material("Material3", 25.0, true, tipo3, 20.0));

	     JScrollPane scrollPaneMateriais = new JScrollPane(jListMateriais);
	     scrollPaneMateriais.setBounds(70, 170, 120, 100);
	     add(scrollPaneMateriais);

	     jListMateriais.addListSelectionListener(e -> {
	            materiaisSelecionados.clear();
	            materiaisSelecionados.addAll(jListMateriais.getSelectedValuesList());
	        });

	
        

        
		adicionarComponentesQuantidade();
		 List<String> tiposRoupaStrings = new ArrayList<>();
	        JComboBox<String> comboBoxTipoRoupa = new JComboBox<>(tiposRoupaStrings.toArray(new String[0]));
	        comboBoxTipoRoupa.setBounds(70, 100, 120, 25);
	        add(comboBoxTipoRoupa);
	        
	        comboBoxTipoRoupa.addActionListener(e -> {
	            
	            String tipoSelecionado = (String) comboBoxTipoRoupa.getSelectedItem();

	           
	            int preco = (int) obterPrecoDoTipoRoupa(tipoSelecionado);
	            TipoRoupaFactory.criarTipoRoupa(tipoSelecionado,preco);

	         
	            
	        });

	       
	        tiposRoupaStrings.add("Vestido");
	        tiposRoupaStrings.add("Camiseta");
	        tiposRoupaStrings.add("Terno");
	        tiposRoupaStrings.add("Shorts");

	    
	        
	    comboBoxTipoRoupa.setModel(new DefaultComboBoxModel<>(tiposRoupaStrings.toArray(new String[0])));
		criarTabelaClientes();
		addB();
		addTexto(300,70,150,20,"Data de Entrega:");
		
		addWallpaper();
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
			campoDoNatalicio.setBounds(300, 100, 170, 25);
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
        
        Object[][] dados = obterDadosClientes();
        String[] colunas = {"Nome", "Telefone", "Email"};

      
        DefaultTableModel model = new DefaultTableModel(dados, colunas);

   
        JTable tabelaClientes = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        scrollPane.setBounds(70, 300, 400, 80);

        
        add(scrollPane);
    }

    private Object[][] obterDadosClientes() {
        
        List<ClienteDTO> clientes = CentralDeInformacoes.getInstance().getClientes();

        Object[][] dados = new Object[clientes.size()][3];

       
        for (int i = 0; i < clientes.size(); i++) {
            ClienteDTO cliente = clientes.get(i);
            dados[i][0] = cliente.getNome();
            dados[i][1] = cliente.getTelefone();
            dados[i][2] = cliente.getEmail();
        }

        return dados;
    
    }
//	  private List<Material> obterMateriais() {
////		  List<Material> materiais = new ArrayList<>();
////	        materiais.add(new Material("Material1", 30.0, true, new TipoDeMaterial("Tipo1"), 25.0));
////	        materiais.add(new Material("Material2", 20.0, false, new TipoDeMaterial("Tipo2"), 15.0));
////	        materiais.add(new Material("Material3", 25.0, true, new TipoDeMaterial("Tipo3"), 20.0));
////	        return materiais;
//	    }

    private void adicionarComponentesQuantidade() {
        addTexto(300, 210, 150, 20, "Quantidade:");

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 400, 1); 
        JSpinner spinnerQuantidade = new JSpinner(spinnerModel);
        spinnerQuantidade.setBounds(400, 210, 70, 25);
        add(spinnerQuantidade);
    }
    public static void main(String[]args) {
    	
    	
    	JanelaDeCadastraPedido j = new JanelaDeCadastraPedido();
	
    }
}

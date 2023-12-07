package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Controller.PedidoController;
import Controller.Persistencia;
import Controller.TipoRoupaFactory;
import DTO.ClienteDTO;
import DTO.MaterialDTO;
import DTO.PedidoDTO;
import Model.CentralDeInformacoes;
import Model.Cliente;
import Model.Material;
import Model.TamanhoRoupa;
import Model.Util;

public class JanelaDeCadastraPedido extends JanelaPadrao{
	public List<MaterialDTO> materiaisSelecionados = new ArrayList<>();
	private DefaultListModel<MaterialDTO> listModel;
    private JList<MaterialDTO> jListMateriais;
    private JComboBox<String> comboBoxTipoRoupa;
    private JComboBox<TamanhoRoupa> comboBoxTamanhoRoupa;
    private JSpinner spinnerQuantidade;
    private JTable tabelaClientes;
    private List<ClienteDTO> clientes;
    private JFormattedTextField campoDaData;
    private double preco;
	public JanelaDeCadastraPedido() {
		addTexto(0, 10, 550, 30, "Fazer Pedido", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(0, 30, 550, 30,  "Monte seu Pedido",new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addTexto(70,140,100,30,"Materiais:");
		addTexto(70,70,200,20,"Tipo de Roupa:");
		addTexto(300,140,150,30,"Tamanho:");

		//combo tamanho
		comboBoxTamanhoRoupa = new JComboBox<>(TamanhoRoupa.values());
        comboBoxTamanhoRoupa.setBounds(380, 140, 90, 25);
        add(comboBoxTamanhoRoupa);
        
        //lista de materiais
        List<MaterialDTO> materiais = CentralDeInformacoes.getInstance().getMateriais();
        listModel = new DefaultListModel<>();
        for (MaterialDTO material : materiais) {
            if(material.isDisponivel()) {
            	listModel.addElement(material);
            }
        }
        
		ClienteDTO c = new ClienteDTO("João", 1L, "Rua ABC", 123456789L, true);
		CentralDeInformacoes.getInstance().getClientes().add(c);
		Persistencia.salvarCentral(CentralDeInformacoes.getInstance(), "central");
		jListMateriais = new JList<>(listModel);
	    jListMateriais.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	    JScrollPane scrollPaneMateriais = new JScrollPane(jListMateriais);
	    scrollPaneMateriais.setBounds(70, 170, 120, 100);
	    add(scrollPaneMateriais);

	    adicionarComponentesQuantidade();

	
        

        
	 // Lista de tipos de roupas
	    List<String> tiposRoupaStrings = new ArrayList<>();
	    tiposRoupaStrings.add("Vestido");
	    tiposRoupaStrings.add("Camiseta");
	    tiposRoupaStrings.add("Terno");
	    tiposRoupaStrings.add("Shorts");
	    tiposRoupaStrings.add("Meia");
	    tiposRoupaStrings.add("Calca");
	    tiposRoupaStrings.add("Blusa");
	    tiposRoupaStrings.add("Jaqueta");
	    tiposRoupaStrings.add("Outros");
	   

	    // JComboBox de tipos de roupas
	    comboBoxTipoRoupa = new JComboBox<>(tiposRoupaStrings.toArray(new String[0]));
	    comboBoxTipoRoupa.setBounds(70, 100, 120, 25);
	    add(comboBoxTipoRoupa);
	    

	    
	        
	  
		criarTabelaClientes();
		addB();
		addTexto(300,70,150,20,"Data de Entrega:");
		addBotaoDeVoltar();
		addWallpaper();
		adicionarCampoDaDataDeEntrega();
		setVisible(true);
		
		}

	
	private void adicionarCampoDaDataDeEntrega() {
		
		
		try {
			MaskFormatter mf = new MaskFormatter("##/##/####");
			campoDaData = new JFormattedTextField(mf);
			campoDaData.setBorder(new LineBorder(Color.BLACK, 1));
			campoDaData.setFont(Util.FONTE_PADRAO);
			campoDaData.setHorizontalAlignment(JTextField.CENTER);
			campoDaData.setBounds(300, 100, 170, 25);
			add(campoDaData);
		} catch (ParseException e) {}

	}
	private void criarPedidoDTO() {
		 // Verificar se a lista de materiais está vazia
	    if (jListMateriais.isSelectionEmpty()) {
	        JOptionPane.showMessageDialog(null, "Selecione pelo menos um material.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Obter os valores selecionados na lista de materiais
	    List<MaterialDTO> materiaisSelecionados = jListMateriais.getSelectedValuesList();

	    // Verificar se o tipo de roupa foi selecionado
	    Object tipoRoupaSelecionado = comboBoxTipoRoupa.getSelectedItem();
	    if (tipoRoupaSelecionado == null || tipoRoupaSelecionado.toString().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Selecione o tipo de roupa.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar se o tamanho de roupa foi selecionado
	    TamanhoRoupa tamanhoRoupaSelecionado = (TamanhoRoupa) comboBoxTamanhoRoupa.getSelectedItem();
	    if (tamanhoRoupaSelecionado == null) {
	        JOptionPane.showMessageDialog(null, "Selecione o tamanho de roupa.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Obter a quantidade do Spinner
	    int quantidade = (int) spinnerQuantidade.getValue();

	    // Verificar se a data foi preenchida
	    String datat = campoDaData.getText();
	    if (datat == null || datat.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Digite a data de entrega.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    // Parse da String para LocalDate
	    LocalDate data;
	    try {
	        data = LocalDate.parse(datat, formatter);
	    } catch (DateTimeParseException e) {
	        JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Verificar se um cliente foi selecionado na tabela
	    int selectedRow = tabelaClientes.getSelectedRow();
	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    ClienteDTO clienteSelecionado = clientes.get(selectedRow);
        
	    //Builder
	    PedidoDTO pedido = PedidoDTO.builder()
	            .descricao("Descrição do pedido")  
	            .dataEntrega(data)
	            .quantidade(quantidade)
	            .cliente(clienteSelecionado)
	            .tamanho(tamanhoRoupaSelecionado)
	            .materiais(materiaisSelecionados)
	            .tipoRoupa(tipoRoupaSelecionado)
	            .preco(preco)
	            .build();
	    
	    
       
        
        PedidoController pedidos = new PedidoController(this, pedido);
        pedidos.add();
        
        
    

        
	}
	
	private void addB() {
		JButton botao = new JButton("Cadastrar");
		botao.setBounds(225, 400, 100, 30);
		botao.setForeground(Color.BLACK);
		botao.setBackground(Color.WHITE);
		botao.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	obterPrecoDoUsuario();
	            	criarPedidoDTO();
	               
	            }
	        });
		
		add(botao);
	
	
	}
	private double obterPrecoDoUsuario() {
	    preco = 0.0;

	    // Mostrar um JOptionPane para obter o preço do usuário
	    String input = JOptionPane.showInputDialog("Digite o preço do produto:");
	    
	    // Tentar converter a entrada do usuário para um valor double
	    try {
	        preco = Double.parseDouble(input);
	    } catch (NumberFormatException e) {
	        // Tratar o caso em que a entrada não é um número válido
	        JOptionPane.showMessageDialog(null, "Por favor, digite um valor numérico válido para o preço.", "Erro", JOptionPane.ERROR_MESSAGE);
	    }

	    return preco;
	}

    private void criarTabelaClientes() {
        
        Object[][] dados = obterDadosClientes();
        String[] colunas = {"Nome", "Telefone", "Email"};

      
        DefaultTableModel model = new DefaultTableModel(dados, colunas);

   
        tabelaClientes = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tabelaClientes);
        scrollPane.setBounds(70, 300, 400, 80);

        
        add(scrollPane);
    }

    private Object[][] obterDadosClientes() {
        
        clientes = CentralDeInformacoes.getInstance().getClientes();

        Object[][] dados = new Object[clientes.size()][3];

       
        for (int i = 0; i < clientes.size(); i++) {
            ClienteDTO cliente = clientes.get(i);
            dados[i][0] = cliente.getNome();
            dados[i][1] = cliente.getTelefone();
            dados[i][2] = cliente.getEmail();
        }

        return dados;
    
    }


    private void adicionarComponentesQuantidade() {
        addTexto(300, 210, 150, 20, "Quantidade:");

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 400, 1); 
        spinnerQuantidade = new JSpinner(spinnerModel);
        spinnerQuantidade.setBounds(400, 210, 70, 25);
        add(spinnerQuantidade);
    }
    public static void main(String[]args) {
    	
    	
    	JanelaDeCadastraPedido j = new JanelaDeCadastraPedido();
	
    }
}

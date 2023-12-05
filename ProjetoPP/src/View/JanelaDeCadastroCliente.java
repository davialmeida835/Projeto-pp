package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controller.OuvinteCadastrarCliente;
import Controller.OuvinteDoCampoSomenteNumeros;
import Controller.OuvinteTipoDePessoaCadastroCliente;
import Controller.OuvinteTirarTextoDeTextField;
import DAO.ClienteDAO;
import DTO.ClienteDTO;
import Model.CentralDeInformacoes;

public class JanelaDeCadastroCliente extends JanelaPadrao {
	
	private JTextField campoDeEmail;
	private JTextField campoDoNome;
	private JTextField campoDoTelefone;
	private JTextField tipoDePessoa;
	private JRadioButton caixaDePessoaFisica;
	private JRadioButton caixaDePessoaJuridica;
	private JLabel pessoaFisica; //vai mudar para juridica ou fisica, mudar nome dps

	public static void main(String[] args) {
		new JanelaDeCadastroCliente(CentralDeInformacoes.getInstance().getClientes().get(0));
	}
	
	public JanelaDeCadastroCliente() {
		addTexto(0, 30, 550, 30, "Cadastro do Cliente", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		addTexto(125, 205, 65, 20, "E-mail:");
		addTexto(125, 260, 65, 20, "Nome:");
		addTexto(125, 315, 90, 20, "Telefone:");
		campoDeEmail = addCampoDeTexto(125, 230, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o e-mail do cliente");
		campoDoNome = addCampoDeTexto(125, 285, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o nome completo do cliente");
		addBotao(220, 400, 110, 30, "Cadastrar", new OuvinteCadastrarCliente(this));
		adicionarCampoDoTipoDePessoa();
		adicionarCampoDoTelefone();
		addBotoesDeTipoDePesso();
		addBotaoDeVoltar();
		
		setVisible(true);
	}
	
	public JanelaDeCadastroCliente(ClienteDTO cliente) {
		addTexto(0, 30, 550, 30, "Cadastro do Cliente", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		addTexto(125, 205, 65, 20, "E-mail:");
		addTexto(125, 260, 65, 20, "Nome:");
		addTexto(125, 315, 90, 20, "Telefone:");
		campoDeEmail = addCampoDeTextoSemOuvinte(125, 230, 300, 25, cliente.getEmail());
		campoDoNome = addCampoDeTextoSemOuvinte(125, 285, 300, 25, cliente.getNome());
		addBotao(220, 400, 110, 30, "Editar", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String nome = campoDoNome.getText();
				String telefone = campoDoTelefone.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
				String email = campoDeEmail.getText();

				String cpfOuCnpj = tipoDePessoa.getText();

				boolean flag = true;
				try {
					InternetAddress eValido = new InternetAddress(email);
					eValido.validate();
				} catch (AddressException a) {
					flag = false;
				}

				if (flag == false) {
					JOptionPane.showMessageDialog(null, "Digite um E-mail válido");
				} else if (nome.length() == 0) {
					JOptionPane.showMessageDialog(null, "Preencha o campo do nome");

				} else if (telefone.length() != 11) {
					JOptionPane.showMessageDialog(null, "Digite um número de telefone válido");
				} else if ((caixaDePessoaFisica.isSelected() && (cpfOuCnpj.length() != 11) || (caixaDePessoaJuridica.isSelected() && (cpfOuCnpj.length() != 14)))) {
					JOptionPane.showMessageDialog(null, "Digite um cpf ou cnpj válido");
				} 
				else {
					cliente.setCpfECnpj(Long.parseLong(cpfOuCnpj));
					cliente.setEmail(email);
					cliente.setNome(nome);
					cliente.setTelefone(Long.parseLong(telefone));
					
					JOptionPane.showMessageDialog(null, "Editado com sucesso");
					
					ClienteDAO gerenciar = new ClienteDAO();
					gerenciar.atualizarCliente(cliente);
					dispose();
					new JanelaDeCadastroCliente();
				}
			}
			
		});
		adicionarCampoDoTipoDePessoa();
		adicionarCampoDoTelefone();
		campoDoTelefone.setText(String.valueOf(cliente.getTelefone()));
		addBotoesDeTipoDePesso();
		tipoDePessoa.setEnabled(true);
		if(String.valueOf(cliente.getCpfECnpj()).length() == 11) {
			caixaDePessoaFisica.setSelected(true);
		}else {
			caixaDePessoaJuridica.setSelected(true);
		}
		addBotaoDeVoltar();
		tipoDePessoa.setText(String.valueOf(cliente.getCpfECnpj()));
		
		
		setVisible(true);
	}
	
	public JRadioButton getCaixaDePessoaJuridica() {
		return caixaDePessoaJuridica;
	}

	
	public JLabel getPessoaFisica() {
		return pessoaFisica;
	}
	
	public JTextField getCampoDeEmail() {
		return campoDeEmail;
	}

	public JTextField getCampoDoNome() {
		return campoDoNome;
	}

	public JTextField getCampoDoTelefone() {
		return campoDoTelefone;
	}

	public JTextField getTipoDePessoa() {
		return tipoDePessoa;
	}

	public JRadioButton getCaixaDePessoaFisica() {
		return caixaDePessoaFisica;
	}


	private void addBotoesDeTipoDePesso() {
		pessoaFisica = new JLabel("Escolha uma opção:");
		pessoaFisica.setBounds(125, 150, 190, 20);
		pessoaFisica.setFont(Model.Util.FONTE_PADRAO);
		pessoaFisica.setForeground(Color.WHITE);

		add(pessoaFisica);

		OuvinteTipoDePessoaCadastroCliente o = new OuvinteTipoDePessoaCadastroCliente(this);
		caixaDePessoaFisica = new JRadioButton("Pessoa Física");
		caixaDePessoaFisica.setOpaque(false);
		caixaDePessoaFisica.setForeground(Color.WHITE);
		caixaDePessoaFisica.setFont(Model.Util.FONTE_PADRAO);
		
		caixaDePessoaFisica.setBounds(120, 125, 160, 20);
		caixaDePessoaFisica.addActionListener(o);
		add(caixaDePessoaFisica);
		caixaDePessoaJuridica = new JRadioButton("Pessoa Jurídica");
		caixaDePessoaJuridica.setForeground(Color.WHITE);
		caixaDePessoaJuridica.setFont(Model.Util.FONTE_PADRAO);
		caixaDePessoaJuridica.setOpaque(false);
		caixaDePessoaJuridica.setBounds(280, 125, 165, 20);
		caixaDePessoaJuridica.addActionListener(o);
		add(caixaDePessoaJuridica);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(caixaDePessoaFisica);
		grupo.add(caixaDePessoaJuridica);

	}

	private void adicionarCampoDoTipoDePessoa() {
		tipoDePessoa = new JTextField("Digite o identificador do cliente");
		OuvinteDoCampoSomenteNumeros o = new OuvinteDoCampoSomenteNumeros();
		tipoDePessoa.addFocusListener(new OuvinteTirarTextoDeTextField("Digite o identificador do cliente"));
		tipoDePessoa.addKeyListener(o);
		tipoDePessoa.setBorder(new LineBorder(Color.BLACK, 1));
		tipoDePessoa.setFont(Model.Util.FONTE_PADRAO);
		tipoDePessoa.setEnabled(false);
		tipoDePessoa.setBounds(125, 175, 300, 25);
		add(tipoDePessoa);
	}

	private void adicionarCampoDoTelefone() {
		try {
			MaskFormatter mf = new MaskFormatter("(##) #####-####");
			campoDoTelefone = new JFormattedTextField(mf);
			campoDoTelefone.setBorder(new LineBorder(Color.BLACK, 1));
			campoDoTelefone.setFont(Model.Util.FONTE_PADRAO);
			campoDoTelefone.setHorizontalAlignment(JTextField.CENTER);
			campoDoTelefone.setBounds(125, 340, 150, 25);
			add(campoDoTelefone);
		} catch (ParseException e) {}
	}
	
	
}

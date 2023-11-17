package View;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controller.OuvinteTirarTextoDeTextField;
import ouvintes.OuvinteBotaoCadastrarCliente;
import ouvintes.OuvinteDoCampoSomenteNumeros;
import ouvintes.OuvinteTipoDePessoaCadastroCliente;

public class JanelaDeCadastroCliente extends JanelaPadrao {
	
	private JTextField campoDeEmail;
	private JTextField campoDoNome;
	private JTextField campoDoTelefone;
	private JTextField tipoDePessoa;
	private JRadioButton caixaDePessoaFisica;
	private JRadioButton caixaDePessoaJuridica;
	private JLabel pessoaFisica; //vai mudar para juridica ou fisica, mudar nome dps

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

	public JanelaDeCadastroCliente() {
		addTexto(0, 30, 550, 30, "Cadastro do Cliente", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.WHITE);
		addTexto(125, 205, 65, 20, "E-mail:");
		addTexto(125, 260, 65, 20, "Nome:");
		addTexto(125, 315, 90, 20, "Telefone:");
		campoDeEmail = addCampoDeTexto(125, 230, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o e-mail do cliente");
		campoDoNome = addCampoDeTexto(125, 285, 300, 25, new LineBorder(Color.BLACK, 1), "Digite o nome completo do cliente");
		addBotao(220, 400, 110, 30, "Cadastrar", new OuvinteBotaoCadastrarCliente(this));
		adicionarCampoDoTipoDePessoa();
		adicionarCampoDoTelefone();
		addBotoesDeTipoDePesso();
		addBotaoDeVoltar();
		
		setVisible(true);
	}

	private void addBotoesDeTipoDePesso() {
		pessoaFisica = new JLabel("Escolha uma opção:");
		pessoaFisica.setBounds(125, 150, 190, 20);
		pessoaFisica.setFont(Util.Util.FONTE_PADRAO);
		pessoaFisica.setForeground(Color.WHITE);

		add(pessoaFisica);

		OuvinteTipoDePessoaCadastroCliente o = new OuvinteTipoDePessoaCadastroCliente(this);
		caixaDePessoaFisica = new JRadioButton("Pessoa Física");
		caixaDePessoaFisica.setOpaque(false);
		caixaDePessoaFisica.setForeground(Color.WHITE);
		caixaDePessoaFisica.setFont(Util.Util.FONTE_PADRAO);
		
		caixaDePessoaFisica.setBounds(120, 125, 160, 20);
		caixaDePessoaFisica.addActionListener(o);
		add(caixaDePessoaFisica);
		caixaDePessoaJuridica = new JRadioButton("Pessoa Jurídica");
		caixaDePessoaJuridica.setForeground(Color.WHITE);
		caixaDePessoaJuridica.setFont(Util.Util.FONTE_PADRAO);
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
		tipoDePessoa.setFont(Util.Util.FONTE_PADRAO);
		tipoDePessoa.setEnabled(false);
		tipoDePessoa.setBounds(125, 175, 300, 25);
		add(tipoDePessoa);
	}

	private void adicionarCampoDoTelefone() {
		try {
			MaskFormatter mf = new MaskFormatter("(##) #####-####");
			campoDoTelefone = new JFormattedTextField(mf);
			campoDoTelefone.setBorder(new LineBorder(Color.BLACK, 1));
			campoDoTelefone.setFont(Util.Util.FONTE_PADRAO);
			campoDoTelefone.setHorizontalAlignment(JTextField.CENTER);
			campoDoTelefone.setBounds(125, 340, 150, 25);
			add(campoDoTelefone);
		} catch (ParseException e) {}
	}
	
}

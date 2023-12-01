package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controller.OuvinteDoBotaoDeVoltarParaMenu;

public class JanelaDeCadastroFornecedor extends JanelaPadrao{
	
	private JTextField campoNome;
    private JTextField campoTelefone;
    private JTextArea areaMateriais;

    public JanelaDeCadastroFornecedor() {
        addTexto(0, 10, 550, 30, "Cadastro do Fornecedor", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);

        addTexto(125, 120, 250, 20, "Nome do Fornecedor:");
        campoNome = new JTextField();
        campoNome.setBounds(125, 145, 300, 20);
        add(campoNome);

        addTexto(125, 175, 150, 20, "Telefone:");
        adicionarCampoDoTelefone();

        addTexto(125, 230, 250, 20, "Materiais Fornecidos:");
        areaMateriais = new JTextArea();
        areaMateriais.setBounds(125, 255, 300, 100);
        add(areaMateriais);

        
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(220, 400, 110, 30);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarFornecedor();
            }
        });
        add(botaoCadastrar);
       
        addBotaoDeVoltar();

        setVisible(true);
    }

    private void cadastrarFornecedor() {
        
        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();
        String materiais = areaMateriais.getText();

        
        System.out.println("Fornecedor cadastrado:");
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Materiais Fornecidos: " + materiais);

        
        campoNome.setText("");
        campoTelefone.setText("");
        areaMateriais.setText("");
    }
    private void adicionarCampoDoTelefone() {
		try {
			MaskFormatter mf = new MaskFormatter("(##) #####-####");
			campoTelefone = new JFormattedTextField(mf);
			campoTelefone.setBorder(new LineBorder(Color.BLACK, 1));
			campoTelefone.setFont(Model.Util.FONTE_PADRAO);
			campoTelefone.setHorizontalAlignment(JTextField.CENTER);
			campoTelefone.setBounds(125, 200, 150, 20);
			add(campoTelefone);
		} catch (ParseException e) {}
	}

   
    public static void main(String[] args) {
        new JanelaDeCadastroFornecedor();
    }

}

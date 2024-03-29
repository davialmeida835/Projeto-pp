package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.CentralDeInformacoes;
import Model.DadosInvalidosException;
import Model.Usuario;
import Model.Validar;
import View.JanelaDeCadastroUsuario;
import View.JanelaDeLogin;

public class UsuarioController implements ActionListener{

	private JanelaDeCadastroUsuario janelaDeCadastro;

	public UsuarioController(JanelaDeCadastroUsuario janelaDeCadastro) {
		this.janelaDeCadastro = janelaDeCadastro;
	}

	//valida os dados e faz o cadastro no aplicativo
	public void actionPerformed(ActionEvent e) {
		
		String email = janelaDeCadastro.getCampoDeEmail().getText();
		String senha = new String(janelaDeCadastro.getCampoDaSenha().getPassword());
		String nome = janelaDeCadastro.getCampoDoNome().getText();
		String telefone = janelaDeCadastro.getCampoDoTelefone().getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", "");
		String data = janelaDeCadastro.getCampoDoNatalicio().getText();
		try {
			Validar.validarDados(email, senha, nome, telefone, data);
			CentralDeInformacoes central = CentralDeInformacoes.getInstance();
			Usuario usuario = new Usuario(email, senha, nome, telefone, data);
			central.setUsuario(usuario);
			Persistencia.salvarCentral(central, "central");
			new JanelaDeLogin();
			janelaDeCadastro.dispose();
		} catch (DadosInvalidosException e1) {
			JOptionPane.showMessageDialog(janelaDeCadastro, e1.getMessage());
		}
	}
}


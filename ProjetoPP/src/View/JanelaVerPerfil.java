package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.CentralDeInformacoes;
import Model.Usuario;

public class JanelaVerPerfil extends JanelaPadrao{
	
	public JanelaVerPerfil() {
		addTexto(0, 10, 550, 30, "Perfil do Usuário", new Font("Arial", Font.BOLD, 17), JLabel.CENTER, Color.BLACK);
		addBotaoDeVoltar();
		addU();
		addIconeTelaCadastroELogin();
		setVisible(true);
	}
	public void addU() {
		CentralDeInformacoes central = CentralDeInformacoes.getInstance();
		Usuario u = central.getUsuario();
		addTexto(75,180,350,20,"Nome: "+u.getNome());
		addTexto(75,230,350,20,"Email: "+u.getEmail());
		addTexto(75,280,350,20,"Telefone: "+u.getTelefone());
		addTexto(75,330,350,20,"Data de Nascimento: "+u.getDataDeNascimento());
	}
	public static void main(String [] args ){
	JanelaVerPerfil j = new JanelaVerPerfil();
}
}

package Model;


import java.util.ArrayList;
import java.util.List;

public class CentralDeInformacoes {

	private Usuario usuario;
	private List<Cliente> clientes = new ArrayList<>();
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void addCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
}

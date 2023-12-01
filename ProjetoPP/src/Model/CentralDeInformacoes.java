package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.Persistencia;
import DTO.ClienteDTO;
import DTO.FornecedorDTO;

public class CentralDeInformacoes {

	private volatile static CentralDeInformacoes instance;

	private CentralDeInformacoes() {
	};

	private Usuario usuario;
	private List<ClienteDTO> clientes = new ArrayList<>();
	private List<Material> materiais = new ArrayList<>();
	private List<FornecedorDTO> fornecedores = new ArrayList<>();
	private List<Gasto> gastos = new ArrayList<>();
	
	
	public static CentralDeInformacoes getInstance() {
		if (instance == null) {
			synchronized (CentralDeInformacoes.class) {
				if (instance == null && Persistencia.recuperarCentral("central") == null) {
					instance = new CentralDeInformacoes();
				}
				else {
					instance = Persistencia.recuperarCentral("central");
				}
			}
		}
		return instance;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addCliente(ClienteDTO cliente) {
		clientes.add(cliente);
	}

	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	public void addMaterial(Material material) {
		materiais.add(material);
	}

	public List<Material> getMateriais() {
		return materiais;
	}
	public void addFornecedor(FornecedorDTO fornecedor) {
        fornecedores.add(fornecedor);
    }

    public List<FornecedorDTO> getFornecedores() {
        return fornecedores;
    }
    
    
}

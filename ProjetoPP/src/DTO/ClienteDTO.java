package DTO;

public class ClienteDTO {

	private String nome;
	private long telefone;
	private String email;
	private long cpfECnpj;
	private boolean desejaReceberEmail;
	private long id;
	
	public ClienteDTO(String nome, long telefone, String email, long cpfECnpj, boolean receberEmail) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpfECnpj = cpfECnpj;
		this.desejaReceberEmail = receberEmail;
		id = System.currentTimeMillis();
	}

	public long getId() {
		return id;
	}
	
	public long getCpfECnpj() {
		return cpfECnpj;
	}

	public void setCpfECnpj(long cpfECnpj) {
		this.cpfECnpj = cpfECnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getDesejaReceberEmail() {
		return desejaReceberEmail;
	}

	public void setDesejaReceberEmail(boolean desejaReceberEmail) {
		this.desejaReceberEmail = desejaReceberEmail;
	}
	
}

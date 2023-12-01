package Model;

public abstract class Cliente {

	private String nome;
	private long telefone;
	private String email;
	private long cpfECnpj;
	
	public Cliente(String nome, long telefone, String email, long cpfECnpj) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpfECnpj = cpfECnpj;
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
	
}

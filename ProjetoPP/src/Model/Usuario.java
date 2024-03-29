package Model;

public class Usuario {
	
	private String email;
	private String senha;
	private String nome;
	private String telefone;
	private String dataDeNascimento;
	
	public Usuario(String email, String senha, String nome, String telefone, String data) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
		this.dataDeNascimento = data;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

}

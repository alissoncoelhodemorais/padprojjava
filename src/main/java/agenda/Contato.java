package agenda;

public class Contato {

	private String telefone;
	private String nome;
	protected Integer id;

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String string) {
		this.nome = string;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer int1) {
		this.id = int1;
		
	}

}

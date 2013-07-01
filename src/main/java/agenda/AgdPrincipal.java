package agenda;

import java.util.List;

public class AgdPrincipal {

	public List<Contato> listarTodos() {
		return new DadosControlador().listarTodos();
	}

	public void incluir(String string, String string2) {
		new DadosControlador().incluir(string, string2);
		
	}

	public ContatoModel recuperar(int id) {
		ContatoModel con = new DadosControlador().recuperar(id);
		return con;
	}

	public void alterar(Integer id, String nome, String telefone) {
		new DadosControlador().alterar(id, nome, telefone);
		
	}

	public void excluir(Integer id) {
		new DadosControlador().excluir(id);
		
	}

	public List<Contato> pesquisarNome(String string) {
		List<Contato> ret = new DadosControlador().pesquisarNome(string);
		return ret;
	}
	
}

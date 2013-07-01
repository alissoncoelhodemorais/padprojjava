package agenda;

import java.util.List;

public class DadosControlador {

	public List<Contato> listarTodos() {
		return new ContatoMapper().fetchAll();
	}

	public void incluir(String nome, String tel) {
		ContatoModel cm = new ContatoModel();
		cm.setNome(nome);
		cm.setTelefone(tel);
		cm.save();
	}

	public ContatoModel recuperar(int id) {
		ContatoModel con = new ContatoModel(id);
		return con;
	}

	public void alterar(Integer id, String nome, String telefone) {
		ContatoModel con = new ContatoModel(id);
		con.setNome(nome);
		con.setTelefone(telefone);
		con.save();
	}

	public void excluir(Integer id) {
		ContatoModel con = new ContatoModel(id);
		con.remove();
	}

	public List<Contato> pesquisarNome(String string) {
		List<Contato> ret = new ContatoMapper().findByNome(string);
		return ret;
	}

}

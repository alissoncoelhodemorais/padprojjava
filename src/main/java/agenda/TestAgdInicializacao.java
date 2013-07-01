package agenda;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestAgdInicializacao {

	@Test
	public void a0testCriaTabePrimCone() { // NAO RENOMEAR POIS PRECISA SER EXECUTADO POR PRIMEIRO
		List<Contato> todos = new AgdPrincipal().listarTodos();
		assertEquals(0, todos.size());
	}

	@Test
	public void z1testInclusao() {
		String nome = "Incluido";
		new AgdPrincipal().incluir(nome, "9929");

		boolean achou = false;

		List<Contato> todos = new AgdPrincipal().listarTodos();
		for (Contato contato : todos) {
			if (contato.getNome().equals(nome)) {
				achou = true;
				break;
			}
		}

		assertTrue(achou);
	}

	@Test
	public void z2testAlteracao() {
		String nome = "Alterado";
		new AgdPrincipal().incluir(nome, "992");

		Integer id = null;

		List<Contato> todos = new AgdPrincipal().listarTodos();
		for (Contato contato : todos) {
			if (contato.getNome().equals(nome)) {
				id = contato.getId();
				break;
			}
		}

		String telefone = "3027";
		new AgdPrincipal().alterar(id, nome, telefone);

		ContatoModel ali = new AgdPrincipal().recuperar(id);

		assertEquals(telefone, ali.getTelefone());

	}

	@Test
	public void z3testExclusao() {
		String nome = "Excluído";
		new AgdPrincipal().incluir(nome, "555");

		Integer id = null;

		List<Contato> todos = new AgdPrincipal().listarTodos();
		for (Contato contato : todos) {
			if (contato.getNome().equals(nome)) {
				id = contato.getId();
				break;
			}
		}
		
		new AgdPrincipal().excluir(id);

		boolean achou = false;

		todos = new AgdPrincipal().listarTodos();
		for (Contato contato : todos) {
			if (contato.getNome().equals(nome)) {
				achou = true;
				break;
			}
		}

		assertFalse(achou);
	}

	@Test
	public void z4testPesquisa() {
		new AgdPrincipal().incluir("Marco", "19929");
		new AgdPrincipal().incluir("Marcos", "29929");
		
		List<Contato> todos = new AgdPrincipal().pesquisarNome("arco");
		assertEquals(2, todos.size());
	}

}

package cadastrodeclientes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestCadastroDeClientes {

	@Test
	public void testPesquisarPorCpf() {
		CadastroDeClientes cad = new CadastroDeClientes();
		Cliente cli = cad.pesquisarPorCpf("553456789100");
		assertEquals("Zezinho", cli.getNome());
	}

	@Test
	public void testListar() {
		CadastroDeClientes cad = new CadastroDeClientes();
		List<Cliente> lista = cad.listar();
		assertTrue(lista.size() == 3);
	}

}

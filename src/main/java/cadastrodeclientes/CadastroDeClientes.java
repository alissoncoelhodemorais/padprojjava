package cadastrodeclientes;

import java.io.File;
import java.util.List;

public class CadastroDeClientes {

	public CadastroDeClientes() {
		new LeitorClientesXml(new File(".").getAbsolutePath().replace(".", "src/main/java/") + CadastroDeClientes.class.getName().replace('.', '/').replace("CadastroDeClientes", "") + "cadastro.xml");
	}

	public Cliente pesquisarPorCpf(String cpf) {
		Cliente cliente = ClienteRegistry.getInstance().get(cpf);
		return cliente;
	}

	public List<Cliente> listar() {
		List<Cliente> clientes = ClienteRegistry.getInstance().listar();
		return clientes;
	}


}

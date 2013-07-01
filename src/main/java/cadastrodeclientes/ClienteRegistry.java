package cadastrodeclientes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClienteRegistry {
	private static ClienteRegistry instance = null;
	private HashMap<String, Cliente> registry = new HashMap<String, Cliente>();

	private ClienteRegistry() {
	};

	public static ClienteRegistry getInstance() {
		if (instance == null) {
			instance = new ClienteRegistry();
		}
		return instance;
	}

	public void set(String key, Cliente value) {
		instance.registry.put(key, value);
	}

	public Cliente get(String key) {
		return instance.registry.get(key);
	}

	public List<Cliente> listar() {
		List<Cliente> retorno = new ArrayList<Cliente>(registry.values());
		
		return retorno;
	}
}
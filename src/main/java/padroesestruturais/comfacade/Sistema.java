package padroesestruturais.comfacade;

public class Sistema {

	private ConfiguracaoAplicacao config;

	public Sistema(ConfiguracaoAplicacao config) {
		this.config = config;
		configurar();
	}

	private void configurar() {
		System.out.println("Sistema configurado para acessar o seguinte banco: " + config.getAdaptador());
		
	}

	public boolean usuarioPossuiPermissao() {
		return true;
	}

}

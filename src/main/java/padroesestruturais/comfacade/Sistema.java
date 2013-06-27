package padroesestruturais.comfacade;

public class Sistema {

	private ConfiguracaoAplicacao config;

	public Sistema(ConfiguracaoAplicacao config) {
		this.config = config;
		configurar();
	}

	private void configurar() {
		System.out.println("Sistema configurado com o seguinte para acessar um banco: " + config.getAdaptador());
		
	}

	public boolean usuarioPossuiPermissao() {
		return false;
	}

}

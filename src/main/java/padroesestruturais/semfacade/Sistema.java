package padroesestruturais.semfacade;

public class Sistema {

	private ConfiguracaoAplicacao config;

	public Sistema(ConfiguracaoAplicacao config) {
		this.config = config;
		configurar();
	}

	private void configurar() {
		System.out.println("Preparado para usar o seguinte adaptador: " + config.getAdaptador());
		
	}

	public void exibirMenu() {
		System.out.println("exibindo menu");
		
	}

}

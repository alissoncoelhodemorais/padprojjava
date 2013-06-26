package padroesestruturais.semfacade;

public class ConfiguracaoAplicacao {

	private static ConfiguracaoAplicacao singleton = null;

	private String adaptador;
	private String nomeBanco;

	private ConfiguracaoAplicacao() {
	}

	public static ConfiguracaoAplicacao getInstance() {
		if (singleton == null) {
			singleton = new ConfiguracaoAplicacao();
		}

		return singleton;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setAdaptador(String property) {
		this.adaptador = property;

	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getAdaptador() {
		return adaptador;
	}

}

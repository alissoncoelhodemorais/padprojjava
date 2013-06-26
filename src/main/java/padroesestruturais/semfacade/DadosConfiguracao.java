package padroesestruturais.semfacade;

public class DadosConfiguracao {

	private String adapter;
	private String dbName;

	public String getAdapter() {
		return adapter;
	}

	public void setAdapter(String adaptador) {
		this.adapter = adaptador;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String nomeBanco) {
		this.dbName = nomeBanco;
	}

}

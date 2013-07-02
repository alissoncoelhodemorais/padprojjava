package padroesestruturais.comfacade;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HelperAplicacao {
	
	public Properties carregarProperties() throws IOException {
		File file = new File(".");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath().replace(".", "src/main/java/") + HelperAplicacao.class.getName().replace('.', '/').replace("HelperAplicacao", "") + "dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fis);
		return properties;
	}

	public void validarConfiguracao() throws Exception {
		Verificadora verificadora = new Verificadora();
		boolean possuiRequisitosMinimos = verificadora.possuiRequisitosMinimos();
		boolean existeBancoDados = verificadora.existeBancoDados();
		if (possuiRequisitosMinimos == false || existeBancoDados == false)
			throw new Exception("Nao possui os requisitos minimos.");

		
	}

	public ConfiguracaoAplicacao configurar(DadosConfiguracao dados) {
		ConfiguracaoAplicacao config = ConfiguracaoAplicacao.getInstance();
		config.setAdaptador(dados.getAdapter());
		config.setNomeBanco(dados.getDbName());
		return config;
	}

	public DadosConfiguracao popular(Properties properties) {
		DadosConfiguracao dados = new DadosConfiguracao();
		dados.setAdapter(properties.getProperty("adapter"));
		dados.setDbName(properties.getProperty("dbname"));
		return dados;
	}

	
}

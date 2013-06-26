package padroesestruturais.comfacade;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Aplicacao {
	
	public void exibirMenu() {
		// como vai ser singleton? TODO
	}

	private Properties carregarProperties() throws IOException {
		File file = new File(".");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath().replace(".", "src/") + Aplicacao.class.getName().replace('.', '/').replace("Aplicacao", "") + "dbconfig.properties");
		Properties properties = new Properties();
		properties.load(fis);
		return properties;
	}

	public void iniciar() {

		// processo de inicialização.

		try {
			// lê arquivo de configuração
			Properties properties = carregarProperties();
			

			// e armazena dados em uma classe.
			DadosConfiguracao dados = new DadosConfiguracao();
			dados.setAdapter(properties.getProperty("adapter"));
			dados.setDbName(properties.getProperty("dbname"));

			// * Depois, ela recupera os dados dessa classe e configura os
			// atributos
			// * de uma classe que ficará persistente durante toda a aplicação.
			ConfiguracaoAplicacao config = ConfiguracaoAplicacao.getInstance();
			config.setAdaptador(dados.getAdapter());
			config.setNomeBanco(dados.getDbName());

			// Em seguida, uma terceira classe é instanciada e executa algumas
			// tarefas,
			// como verificação dos requisitos mínimos de funcionamento e
			// existência
			// do banco de dados.
			Verificadora verificadora = new Verificadora();
			boolean possuiRequisitosMinimos = verificadora.possuiRequisitosMinimos();
			boolean existeBancoDados = verificadora.existeBancoDados();
			if (possuiRequisitosMinimos == false || existeBancoDados == false)
				throw new Exception("Nao possui os requisitos minimos.");

			// Finalmente, se tudo isso funcionar, a classe
			// * principal do sistema é instanciada, recebe a instância do
			// objeto de
			// * configuração
			Sistema sistema = new Sistema(config);

			// apresenta o menu da aplicação.
			sistema.exibirMenu();
			
		} catch (Exception e) {
			System.out.println("Ocorreu uma excecao" + e.getMessage());
		}

	}

}

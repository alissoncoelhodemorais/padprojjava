package padroesestruturais.semfacade;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Aplicacao {

	public void exibirMenu() {

		// processo de inicialização.

		try {
			// lê arquivo de configuração
			File file = new File(".");
			FileInputStream fis = new FileInputStream(file.getAbsolutePath().replace(".", "src/") + Aplicacao.class.getName().replace('.', '/').replace("Aplicacao", "") + "dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fis);

			// e armazena dados em uma classe.
			DadosConfiguracao pdados = new DadosConfiguracao();
			pdados.setAdapter(properties.getProperty("adapter"));
			pdados.setDbName(properties.getProperty("dbname"));
			
			// * Depois, ela recupera os dados dessa classe e configura os atributos
			// * de uma classe que ficará persistente durante toda a aplicação.
			ConfiguracaoAplicacao dados = ConfiguracaoAplicacao.getInstance();
			dados.setAdaptador(pdados.getAdapter());
			dados.setNomeBanco(pdados.getDbName());

			
//			Em
			// * seguida, uma terceira classe é instanciada e executa algumas
			// tarefas,
			// * como verificação dos requisitos mínimos de funcionamento e
			// existência
			// * do banco de dados. Finalmente, se tudo isso funcionar, a classe
			// * principal do sistema é instanciada, recebe a instância do objeto de
			// * configuração e apresenta o menu da aplicação. Esse processo todo,
			// * ficando dentro de um único método, ou dentro de uma única classe,
			// * fica muito complicado de se entender. O ideal é que a aplicação
			// * chamasse apenas um método iniciar() de uma classe e ele
			// encapsulasse
			// * tudo isso.


		} catch (Exception e) {
			System.out.println("Ocorreu uma excecao" + e.getMessage());
		}


	}

}

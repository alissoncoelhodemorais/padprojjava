package padroesestruturais.comfacade;

import java.util.Properties;

public class Aplicacao {

	private Sistema sistema;

	public void exibirMenu() {
		// como vai ser singleton? TODO
		iniciar();

		if (sistema.usuarioPossuiPermissao())
			System.out.println("exibindo menu");
		else 
			System.out.println("Usuário não acesso a essa funcionalidade!");
			
	}

	public void iniciar() {

		HelperAplicacao helper = new HelperAplicacao();

		// processo de inicialização.

		try {
			// lê arquivo de configuração
			Properties properties = helper.carregarProperties();

			// e armazena dados em uma classe.
			DadosConfiguracao dados = helper.popular(properties);

			// * Depois, ela recupera os dados dessa classe e configura os
			// atributos
			// * de uma classe que ficará persistente durante toda a aplicação.
			ConfiguracaoAplicacao config = helper.configurar(dados);

			// Em seguida, uma terceira classe é instanciada e executa algumas
			// tarefas,
			// como verificação dos requisitos mínimos de funcionamento e
			// existência
			// do banco de dados.
			helper.validarConfiguracao();

			sistema = new Sistema(config);

		} catch (Exception e) {
			System.out.println("Ocorreu uma excecao" + e.getMessage());
		}

	}

}

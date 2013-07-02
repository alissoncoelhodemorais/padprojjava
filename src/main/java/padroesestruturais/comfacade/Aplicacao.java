package padroesestruturais.comfacade;

import java.util.Properties;

public class Aplicacao {

	private Sistema sistema;

	public void exibirMenu() {
		// No segundo pacote, você irá refatorar o que fez no primeiro, colocando toda a implementação da inicialização dentro do
		// método iniciar() da classe Aplicacao, que deve ser executado antes do método exibirMenu()
		if (getSistema().usuarioPossuiPermissao())
			System.out.println("Exibindo menu...");
		else 
			System.out.println("Usuário não tem acesso a essa funcionalidade!");
			
	}

	/** 
	 * Assegura que o sistema foi iniciado
	 * @return instancia do sistema iniciada
	 */
	private Sistema getSistema() {
		if (sistema == null);
			iniciar();
		return sistema;
	}

	/**
	 * Inicia o sistema, essa lógica poderia ficar toda no helper, mas o exercício pede que seja na classe Aplicacao, conforme
	 * enunciado: "No segundo pacote, você irá refatorar o que fez no primeiro, colocando toda a implementação da inicialização 
	 * dentro do método iniciar() da classe Aplicacao, que deve ser executado antes do método exibirMenu()"
	 */
	private void iniciar() {
		System.out.println("Iniciando sistema...");

		HelperAplicacao helper = new HelperAplicacao();

		// processo de inicialização.

		try {
			// lê arquivo de configuração
			Properties properties = helper.carregarProperties();

			// e armazena dados em uma classe.
			DadosConfiguracao dados = helper.popular(properties);

			// recupera os dados dessa classe e configura os atributos
			// de uma classe que ficará persistente durante toda a aplicação.
			ConfiguracaoAplicacao config = helper.configurar(dados);

			// uma terceira classe é instanciada e executa algumas tarefas,
			// como verificação dos requisitos mínimos de funcionamento e
			// existência do banco de dados.
			helper.validarConfiguracao();

			sistema = new Sistema(config);
			
			System.out.println("Sistema iniciado!");

		} catch (Exception e) {
			System.out.println("Ocorreu um problema ao iniciar o sistema: " + e.getMessage());
		}

	}
	
	public static void main(String[] args) {
		new Aplicacao().exibirMenu();
	}

}

package padroesdecriacao.abstractfactory;

public class ApresentacaoDocumento implements IDocumento {

	private String conteudo;

	public ApresentacaoDocumento(String conteudo) {
		this.conteudo = conteudo;
	}

	public void criar() {
		System.out.println("a apresentacao foi criada com o seguinte conteudo: " + conteudo);
	}

}

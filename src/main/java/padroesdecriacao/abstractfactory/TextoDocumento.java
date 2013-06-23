package padroesdecriacao.abstractfactory;

public class TextoDocumento implements IDocumento {

	private String conteudo;

	public TextoDocumento(String conteudo) {
		this.conteudo = conteudo;
	}

	public void criar() {
		System.out.println("o texto foi criado com o seguinte conteudo: " + conteudo);
	}
}

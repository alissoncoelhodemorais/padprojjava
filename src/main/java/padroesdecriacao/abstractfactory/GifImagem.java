package padroesdecriacao.abstractfactory;

public class GifImagem implements IImagem {

	private String conteudo;

	public GifImagem(String conteudo) {
		this.conteudo = conteudo;
	}

	public void criar() {
		System.out.println("o GIF foi criado com o seguinte conteudo: " + conteudo);
	}
}

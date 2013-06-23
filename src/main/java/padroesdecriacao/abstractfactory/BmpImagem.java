package padroesdecriacao.abstractfactory;

public class BmpImagem implements IImagem {

	private String conteudo;

	public BmpImagem(String conteudo) {
		this.conteudo = conteudo;
	}

	public void criar() {
		System.out.println("o BMP foi criado com o seguinte conteudo: " + conteudo);
	}

}

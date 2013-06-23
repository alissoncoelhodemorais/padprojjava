package padroesdecriacao.abstractfactory;

public class JpgImagem implements IImagem {

	private String conteudo;

	public JpgImagem(String conteudo) {
		this.conteudo = conteudo;
	}

	public void criar() {
		System.out.println("o JPG foi criado com o seguinte conteudo: " + conteudo);
	}
}

package padroesdecriacao.abstractfactory;

import java.io.File;

public class GifImagem implements IImagem {

	private String conteudo;

	public GifImagem(String conteudo) {
		this.conteudo = conteudo;
	}

	public File criar() {
		System.out.println("o GIF foi criado com o seguinte conteudo: " + conteudo);
		File arquivo = new File("/tmp/padprojjava.gif");
		return arquivo;
	}
}

package padroesdecriacao.abstractfactory;

import java.io.File;

public class BmpImagem implements IImagem {

	private String conteudo;

	public BmpImagem(String conteudo) {
		this.conteudo = conteudo;
	}

	public File criar() {
		System.out.println("o BMP foi criado com o seguinte conteudo: " + conteudo);
		File arquivo = new File("/tmp/padprojjava.bmp");
		return arquivo;
	}

}

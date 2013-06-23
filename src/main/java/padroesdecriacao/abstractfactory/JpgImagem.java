package padroesdecriacao.abstractfactory;

import java.io.File;

public class JpgImagem implements IImagem {

	private String conteudo;

	public JpgImagem(String conteudo) {
		this.conteudo = conteudo;
	}

	public File criar() {
		System.out.println("o JPG foi criado com o seguinte conteudo: " + conteudo);
		File arquivo = new File("/tmp/padprojjava.jpg");
		return arquivo;
	}
}

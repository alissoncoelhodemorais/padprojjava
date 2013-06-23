package padroesdecriacao.abstractfactory;

import java.io.File;

public class TextoDocumento implements IDocumento {

	private String conteudo;

	public TextoDocumento(String conteudo) {
		this.conteudo = conteudo;
	}

	public File criar() {
		System.out.println("o texto foi criado com o seguinte conteudo: " + conteudo);
		File arquivo = new File("/tmp/padprojjava.odt");
		return arquivo;
	}
}

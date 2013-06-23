package padroesdecriacao.abstractfactory;

import java.io.File;

public class ApresentacaoDocumento implements IDocumento {

	private String conteudo;

	public ApresentacaoDocumento(String conteudo) {
		this.conteudo = conteudo;
	}

	public File criar() {
		System.out.println("a apresentacao foi criada com o seguinte conteudo: " + conteudo);
		File arquivo = new File("/tmp/padprojjava.odp");
		return arquivo;
	}

}

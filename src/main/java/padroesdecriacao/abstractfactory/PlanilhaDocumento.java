package padroesdecriacao.abstractfactory;

import java.io.File;

public class PlanilhaDocumento implements IDocumento {

	private String conteudo;

	public PlanilhaDocumento(String conteudo) {
		this.conteudo = conteudo;
	}

	public File criar() {
		System.out.println("a planilha foi criada com o seguinte conteudo: " + conteudo);
		File arquivo = new File("/tmp/padprojjava.ods");
		return arquivo;
	}

}

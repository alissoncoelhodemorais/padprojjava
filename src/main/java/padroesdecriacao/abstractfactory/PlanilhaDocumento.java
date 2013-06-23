package padroesdecriacao.abstractfactory;

public class PlanilhaDocumento implements IDocumento {

	private String conteudo;

	public PlanilhaDocumento(String conteudo) {
		this.conteudo = conteudo;
	}

	public void criar() {
		System.out.println("a planilha foi criada com o seguinte conteudo: " + conteudo);
	}

}

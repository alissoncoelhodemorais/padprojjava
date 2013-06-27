package padroesdelogicadedominio;

/**
 * A classe CondicaoGeral representa as condições que governam todos os seguros de um determinado ramo. Isso inclui as restrições de
 * pagamento do seguro.
 * 
 * @author 00737990929
 * 
 */
public class CondicaoGeral {

	private boolean podeReceberIndenizacao;

	public CondicaoGeral() {
	}

	public void setPodeReceberIndenizacao(boolean b) {
		this.podeReceberIndenizacao = b;
	}

	public boolean isPodeReceberIndenizacao() {
		return podeReceberIndenizacao;
	}

}

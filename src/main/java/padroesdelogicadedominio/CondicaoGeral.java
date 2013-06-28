package padroesdelogicadedominio;

/**
 * A classe CondicaoGeral representa as condições que governam todos os seguros de um determinado ramo. Isso inclui as restrições de
 * pagamento do seguro.
 * 
 * @author 00737990929
 * 
 */
public class CondicaoGeral implements ICondicaoProposta {

	private boolean podeReceberIndenizacao;

	public CondicaoGeral() {
	}

	/* (non-Javadoc)
	 * @see padroesdelogicadedominio.ICondicaoProposta#setPodeReceberIndenizacao(boolean)
	 */
	@Override
	public void setPodeReceberIndenizacao(boolean b) {
		this.podeReceberIndenizacao = b;
	}

	/* (non-Javadoc)
	 * @see padroesdelogicadedominio.ICondicaoProposta#isPodeReceberIndenizacao()
	 */
	@Override
	public boolean isPodeReceberIndenizacao() {
		return podeReceberIndenizacao;
	}

}

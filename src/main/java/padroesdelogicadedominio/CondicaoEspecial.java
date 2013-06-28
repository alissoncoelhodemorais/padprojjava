package padroesdelogicadedominio;

/**
 * A classe CondicaoEspecial está relacionada diretamente com Proposta. A classe CondicaoEspecial representa as condições
 * específicas para uma proposta de seguro. Elas podem afetar as restrições impostas pelas condições gerais, permitindo o pagamento
 * quando as primeiras o negam e negando-o quando as primeiras o autorizam.
 * 
 * @author 00737990929
 * 
 */
public class CondicaoEspecial implements ICondicaoProposta {

	private boolean isPodeReceberIndenizacao;

	public CondicaoEspecial() {
	}

	public void setPodeReceberIndenizacao(boolean b) {
		this.isPodeReceberIndenizacao = b;
	}

	public boolean isPodeReceberIndenizacao() {
		return isPodeReceberIndenizacao;
	}

}

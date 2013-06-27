package padroesdelogicadedominio;

/**
 * A classe CondicaoEspecial está relacionada diretamente com Proposta. A classe Proposta informa se o cliente aceitou ou não a
 * proposta. A classe CondicaoEspecial representa as condições específicas para uma proposta de seguro. Elas podem afetar as
 * restrições impostas pelas condições gerais, permitindo o pagamento quando as primeiras o negam e negando-o quando as primeiras o
 * autorizam.
 * 
 * @author 00737990929
 * 
 */
public class CondicaoEspecial {

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

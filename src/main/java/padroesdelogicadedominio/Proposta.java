package padroesdelogicadedominio;

/**
 * A classe Proposta representa a proposta feita para um cliente. A classe Proposta informa se o cliente aceitou ou não a
 * proposta.
 * @author 00737990929
 *
 */
public class Proposta {

	private boolean aceita;

	public Proposta() {
	}

	public void setAceita(boolean b) {
		this.aceita = b;
	}

	public boolean isAceita() {
		return aceita;
	}

}
